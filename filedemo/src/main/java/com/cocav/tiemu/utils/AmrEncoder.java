package com.cocav.tiemu.utils;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

import java.io.IOException;

/**
 * Created by kv.h on 14/11/21.
 */
public class AmrEncoder
{
    private static AmrEncoder _encoder;
    private AudioRecord recorder;
    private long _seconds;

    public interface Callback
    {
        void onEncoded(byte[] buffer, long millsec, int dbs);

        void onEnd();
    }

    public enum Mode
    {
        MR475, /* 4.75 kbps */
        MR515, /* 5.15 kbps */
        MR59, /* 5.90 kbps */
        MR67, /* 6.70 kbps */
        MR74, /* 7.40 kbps */
        MR795, /* 7.95 kbps */
        MR102, /* 10.2 kbps */
        MR122, /* 12.2 kbps */
        MRDTX, /* DTX */
        N_MODES /* Not Used */
    }

    //    private native void init(int dtx);
    //
    //    private native int encode(int mode, short[] in, byte[] out);
    //
    //    private native void reset();
    //
    //    private native void exit();

    //    static
    //    {
    //        AmrDecoder.initialize(); //Only Load .so in 1 time.
    //    }

    public boolean _running = false;
    private boolean _release;

    public static AmrEncoder getInstance()
    {
        if (_encoder == null)
        {
            _encoder = new AmrEncoder();
        }
        return _encoder;
    }

    private AmrEncoder()
    {
        _release = true;
    }

    public synchronized boolean start(final Callback callback)
    {
        if (!_release)
        {
            return false;
        }
        _seconds = 0;
        _release = false;
        _running = true;
        Thread t = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                //                init(0);
                int frequency = 8000;
                int channelConfiguration = AudioFormat.CHANNEL_IN_MONO;
                int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
                int bufferSize = AudioRecord.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
                if (bufferSize < 1280)
                {
                    bufferSize = 1280;
                }
                bufferSize = bufferSize + (320 - (bufferSize % 320));
                recorder = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, frequency, channelConfiguration, audioEncoding, bufferSize);
                try
                {
                    recorder.startRecording();
                }
                catch (Exception ex)
                {
                    _running = false;
                    _release = true;
                    //                    exit();
                    return;
                }
                short[] buffer = new short[bufferSize / 2];
                int mode = Mode.MR122.ordinal();
                byte[] out = new byte[32];
                while (_running)
                {
                    int count = recorder.read(buffer, 0, bufferSize / 2);
                    long v = 0;
                    for (int i = 0; i < buffer.length; i++)
                    {
                        v += buffer[i] * buffer[i];
                    }
                    // 平方和除以数据总长度，得到音量大小。
                    double mean = v / (double) count;
                    double volume = 10 * Math.log10(mean);
                    int byteEncoded = 0;
                    byte[] encodedArray = new byte[out.length * count / 160];
                    for (int i = 0; i < count / 160; i++)
                    {
                        short[] input = new short[160];
                        System.arraycopy(buffer, 160 * i, input, 0, 160);
                        //                        int encodeLength = encode(mode, input, out);
                        int encodeLength = opus.getInstance().opusEncoder(input, out);
                        int length = 32;
                        System.arraycopy(out, 0, encodedArray, byteEncoded, length);
                        byteEncoded += length;
                        _seconds += 20;
                    }
                    callback.onEncoded(encodedArray, _seconds, (int) volume);
                }
                recorder.stop();
                recorder.release();
                callback.onEnd();
                // if (isEnabled)
                // {
                // canceler.setEnabled(false);
                // canceler.release();
                // }
                _release = true;
                //                exit();
            }
        });
        t.start();
        return true;
    }

    public synchronized boolean stop()
    {
        boolean result = _running;
        _running = false;
        return result;
    }

    public boolean isRelease()
    {
        return _release;
    }
}
