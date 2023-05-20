package com.atwzs.yygh.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)                 //取消数据源自动配置。因为我们没有配置数据源
@EnableDiscoveryClient
@ComponentScan("com.atwzs")
@EnableSwagger2
public class ServiceMsmApplication {
   public static void main(String[] args) {
      SpringApplication.run(ServiceMsmApplication.class, args);
   }
}
