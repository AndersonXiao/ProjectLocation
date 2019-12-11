package com.attribute;

import com.basic.U2;
import com.basic.U4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SourcefileInfo extends AttributeAbstract {
    public U2 sourcefileIndex;
    public SourcefileInfo(InputStream inputStream) throws Exception {
        this.attributeNameIndex = new U2(inputStream);
        this.attributeLength = new U4(inputStream);
        this.sourcefileIndex = new U2(inputStream);
    }
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] attributeNameAttr = this.attributeNameIndex.DataCellStringAttr();
        for(String s : attributeNameAttr){
            tempList.add(s);
        }
        String[] lengthAttr = this.attributeNameIndex.DataCellStringAttr();
        for(String s : lengthAttr){
            tempList.add(s);
        }
        String[] sourceFileAttr = this.attributeNameIndex.DataCellStringAttr();
        for(String s : sourceFileAttr){
            tempList.add(s);
        }
        return tempList;
    }
}
