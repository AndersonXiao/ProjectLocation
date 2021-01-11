package com.util;

import com.xzc.byte_base.ByteToBasic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class ClassExploreUtil {
    public  String inPath = "";
    public  String outPath = "";
    public ClassExploreUtil(String in, String out){
        this.inPath = in;
        this.outPath = out;
    }
    public static String bytesToString(byte[] bytes){
        String str = new String(bytes);
        return str;
    }

    /**
     * 将模拟的二进制流转换为真正的二进制文件
     */
    public void strStreamToBinary() throws IOException {
        File file = new File(this.inPath);//打开本地文件，建立链接
        InputStream inputStream = new FileInputStream(file);//与打开的本地文件链接创建输入流
        OutputStream out = new FileOutputStream(this.outPath);
        List<Byte> list = new ArrayList<Byte>();
        int res ;
        byte[] b = new byte[1];
        while ((res = inputStream.read()) != -1){
            list.add((byte)res);
            out.write(res);
        }
        inputStream.close();
        //
        /*for(int i=0,j=10;j<list.size();i=i+10,j=j+10){
            b[0] = this.bytesToByte(list.subList(i,j-2));
            out.write(b);
        }*/
    }

    /**
     * 将形如‘10101110’的模拟二进制字符串数组转换为byte类型
     * eg: 10010101,此字符串是模拟二进制数据，其长度为64位。转换后为byte类型，值为 -22
     * @param bytes
     * @return
     */
    private byte bytesToByte(List<Byte> bytes){

        byte a = (byte)((bytes.get(0) << 7 & 0xFF)
                | (bytes.get(1) << 6 & 0xFF)
                | (bytes.get(2) << 5 & 0xFF)
                | (bytes.get(3) << 4 & 0xFF)
                | (bytes.get(4) << 3 & 0xFF)
                | (bytes.get(5) << 2 & 0xFF)
                | (bytes.get(6) << 1 & 0xFF)
                | (bytes.get(7)  & 0xFF));
        return a;
    }
}
