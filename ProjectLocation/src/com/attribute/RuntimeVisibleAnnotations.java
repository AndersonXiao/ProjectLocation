package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;

public class RuntimeVisibleAnnotations extends AttributeAbstract {

    private U2 annotationNum;
    //private FieldAnnotations[] fieldAnnotations;
    public RuntimeVisibleAnnotations(InputStream inputStream) throws Exception {

        this.attributeNameIndex = new U2(inputStream);
        this.attributeLength = new U4(inputStream);
        //初始化字段注解数组


    }
}
