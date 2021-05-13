package com.awesome.audiorecorddemo.util.io;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/22 16:17
 * Description: 字节数组工具类
 */
public class ByteArrayUtil {
    public static byte[] int2ByteArray(int i) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte) (i & 0xFF);
        byteArray[1] = (byte) ((i & 0xFF00) >> 8);
        byteArray[2] = (byte) ((i & 0xFF0000) >> 16);
        byteArray[3] = (byte) ((i & 0xFF000000) >> 24);
        return byteArray;
    }

    public static int byteArray2Int(byte[] byteArray) {
        return (0xFF & byteArray[0])
                | (0xFF00 & (byteArray[1] << 8))
                | (0xFF0000 & (byteArray[2] << 16))
                | (0xFF000000 & (byteArray[3] << 24));
    }

    public static byte[] long2ByteArray(long l) {
        byte[] byteArray = new byte[8];
        byteArray[0] = (byte) (l & 0xFF);
        byteArray[1] = (byte) ((l >> 8) & 0xFF);
        byteArray[2] = (byte) ((l >> 16) & 0xFF);
        byteArray[3] = (byte) ((l >> 24) & 0xFF);
        byteArray[4] = (byte) ((l >> 32) & 0xFF);
        byteArray[5] = (byte) ((l >> 40) & 0xFF);
        byteArray[6] = (byte) ((l >> 48) & 0xFF);
        byteArray[7] = (byte) ((l >> 56) & 0xFF);
        return byteArray;
    }

    public static long byteArray2Long(byte[] byteArray) {
        return (0xFFL & (long) byteArray[0])
                | (0xFF00L & ((long) byteArray[1] << 8))
                | (0xFF0000L & ((long) byteArray[2] << 16))
                | (0xFF000000L & ((long) byteArray[3] << 24))
                | (0xFF00000000L & ((long) byteArray[4] << 32))
                | (0xFF0000000000L & ((long) byteArray[5] << 40))
                | (0xFF000000000000L & ((long) byteArray[6] << 48))
                | (0xFF00000000000000L & ((long) byteArray[7] << 56));
    }

    public static byte[] boolean2ByteArray(boolean b) {
        byte[] byteArray = new byte[1];
        byteArray[0] = (byte) (b ? 0x01 : 0x00);
        return byteArray;
    }

    public static boolean byteArray2Boolean(byte[] byteArray) {
        return byteArray[0] == 0x01;
    }

}
