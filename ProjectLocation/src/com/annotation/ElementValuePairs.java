package com.annotation;

import com.basic.U2;

import java.io.InputStream;

public class ElementValuePairs {
    public U2 elementNameIndex;
    public ElementValue elementValue;
    public ElementValuePairs(InputStream inputStream) throws Exception {
        elementNameIndex = new U2(inputStream);
        elementValue = new ElementValue(inputStream);
    }
}
