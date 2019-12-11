package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.List;

public class Synthetic extends AttributeAbstract{

    public Synthetic(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        //其值必为零，只是一个标识，表示不是由源码生成而是由编译器自动生成的字段、方法或者顶层类。
        this.attributeLength = new U4(inputStream);
    }

    @Override
    public List<String> printStringAttr(){

        return null;
    }
}
