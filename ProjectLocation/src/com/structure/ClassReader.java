package com.structure;



import annotation.TestA;
import com.com.constantpool.CP_InfoAbstract;
import com.com.constantpool.Utf8Info;
import com.util.ClassExploreUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;


public class ClassReader {

    public String rule = "D:\\FieldInfo.class";
    public ClassStructure classStructure;
    public ClassReader(InputStream inputStream) throws Exception {
        this.classStructure = new ClassStructure(inputStream, rule);
    }

    public void readClassFile(ClassStructure structure) throws FileNotFoundException {
        String printOutPath = "D:\\IdeaOut.txt";
        PrintStream printOut = new PrintStream(printOutPath);//新建一个打印对象
        System.setOut(printOut);
        PrintStream printStream = System.out;//恢复默认，输出到控制台。
        System.setOut(printStream);
       for(String s : structure.structureReader()){
            System.out.println(s);
       }
    }


    public static void main(String[] args) throws Exception {
        String inPath = "D:\\FieldInfo.class";
        String outPath = "D:\\newClass.class";
        //生成模拟二进制数据
        InputStream inputStream = new FileInputStream(inPath);
        ClassReader classReader = new ClassReader(inputStream);
        classReader.readClassFile(classReader.classStructure);
        //生成真正的二进制文件(class文件)
        ClassExploreUtil util = new ClassExploreUtil(inPath,outPath);
        util.strStreamToBinary();
    }


}
