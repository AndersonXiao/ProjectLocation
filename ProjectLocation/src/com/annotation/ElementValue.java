package com.annotation;

import com.basic.U1;

import java.io.InputStream;

public class ElementValue extends ElementValueTag{
    public U1 tag;
    public Union value;
    public ElementValue(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this. value = new Union(inputStream);
    }

}
