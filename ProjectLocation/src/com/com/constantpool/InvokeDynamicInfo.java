package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class InvokeDynamicInfo extends CP_InfoAbstract {
    private U2 bootstrapMethodAttrIndex;
    private U2 nameAndTypeIndex;
    public InvokeDynamicInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.bootstrapMethodAttrIndex = new U2(inputStream);
        this.nameAndTypeIndex = new U2(inputStream);
    }
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] bootstrapAttr = this.getBootstrapMethodAttrIndex().DataCellStringAttr();
        for(String s : bootstrapAttr){
            tempList.add(s);
        }
        String[] nameAndType = this.getNameAndTypeIndex().DataCellStringAttr();
        for(String s : nameAndType){
            tempList.add(s);
        }
        return tempList;
    }

    public U2 getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(U2 bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public U2 getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(U2 nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
