package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodHandleInfo extends CP_InfoAbstract {
    private U1 referenceKind;
    private U2 referenceIndex;
    public MethodHandleInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.referenceKind = new U1(inputStream);
        this.referenceIndex = new U2(inputStream);
    }

    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] kindAttr = this.getReferenceKind().DataCellStringAttr();
        for(String s : kindAttr){
            tempList.add(s);
        }
        String[] reference = this.getReferenceKind().DataCellStringAttr();
        for(String s : reference){
            tempList.add(s);
        }
        return tempList;
    }

    public U1 getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(U1 referenceKind) {
        this.referenceKind = referenceKind;
    }

    public U2 getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(U2 referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
