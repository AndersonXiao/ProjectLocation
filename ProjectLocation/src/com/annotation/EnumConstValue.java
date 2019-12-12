package com.annotation;

import com.basic.U2;

import java.io.InputStream;

public class EnumConstValue {
    public U2 typeNameIndex;
    public U2 constNameIndex;

    public EnumConstValue(InputStream inputStream) throws Exception {
        typeNameIndex = new U2(inputStream);
        constNameIndex = new U2 (inputStream);
    }
}
