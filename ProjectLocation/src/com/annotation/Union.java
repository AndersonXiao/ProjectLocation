package com.annotation;

import com.basic.U2;

import java.io.InputStream;

public class Union {
    /*
        包括8种基本类型和String类型
     */
    public U2 constValueIndex;
    /*
        枚举类型
     */
    public EnumConstValue enumConstValue;
    /*
        类类型
     */
    public U2 classInfoIndex;
    /*
        注解类型
     */
    public Annotation  annotationValue;
    /*
        数组类型
     */
    public ArrayValue arrayValue;

    public Union(InputStream inputStream) throws Exception {
        constValueIndex = new U2(inputStream);
        enumConstValue = new EnumConstValue(inputStream);
        classInfoIndex = new U2(inputStream);
        annotationValue = new Annotation(inputStream);
        arrayValue = new ArrayValue(inputStream);
    }
}
