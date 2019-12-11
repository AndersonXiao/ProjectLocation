package com.field;

import com.attribute.AttributeAbstract;
import com.basic.U2;
import com.com.constantpool.FieldrefInfo;
import sun.plugin.dom.core.Attr;

import java.io.InputStream;

public class FieldInfo {
    public U2 accessFlags;
    public U2 nameIndex;
    public U2 descriptorIndex;
    public U2 attributesCount;
    public AttributeAbstract[] attributes;
    public FieldInfo(InputStream inputStream) throws Exception {
        this.accessFlags = new U2(inputStream);
        this.nameIndex = new U2(inputStream);
        this.descriptorIndex = new U2(inputStream);
        this.attributesCount = new U2(inputStream);
        attributes = new AttributeAbstract[attributesCount.getShortS()];
        //这里进行字段属性的初始化，1.8共有8个字段级别的属性。


    }
}
