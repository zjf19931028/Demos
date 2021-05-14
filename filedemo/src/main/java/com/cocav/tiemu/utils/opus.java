package com.cocav.tiemu.utils;

/**
 * Created by cocav on 16/9/9.
 */
public class opus
{
    static
    {
        System.loadLibrary("tiopus");
    }

    private opus()
    {
    }

    private static opus _instance;

    public static opus getInstance()
    {
        if (_instance == null)
        {
            _instance = new opus();
            _instance.Init();
        }
        return _instance;
    }


    public static native int test();

    private native void Init();

    public native int opusEncoder(short[] in, byte[] out);

    public native int opusDecoder(byte[] in, short[] out, int len);

    public native void Destroy();

}
