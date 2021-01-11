package com.xzc.test;

import com.xzc.Binary.BinaryGenerate;
import com.xzc.byte_base.ByteToBasic;

public class BinaryTest {
    public static void main(String[] args){

        BinaryGenerate bg = new BinaryGenerate(4789);
        String str = bg.intToBinary(bg.getIntParam());
        System.out.println(str);
        bg.printBinary(bg.intBinaryStrArray(bg.getIntParam()));
        ByteToBasic byteToBasic = new ByteToBasic();
        byte[] bytes = new byte[]{(byte)114,(byte)25};
        char charC = byteToBasic.bytesToChar(bytes);
        System.out.println(charC);
        BinaryGenerate bg1 = new BinaryGenerate(charC);
        bg1.printBinary(bg1.charBinaryStrArray(charC));


    }

}
