package com.structure;

import com.basic.U1;
import com.basic.U2;
import com.basic.U4;
import com.com.constantpool.*;
import com.field.FieldInfo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClassStructure{

    public U4 magic;
    public U2 minor_version;
    public U2 major_version;
    public U2 constant_pool_count;
    public CP_InfoAbstract constant_pool[];
    public U2 access_flags;
    public U2 this_class;
    public U2 super_class;
    public U2 interfaces_count;
    public U2 interfaces[];
    //public U2 fields_count;
    //public FieldInfo fields[];




    public ClassStructure(InputStream inputStream, String path) throws Exception{

        int dataLength = 10;
        magic = new U4(inputStream);
        minor_version = new U2(inputStream);
        major_version = new U2(inputStream);
        constant_pool_count = new U2(inputStream);
        constant_pool = new CP_InfoAbstract[constant_pool_count.getShortS()];
        for(int i=1;i<constant_pool.length;i++){

            CP_InfoAbstract cp = initConstantool(inputStream, path, (long)dataLength);
            //Long和Double占用了常量池的两项
            if(cp instanceof LongInfo || cp instanceof DoubleInfo){
                constant_pool[i] = cp;
                i = i + 1;
            }else{
                constant_pool[i] = cp;
            }
            dataLength = getDataLength(constant_pool);
        }
        access_flags = new U2(inputStream);
        this_class = new U2(inputStream);
        super_class = new U2(inputStream);
        interfaces_count = new U2(inputStream);
        if(!(interfaces_count.getShortS() == 0)){
            interfaces = new U2[interfaces_count.getShortS()];
            for(int i = 0;i < interfaces.length;i++){
                interfaces[i] = new U2(inputStream);
            }
        }
        /*fields_count = new U2(inputStream);
        fields = new FieldInfo[fields_count.getShortS()];*/
    }

    //初始化常量池相关的三个方法

    public CP_InfoAbstract initConstantool(InputStream inputStream, String path, long skipNum) throws Exception {
        CP_InfoAbstract cp_infoAbstract;
        InputStream newStream = new FileInputStream(path);
        newStream.skip(skipNum);//跳过10个字节，判断常量池中第一个项
        U1 abTag = new U1(newStream);
        CP_InfoAbstract cp = new Utf8Info();
        //int len = UtfDataLength.getInstance().getDataLength();
        if((int)abTag.getByteB() == cp.CONSTANT_Utf8){
            cp_infoAbstract = new Utf8Info(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Class){
            cp_infoAbstract = new ClassInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Double){
            cp_infoAbstract = new DoubleInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Fieldref){
            cp_infoAbstract = new FieldrefInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Float){
            cp_infoAbstract = new FloadInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Integer){
            cp_infoAbstract = new IntegerInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_InterfaceMethodref){
            cp_infoAbstract = new InterfaceMethodrefInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_InvokeDynamic){
            cp_infoAbstract = new InvokeDynamicInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Long){
            cp_infoAbstract = new LongInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_MethodHandle){
            cp_infoAbstract = new MethodHandleInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_Methodref){
            cp_infoAbstract = new MethodrefInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_MethodType){
            cp_infoAbstract = new MethodTypeInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_NameAndType){
            cp_infoAbstract = new NameAndTypeInfo(inputStream);
            return cp_infoAbstract;
        }
        if((int)abTag.getByteB() == cp.CONSTANT_String){
            cp_infoAbstract = new StringInfo(inputStream);
            return cp_infoAbstract;
        }
        return null;
    }

    public int getDataLength(CP_InfoAbstract[] cpArray){
        int dataLength = 10;
        for(CP_InfoAbstract c : cpArray){
            if(!(c == null)){
                dataLength = dataLength + getPoolInfoLength(c);
            }
        }
        return dataLength;
        }

    public int getPoolInfoLength(CP_InfoAbstract cp_infoAbstract) {
            int dataLength = 0;
            if(cp_infoAbstract instanceof Utf8Info){
                //int data = UtfDataLength.getInstance().getDataLength();
                int data = ((Utf8Info)cp_infoAbstract).getBytes().length+3;
                dataLength = dataLength + data;
            }
            if(cp_infoAbstract instanceof ClassInfo){
                dataLength = dataLength + cp_infoAbstract.ClassLength;
            }
            if(cp_infoAbstract instanceof DoubleInfo){
                dataLength = dataLength + cp_infoAbstract.DoubleLength;
            }
            if(cp_infoAbstract instanceof FieldrefInfo){
                dataLength = dataLength + cp_infoAbstract.FieldrefLength;
            }
            if(cp_infoAbstract instanceof FloadInfo){
                dataLength = dataLength + cp_infoAbstract.FloatLength;
            }
            if(cp_infoAbstract instanceof IntegerInfo){
                dataLength = dataLength + cp_infoAbstract.IntegerLength;
            }
            if(cp_infoAbstract instanceof InterfaceMethodrefInfo){
                dataLength = dataLength + cp_infoAbstract.InterfaceMethodrefLength;
            }
            if(cp_infoAbstract instanceof InvokeDynamicInfo){
                dataLength = dataLength + cp_infoAbstract.InvokeDynamicLength;
            }
            if(cp_infoAbstract instanceof LongInfo){
                dataLength = dataLength + cp_infoAbstract.LongLength;
            }
            if(cp_infoAbstract instanceof MethodHandleInfo){
                dataLength = dataLength + cp_infoAbstract.MethodHandleLength;
            }
            if(cp_infoAbstract instanceof MethodrefInfo){
                dataLength = dataLength + cp_infoAbstract.MethodrefLength;
            }
            if(cp_infoAbstract instanceof MethodTypeInfo){
                dataLength = dataLength + cp_infoAbstract.MethodTypeLength;
            }
            if(cp_infoAbstract instanceof NameAndTypeInfo){
                dataLength = dataLength + cp_infoAbstract.NameAndTypeLength;
            }
            if(cp_infoAbstract instanceof StringInfo){
                dataLength = dataLength + cp_infoAbstract.StringLength;
            }
            return dataLength;

        }

    public List<String> structureReader(){
        List<String> result = new ArrayList<String>();
        for(String s: magic.DataCellStringAttr()){
            result.add(s);
        }
        for(String s: minor_version.DataCellStringAttr()){
            result.add(s);
        }
        for(String s:  major_version.DataCellStringAttr()){
            result.add(s);
        }
        for(String s: constant_pool_count.DataCellStringAttr()){
            result.add(s);
        }
        //可再次添加标号逻辑

        int poolCount = constant_pool.length;
        for(CP_InfoAbstract c : constant_pool){
            if(!(c == null)){
                for(String cp : c.printStringAttr()){
                    result.add(cp);
                }
            }
        }

        for(String s: access_flags.DataCellStringAttr()){
            result.add(s);
        }
        for(String s: this_class.DataCellStringAttr()){
            result.add(s);
        }
        for(String s: super_class.DataCellStringAttr()){
            result.add(s);
        }
        for(String s: interfaces_count.DataCellStringAttr()){
            result.add(s);
        }
        /*
        * 此时interfaces数组为null,故不能用interfaces.length来判断，interfaces.length反射操作报空指针异常。
        * */
        if(interfaces_count.getShortS() > 0){
            for(U2 u : interfaces){
                for(String ifaces : u.DataCellStringAttr()){
                    result.add(ifaces);
                }
            }
        }









        return result;
    }











}
