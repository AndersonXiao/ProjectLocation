package com.attribute;

import com.annotation.Annotation;
import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.List;

public class RuntimeInvisibleAnnotations extends AttributeAbstract{
    public U2 numAnnotation;
    public Annotation[] annotations;
    public RuntimeInvisibleAnnotations(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        this.attributeLength = new U4(inputStream);
        numAnnotation = new U2(inputStream);
        annotations = new Annotation[numAnnotation.getShortS()];
        //初始化字段注解数组



    }
    @Override
    public List<String> printStringAttr(){

        return null;
    }
}
