package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodTypeInfo extends CP_InfoAbstract {

    private U2 descriptorIndex;
    public MethodTypeInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.descriptorIndex = new U2(inputStream);
    }

    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] descriptorAttr = this.getDescriptorIndex().DataCellStringAttr();
        for(String s : descriptorAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U2 getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(U2 descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
