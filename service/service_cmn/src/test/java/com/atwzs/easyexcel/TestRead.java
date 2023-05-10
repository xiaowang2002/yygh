package com.atwzs.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @ClassName TestRead
 * @Description testRead需要ExcelListener
 * @Author WangZhisheng
 * @Date 19:14 2023/5/3
 * @Version 11.0.15
 */
public class TestRead {
    public static void main(String[] args) {
        //读取文件路径
        String fileName = "D:\\excel\\01.xlsx";

        //调用方法实现读取操作
        EasyExcel.read(fileName, UserData.class, new ExcelListener()).sheet().doRead();
    }
}
