package com.xzc.byte_base;

/**
 * 将bytes数组转换成char,int,short,long类型
 */
public class ByteToBasic {

    public char bytesToChar(byte[] bytes){
        char c = (char) (((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF));
        return c;
    }

    public short bytesToShort(byte[] bytes){
        short s = (short) (((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF));
        return s;
    }

    public int bytesToInt(byte[] bytes){
        //int intII = ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | ((bytes[3] & 0xFF));
        int intI = 0;
        for(int i=0,j=bytes.length-1;i<bytes.length&&j>=0;i++,j--){
            intI = intI|bytes[i] & 0xFF << j*8;
        }
        return intI;
    }

    public long bytesToLong(byte[] bytes){
        long l = 0;
        for(int i=0,j=bytes.length-1;i<bytes.length&&j>=0;i++,j--){
            l = l|bytes[i] & 0xFF << j*8;
        }
        return l;
    }

}
