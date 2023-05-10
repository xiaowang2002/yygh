package com.atwzs.yygh.cmn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName DictFeignClient
 * @Description
 * @Author WangZhisheng
 * @Date 9:25 2023/5/8
 * @Version 11.0.15
 */
@FeignClient("service-cmn")
@Repository
public interface DictFeignClient {

    /**
     * 获取数据字典名称
     *
     * @param parentDictCode
     * @param value
     * @return
     */
    @GetMapping(value = "/admin/cmn/dict/getName/{parentDictCode}/{value}")
    String getName(@PathVariable("parentDictCode") String parentDictCode, @PathVariable("value") String value);  //pathvariable必须要指定参数

    /**
     * 获取数据字典名称
     *
     * @param value
     * @return
     */
    @GetMapping(value = "/admin/cmn/dict/getName/{value}")
    String getName(@PathVariable("value") String value);

}
