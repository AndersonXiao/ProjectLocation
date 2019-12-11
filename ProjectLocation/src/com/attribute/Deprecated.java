package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.List;

public class Deprecated extends AttributeAbstract {
    public Deprecated(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        //标志一个类、方法、字段不再被推荐使用，可能下个版本或者某个时间被删除。
        this.attributeLength = new U4(inputStream);
    }
    @Override
    public List<String> printStringAttr() {

        return null;
    }
}
