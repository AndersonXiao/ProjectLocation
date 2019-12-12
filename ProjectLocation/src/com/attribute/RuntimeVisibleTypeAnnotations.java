package com.attribute;

import com.annotation.TypeAnnotation;
import com.basic.U2;
import com.basic.U4;
//import sun.reflect.annotation.TypeAnnotation;

import java.io.InputStream;

public class RuntimeVisibleTypeAnnotations extends AttributeAbstract {

    public U2 numAnnotations;
    public TypeAnnotation[] annotations;
    public RuntimeVisibleTypeAnnotations(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        this.attributeLength = new U4(inputStream);
        this.annotations = new TypeAnnotation[numAnnotations.getShortS()];
        //这里进行数组初始化




    }
}
