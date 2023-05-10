package com.atwzs.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;

import java.util.Map;

/**
 * @ClassName ExcelListener
 * @Description
 * @Author WangZhisheng
 * @Date 19:10 2023/5/3
 * @Version 11.0.15
 */
public class ExcelListener extends AnalysisEventListener<UserData> {

    /**
     * @description: 一行一行读取excel内容，从第二行读取
     **/
    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
        System.out.println(userData);    //读取的每一行内容
    }

    /**
     * @description: 读取表头内容
     **/
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        System.out.println("表头信息：" + headMap);
    }

    /**
     * @description: 读取之后执行
     **/
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
