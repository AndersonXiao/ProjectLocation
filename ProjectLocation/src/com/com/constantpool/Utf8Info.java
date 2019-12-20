package com.com.constantpool;


import com.basic.U1;
import com.basic.U2;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utf8Info extends CP_InfoAbstract {


    private U2 length;
    private U1 bytes[];
    public Utf8Info(){}
    public Utf8Info(InputStream inputStream) throws Exception {
        this.tag = new U1(inputStream);
        this.length = new U2(inputStream);
        this.bytes = new U1[this.length.getShortS()];
        for (int i=0;i<bytes.length;i++){
            bytes[i] = new U1(inputStream);
        }
        UtfDataLength len = UtfDataLength.getInstance();
        len.setDataLength(bytes.length + 3);
        //System.out.println(len.getDataLength());

    }

    //返回顺序列表
    @Override
    public List<String> printStringAttr() {
        List<String> tempList = new ArrayList<String>();
        String[] tagAttr = this.tag.DataCellStringAttr();
        for(String s : tagAttr){
            tempList.add(s);
        }
        String[] lengthAttr = this.getLength().DataCellStringAttr();
        for(String s : lengthAttr){
            tempList.add(s);
        }
        for(U1 u : this.getBytes()){
            for(String s : u.DataCellStringAttr()){
                tempList.add(s);
            }
        }
        return tempList;
    }

    public String getUtfInfo(){


        return "";
    }


    public U2 getLength() {
        return length;
    }

    public void setLength(U2 length) {
        this.length = length;
    }

    public U1[] getBytes() {
        return bytes;
    }

    public void setBytes(U1[] bytes) {
        this.bytes = bytes;
    }


}
