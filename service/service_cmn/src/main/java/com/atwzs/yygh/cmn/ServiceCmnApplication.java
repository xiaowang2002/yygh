package com.atwzs.yygh.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceCmnApplication
 * @Description
 * @Author WangZhisheng
 * @Date 19:05 2023/5/2
 * @Version 11.0.15
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.atwzs")
@EnableDiscoveryClient
public class ServiceCmnApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }
}

