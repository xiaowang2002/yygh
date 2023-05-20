package com.atwzs.yygh.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName UserConfig
 * @Description
 * @Author WangZhisheng
 * @Date 21:20 2023/5/14
 * @Version 11.0.15
 */
@Configuration
@MapperScan("com.atwzs.yygh.user.mapper")
@EnableSwagger2
public class UserConfig {
}
