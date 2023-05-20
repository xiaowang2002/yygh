package com.atwzs.yygh.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName OrderConfig
 * @Description
 * @Author WangZhisheng
 * @Date 13:24 2023/5/18
 * @Version 11.0.15
 */
@Configuration
@MapperScan("com.atwzs.yygh.order.mapper")
public class OrderConfig {
}
