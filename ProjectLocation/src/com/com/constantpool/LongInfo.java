package com.com.constantpool;

import com.basic.U1;
import com.basic.U4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LongInfo extends CP_InfoAbstract {
        private U4 high_bytes;
        private U4 low_bytes;
        public LongInfo(InputStream inputStream) throws Exception {
            this.tag = new U1(inputStream);
            this.high_bytes = new U4(inputStream);
            this.low_bytes = new U4(inputStream);
        }

    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] high_bytesAttr = this.getHigh_bytes().DataCellStringAttr();
        for(String s : high_bytesAttr){
            tempList.add(s);
        }
        String[] low_bytesAttr = this.getLow_bytes().DataCellStringAttr();
        for(String s : high_bytesAttr){
            tempList.add(s);
        }
        return tempList;
    }

    public U4 getHigh_bytes() {
        return high_bytes;
    }

    public void setHigh_bytes(U4 high_bytes) {
        this.high_bytes = high_bytes;
    }

    public U4 getLow_bytes() {
        return low_bytes;
    }

    public void setLow_bytes(U4 low_bytes) {
        this.low_bytes = low_bytes;
    }
}
