package com.field;

import com.attribute.*;
import com.attribute.Deprecated;
import com.basic.U2;
import com.com.constantpool.CP_InfoAbstract;
import com.com.constantpool.FieldrefInfo;
import com.com.constantpool.Utf8Info;
import com.util.ClassExploreUtil;
import sun.plugin.dom.core.Attr;

import java.io.InputStream;

public class FieldInfo {
    public U2 accessFlags;
    public U2 nameIndex;
    public U2 descriptorIndex;
    public U2 attributesCount;
    public AttributeAbstract[] attributes;
    public FieldInfo(InputStream inputStream , CP_InfoAbstract[] constantPool) throws Exception {
        this.accessFlags = new U2(inputStream);
        this.nameIndex = new U2(inputStream);
        this.descriptorIndex = new U2(inputStream);
        this.attributesCount = new U2(inputStream);
        attributes = new AttributeAbstract[attributesCount.getShortS()];
        //这里进行字段属性的初始化，1.8共有8个字段级别的属性。
        for(int i=0;i<attributes.length;i++){
            attributes[i] = initFieldAttribute(inputStream,constantPool);
        }
    }

    public AttributeAbstract initFieldAttribute(InputStream inputStream, CP_InfoAbstract[] constantPool) throws Exception {
        AttributeAbstract aAbstract;
        U2 attributeTag = new U2(inputStream);
        Utf8Info utf = (Utf8Info) constantPool[attributeTag.getShortS()];
        String strTag = utf.getUtfStringInfo();
        if(strTag.equals("ConstantValue")){
            aAbstract = new ConstantValue(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("Deprecated")){
            aAbstract = new Deprecated(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("Signature")){
            aAbstract = new Signature(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("RuntimeInvisibleAnnotations")){
            aAbstract = new RuntimeInvisibleAnnotations(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("RuntimeVisibleAnnotations")){
            aAbstract = new RuntimeVisibleAnnotations(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("RuntimeVisibleTypeAnnotations")){
            aAbstract = new RuntimeVisibleTypeAnnotations(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("Synthetic")){
            aAbstract = new Synthetic(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        if(strTag.equals("RuntimeInvisibleTypeAnnotations")){
            aAbstract = new RuntimeInvisibleTypeAnnotations(inputStream);
            aAbstract.attributeNameIndex = attributeTag;
            return aAbstract;
        }
        return null;
    }
}
