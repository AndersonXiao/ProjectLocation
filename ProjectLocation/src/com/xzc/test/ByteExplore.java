package com.xzc.test;
//后考虑大小端问题
public class ByteExplore {
    private byte byteParam;
    private char charParam;
    private int intParam;
    private long longParam;
    public ByteExplore(byte b){

        setByteParam(b);
    }
    public ByteExplore(char c){

        setCharParam(c);
    }
    public ByteExplore(int i){

        setIntParam(i);
    }
    public ByteExplore(long l){

        setLongParam(l);
    }
    //输出类型高低位
    public byte charToByteHigh(char c){
        byte charHigh = (byte)(c>>8&0xFF);
        return charHigh;
    }
    public byte charToByteLow(char c){
        byte charlow = (byte)(c&0xFF);
        return charlow;
    }
    public char intToCharHigh(int i){
        char intHigh = (char)(i>>16&0xFFFF);
        return intHigh;

    }
    public char intToCharLow(int i){
        char intlow = (char)(i&0xFFFF);
        return intlow;
    }
    public int longToIntHigh(long l){
        int longHigh = (int)(l>>32&0xFFFFFFFF);
        return longHigh;
    }
    public int longToIntLow(long l){
        int longLow = (int)(l&0xFFFFFFFF);
        return longLow;
    }
    //类型转换为二进制输出
    public String  byteToBinary(byte byteB){
        return "" + (byte)(byteB>>7&0x01) +
                    (byte)(byteB>>6&0x01) +
                    (byte)(byteB>>5&0x01) +
                    (byte)(byteB>>4&0x01) +
                    (byte)(byteB>>3&0x01) +
                    (byte)(byteB>>2&0x01) +
                    (byte)(byteB>>1&0x01) +
                    (byte)(byteB>>0&0x01);
    }
    public String[] binaryStringArray(byte[] bytes){
        String[] binaryArray = new String[bytes.length];
        if(bytes.length > 0){
            for(int i=0;i<bytes.length;i++){
                binaryArray[i] = byteToBinary(bytes[i]);
            }
        }
        return binaryArray;
    }
    public String charToBinary(char charC){
        return "" + byteToBinary(charToByteHigh(charC)) +
                    byteToBinary((charToByteLow(charC)));
    }
    public String intToBinary(int intI){
        return "" + charToBinary(intToCharHigh(intI)) +
                    charToBinary(intToCharLow(intI));
    }
    public String longToBinary(long longL){
        return "" + intToBinary(longToIntHigh(longL)) +
                    intToBinary(longToIntLow(longL));
    }

    //类型按字节单位输出
    public String[] byteBinaryStrArray(byte b){
        byte[] bytes = new byte[]{b};
        return binaryStringArray(bytes);
    }
    public String[] charBinaryStrArray(char c){
        byte[] bytes = new byte[2];
        bytes[0] = charToByteHigh(c);
        bytes[1] = charToByteLow(c);
        return binaryStringArray(bytes);
    }
    public String[] intBinaryStrArray(int i){
        String[] bytes = new String[4];
        char tempHigh = intToCharHigh(i);
        char tempLow = intToCharLow(i);
        String[] temp1 = charBinaryStrArray(tempHigh);
        String[] temp2 = charBinaryStrArray(tempLow);
        bytes[0] = temp1[0];
        bytes[1] = temp1[1];
        bytes[2] = temp2[0];
        bytes[3] = temp2[1];
        return bytes;
    }
    public String[] longBinaryStrArray(long l){
        String[] bytes = new String[8];
        int tempHigh = longToIntHigh(l);
        int tempLow = longToIntLow(l);
        String[] temp1 = intBinaryStrArray(tempHigh);
        String[] temp2 = intBinaryStrArray(tempLow);
        bytes[0] = temp1[0];
        bytes[1] = temp1[1];
        bytes[2] = temp1[2];
        bytes[3] = temp1[3];
        bytes[4] = temp2[0];
        bytes[5] = temp2[1];
        bytes[6] = temp2[2];
        bytes[7] = temp2[3];
        return bytes;
    }
    //打印输出结果
    public void printBinary(String[] binary){

    if(binary.length > 0){
            for(String str : binary){
                System.out.print(str+" ");
            }
        }
    }

    public byte getByteParam() {
        return byteParam;
    }
    public char getCharParam() {
        return charParam;
    }
    public int getIntParam() {
        return intParam;
    }
    public long getLongParam() {
        return longParam;
    }
    public void setByteParam(byte byteParam) {
        this.byteParam = byteParam;
    }
    public void setCharParam(char charParam) {
        this.charParam = charParam;
    }
    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }
    public void setLongParam(long longParam) {
        this.longParam = longParam;
    }
}
