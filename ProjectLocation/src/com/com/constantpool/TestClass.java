package com.com.constantpool;

import com.basic.U2;

public class TestClass {

    public static int anInt = 50000;
    @Deprecated
    public String getString() {
        String str = "看土味视频，品沙雕人生";
        return str;
    }
    //抛出异常
    public void outExceptions() throws Exception {
        System.out.println("我于杀戮之中绽放");
    }
    //局部类
    public void getPartClass(){

            class PartClass{
                    public void addNum(){
                        int num = 27 + 39;
                    }
        }
        PartClass partClass = new PartClass();
            partClass.addNum();
    }


}
