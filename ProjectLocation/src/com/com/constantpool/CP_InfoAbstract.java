package com.com.constantpool;

import com.basic.U1;
import java.util.List;

public abstract class CP_InfoAbstract {
    public U1 tag;//数据项类型标志
    public byte CONSTANT_Class = 7;
    public int ClassLength = 3;
    public byte CONSTANT_Fieldref = 9;
    public int FieldrefLength = 5;
    public byte CONSTANT_Methodref = 10;
    public int MethodrefLength = 5;
    public byte CONSTANT_InterfaceMethodref = 11;
    public int InterfaceMethodrefLength = 5;
    public byte CONSTANT_String = 8;
    public int StringLength = 3;
    public byte CONSTANT_Integer = 3;
    public int IntegerLength = 5;
    public byte CONSTANT_Float = 4;
    public int FloatLength = 5;
    public byte CONSTANT_Long = 5;
    public int LongLength = 9;
    public byte CONSTANT_Double = 6;
    public int DoubleLength = 9;
    public byte CONSTANT_NameAndType = 12;
    public int NameAndTypeLength = 5;
    public byte CONSTANT_Utf8 = 1;
    //public int Utf8Length;
    public byte CONSTANT_MethodHandle = 15;
    public int MethodHandleLength = 4;
    public byte CONSTANT_MethodType = 16;
    public int MethodTypeLength = 3;
    public byte CONSTANT_InvokeDynamic = 18;
    public int InvokeDynamicLength = 5;


    public abstract List<String> printStringAttr();


}
