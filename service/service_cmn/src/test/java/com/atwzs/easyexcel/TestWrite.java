package com.atwzs.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.atguigu.yygh.model.acl.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestWrite
 * @Description
 * @Author WangZhisheng
 * @Date 18:40 2023/5/3
 * @Version 11.0.15
 */
public class TestWrite {

    public static void main(String[] args) {
        List<UserData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserData data = new UserData();
            data.setUid(i);
            data.setUsername("lucy" + i);
            list.add(data);
        }
        //设置excel文件路径和文件名称，必须要存在的
        String fileName = "D:\\excel\\01.xlsx";

        //使用方法实现写操作
        EasyExcel.write(fileName, UserData.class).sheet("用户信息")
                .doWrite(list);   //sheet是表的左下角
    }
}
