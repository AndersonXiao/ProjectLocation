package com.basic;

import com.xzc.Binary.BinaryGenerate;
import  com.xzc.byte_base.ByteToBasic;

import java.io.InputStream;

public class U2 implements dataCellPrint{

    private short shortS;
    private byte[] bytes = new byte[2];
    public U2(InputStream inputStream) throws  Exception{

        inputStream.read(bytes);


        ByteToBasic byteToBasic = new ByteToBasic();
        this.shortS = (short)byteToBasic.bytesToChar(bytes);
    }



    @Override
    public String[] DataCellStringAttr() {
        BinaryGenerate binaryGenerate = new BinaryGenerate((char)0);
        return binaryGenerate.binaryStringArray(this.getBytes());
    }


    public short getShortS() {
        return shortS;
    }

    public void setShortS(short shortS) {
        this.shortS = shortS;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
