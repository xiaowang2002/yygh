package com.atwzs.yygh.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceOrderApplication
 * @Description
 * @Author WangZhisheng
 * @Date 13:18 2023/5/18
 * @Version 11.0.15
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.atwzs"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.atwzs"})
public class ServiceOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
