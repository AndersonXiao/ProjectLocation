package com.attribute;

import com.annotation.TypeAnnotation;
import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;

public class RuntimeInvisibleTypeAnnotations extends AttributeAbstract {

    public U2 numAnnotations;
    public TypeAnnotation[] annotations;
    public RuntimeInvisibleTypeAnnotations(InputStream inputStream) throws Exception {
        this.attributeLength = new U4(inputStream);
        this.annotations = new TypeAnnotation[numAnnotations.getShortS()];
        //这里进行数组初始化




    }
}
