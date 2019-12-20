package com.modifiedutf8;

/*
* 此格式与“标准” UTF-8格式有两个区别:
* 1、空字符(char)0是使用2字节格式而不是1字节格式编码的；
* 2、仅使用标准UTF-8的1字节，2字节和3字节格式。Java虚拟
*    机无法识别标准UTF-8的四字节格式。它使用自己的2乘3字
*    节格式。
* */
public class ModifiedUTF8 {
    //UTF-8一个字节表示形式，即标准ASCALL码（出去0x00null值，NULL在JVM中用两个字节表示）。
    public byte oneByteMix = 0x0001;
    public byte oneByteMax = 0x007F;

    //空代码点\u0000和范围\u0080到 \u07FF的代码点由一对字节x和表示y：




    //待研究







}
