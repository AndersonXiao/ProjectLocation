package com.structure;



import annotation.TestA;
import com.com.constantpool.CP_InfoAbstract;
import com.com.constantpool.Utf8Info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;


public class ClassReader {

    public String rule = "D:\\Hello.class";
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
        String rule = "D:\\Hello.class";
        InputStream inputStream = new FileInputStream(rule);
        ClassReader classReader = new ClassReader(inputStream);
        classReader.readClassFile(classReader.classStructure);



    }
    @TestA
    public void String(){

        System.out.println("我特么草泥马");
    }


}
