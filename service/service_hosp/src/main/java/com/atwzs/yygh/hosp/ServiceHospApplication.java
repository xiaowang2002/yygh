package com.atwzs.yygh.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceHostApplication
 * @Description
 * @Author WangZhisheng
 * @Date 23:03 2023/4/15
 * @Version 11.0.15
 */
@SpringBootApplication
@ComponentScan("com.atwzs")      //com.atwzs下面的component都能扫到，不管是当地的，还是引入进来的，像swagger2config
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}

