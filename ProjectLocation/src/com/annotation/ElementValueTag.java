package com.annotation;

/*
    注解中字段的类型，13种。类型可分为5类
    1、常量类型：8种基本类型和String类型
    2、枚举类型
    3、类类型
    4、注解类型
    5、数组类型（其可包括以上全部类型）
    这几种类别可在被类的继承类ElementValue的Union定义中得到体现。
 */
public class ElementValueTag{
    public byte TagByte = 0x42; //B
    public byte TagChar = 0x43; //C
    public byte TagDouble = 0x44; //D
    public byte TagFloat = 0x46; //F
    public byte TagInt = 0x49; //I
    public byte TagLong = 0x4A; //J
    public byte TagShort = 0x53; //S
    public byte TagBoolean = 0x5A; //Z
    public byte TagString = 0x73; //s
    public byte TagEnum = 0x65; //e
    public byte TagClass = 0x63; //c
    public byte TagAnnotation = 0x40; //@
    public byte TagArray = 0x5B; //[

}
