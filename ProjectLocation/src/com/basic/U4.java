package com.basic;

import com.xzc.Binary.BinaryGenerate;
import com.xzc.byte_base.ByteToBasic;

import java.io.InputStream;

public class U4 implements dataCellPrint{

    private int intI;
    private byte[] bytes = new byte[4];
    public U4(InputStream inputStream) throws  Exception{
        inputStream.read(bytes);
        ByteToBasic byteToBasic = new ByteToBasic();
        this.intI = byteToBasic.bytesToInt(bytes);
    }

    @Override
    public String[] DataCellStringAttr() {
        BinaryGenerate binaryGenerate = new BinaryGenerate(this.getIntI());
        return binaryGenerate.binaryStringArray(this.getBytes());
    }

    public int getIntI() {
        return intI;
    }

    public void setIntI(int intI) {
        this.intI = intI;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
