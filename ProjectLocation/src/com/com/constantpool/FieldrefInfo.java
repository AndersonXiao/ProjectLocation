package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FieldrefInfo extends CP_InfoAbstract {
    private U2 classIndex;
    private U2 nameAndTypeIndex;
    public FieldrefInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.classIndex = new U2(inputStream);
        this.nameAndTypeIndex = new U2(inputStream);
    }

    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] classIndexAttr = this.getClassIndex().DataCellStringAttr();
        for(String s : classIndexAttr){
            tempList.add(s);
        }

        String[] IndexAttr = this.getNameAndTypeIndex().DataCellStringAttr();
        for(String s : IndexAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U2 getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(U2 classIndex) {
        this.classIndex = classIndex;
    }

    public U2 getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(U2 nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
