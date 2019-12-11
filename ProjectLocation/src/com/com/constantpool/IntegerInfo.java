package com.com.constantpool;

import com.basic.U1;
import com.basic.U4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IntegerInfo extends CP_InfoAbstract {
    private U4 bytes;
    public IntegerInfo(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.bytes = new U4(inputStream);
    }
    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] bytesAttr = this.getBytes().DataCellStringAttr();
        for(String s : bytesAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U4 getBytes() {
        return bytes;
    }

    public void setBytes(U4 bytes) {
        this.bytes = bytes;
    }
}
