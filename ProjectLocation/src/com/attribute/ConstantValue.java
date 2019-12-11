package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.List;

public class ConstantValue extends AttributeAbstract {
    public U2 constantvalueIndex;
    public ConstantValue(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        this.attributeLength = new U4(inputStream);
        this.constantvalueIndex = new U2(inputStream);
    }
    @Override
    public List<String> printStringAttr() {

        return null;
    }
}
