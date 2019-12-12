package com.annotation;

import com.basic.U2;

import java.io.InputStream;

public class ArrayValue {
    public U2 numValues;
    public ElementValue[] elementValue;
    public ArrayValue(InputStream inputStream) throws Exception {
        numValues = new U2(inputStream);
        elementValue = new ElementValue[numValues.getShortS()];
        //这里进行数组初始化



    }
}
