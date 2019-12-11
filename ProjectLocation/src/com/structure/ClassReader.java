package com.structure;

import com.basic.U1;
import com.basic.U4;
import com.com.constantpool.CP_InfoAbstract;
import com.com.constantpool.UtfDataLength;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ClassReader {

    public String rule = "D:\\Hello.class";
    public ClassStructure classStructure;
    public ClassReader(InputStream inputStream) throws Exception {
        this.classStructure = new ClassStructure(inputStream, rule);
    }

    public void readClassFile(ClassStructure structure){
       for(String s : structure.structureReader()){
            System.out.println(s);
       }
    }

    public static void main(String[] args) throws Exception {
        String rule = "D:\\Hello.class";
        InputStream inputStream = new FileInputStream(rule);
        ClassReader classReader = new ClassReader(inputStream);
        classReader.readClassFile(classReader.classStructure);
        System.out.println(classReader.classStructure.constant_pool_count.getShortS());
        for(CP_InfoAbstract c : classReader.classStructure.constant_pool){
            System.out.println(c);
        }
        System.out.println(classReader.classStructure.constant_pool.length);
        /*CP_InfoAbstract[] constant_pool = new CP_InfoAbstract[6];
        for(CP_InfoAbstract c : constant_pool){
            System.out.println(c);
        }*/
       /* inputStream.skip(10);//跳过10个字节，判断常量池中第一个项
        U1 abTag = new U1(inputStream);
        for(String s : abTag.DataCellStringAttr()){
            System.out.println(s);
        }*/

        /*byte[] bytes = new byte[4];
        inputStream.read(bytes);
        for(byte b : bytes){
            System.out.println(b);
        }*/
        /*byte[] bytes1 = new byte[4];
        inputStream.read(bytes1);
        for(byte b : bytes1){
            System.out.println(b);
        }*/

        //测试单例模式
        /*UtfDataLength.getInstance();
        System.out.println(UtfDataLength.getInstance().getDataLength());
        UtfDataLength.getInstance().setDataLength(24);
        System.out.println(UtfDataLength.getInstance().getDataLength());
        UtfDataLength.getInstance().setDataLength(26);
        System.out.println(UtfDataLength.getInstance().getDataLength());*/
    }
}
