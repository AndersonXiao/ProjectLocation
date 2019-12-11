package com.basic;


import com.xzc.Binary.BinaryGenerate;

import java.io.InputStream;

public class U1 implements dataCellPrint {

    private byte byteB;

    public U1(InputStream inputStream) throws Exception{
        this.byteB = (byte)inputStream.read();

    }

    @Override
    public String[] DataCellStringAttr() {
        String str = "";
        BinaryGenerate binaryGenerate = new BinaryGenerate(getByteB());
        str = binaryGenerate.byteToBinary(binaryGenerate.getByteParam());
        return new String[]{str};
    }

    public byte getByteB() {
        return byteB;
    }

    public void setByteB(byte byteB) {
        this.byteB = byteB;
    }


}
