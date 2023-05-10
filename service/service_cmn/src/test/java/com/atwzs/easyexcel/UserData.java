package com.atwzs.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName UserData
 * @Description
 * @Author WangZhisheng
 * @Date 18:36 2023/5/3
 * @Version 11.0.15
 */
@Data
public class UserData {

    @ExcelProperty("用户编号")
    private int uid;

    @ExcelProperty("用户名称")
    private String username;


}
