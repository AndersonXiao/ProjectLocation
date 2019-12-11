package com.com.constantpool;
//此类为静态内部类单例模式，值得研究
public class UtfDataLength {
    public int dataLength;
    private UtfDataLength(){}
    private static class SingleTonHoler{
        private static UtfDataLength INSTANCE = new UtfDataLength();
    }
    public static UtfDataLength getInstance(){
        return SingleTonHoler.INSTANCE;
    }
    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }
}
