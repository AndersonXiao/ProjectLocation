package com.basic;

import com.xzc.Binary.BinaryGenerate;
import com.xzc.byte_base.ByteToBasic;

import java.io.InputStream;

public class U8 implements dataCellPrint {

    private long longL;
    private byte[] bytes = new byte[8];
    public U8(InputStream inputStream) throws  Exception{
        inputStream.read(bytes);
        ByteToBasic byteToBasic = new ByteToBasic();
        this.longL = byteToBasic.bytesToLong(bytes);
    }

    @Override
    public String[] DataCellStringAttr() {
        BinaryGenerate binaryGenerate = new BinaryGenerate(this.getLongL());
        return binaryGenerate.binaryStringArray(this.getBytes());
    }
    public long getLongL() {
        return longL;
    }

    public void setLongL(long longL) {
        this.longL = longL;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
