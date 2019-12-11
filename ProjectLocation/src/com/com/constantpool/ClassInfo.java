package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo extends CP_InfoAbstract {
    private U2 nameIndex;
    public ClassInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.nameIndex = new U2(inputStream);
    }

    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] nameIndexAttr = this.getNameIndex().DataCellStringAttr();
        for(String s : nameIndexAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U2 getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(U2 nameIndex) {
        this.nameIndex = nameIndex;
    }


}
