package com.com.constantpool;

import com.basic.U1;
import com.basic.U2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StringInfo extends CP_InfoAbstract {
    private U2 stringInfo;

    public StringInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.stringInfo = new U2(inputStream);
    }

    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] stringIndexAttr = this.getStringInfo().DataCellStringAttr();
        for(String s : stringIndexAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U2 getStringInfo() {
        return stringInfo;
    }

    public void setStringInfo(U2 stringInfo) {
        this.stringInfo = stringInfo;
    }
}
