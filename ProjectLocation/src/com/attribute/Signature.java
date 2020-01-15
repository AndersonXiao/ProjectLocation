package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.List;

public class Signature extends AttributeAbstract {
    public U2 signatureIndex;
    public Signature(InputStream inputStream) throws Exception {
        //this.attributeNameIndex = new U2(inputStream);
        //The value of the attribute_length item of a Signature_attribute structure must be two.
        this.attributeLength = new U4(inputStream);
        this.signatureIndex = new U2(inputStream);
    }
    @Override
    public List<String> printStringAttr() {

        return null;
    }
}
