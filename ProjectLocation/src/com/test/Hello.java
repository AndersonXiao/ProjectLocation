package com.test;

import java.util.ArrayList;
import java.util.List;

public class Hello {

    public int anInt = 65535;
    public double aDouble = 22.6;
    public static final String str = "真特么冷了";
    public List<String> list = new ArrayList<String>();

    public Hello(String str){
       str = str + "指令分析";
    }

    public int getAdd(int a, int b){

        int c = a + b;
        c = c + anInt;
        return c;
    }


    public double getaDouble(double w){
        w = w + getAdd(5,9);
        return anInt;
    }
}
