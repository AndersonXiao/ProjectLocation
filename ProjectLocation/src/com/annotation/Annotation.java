package com.annotation;

import com.basic.U2;
import java.io.InputStream;

public class Annotation {
        public U2 typeindex;
        public U2 numElementValuePairs;
        public ElementValuePairs[] elementValuePairs;
        public Annotation(InputStream inputStream) throws Exception {
                typeindex = new U2(inputStream);
                numElementValuePairs = new U2(inputStream);
                elementValuePairs = new ElementValuePairs[numElementValuePairs.getShortS()];
        }
}
