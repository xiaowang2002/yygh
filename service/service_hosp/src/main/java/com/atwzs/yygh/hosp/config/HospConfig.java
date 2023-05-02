package com.atwzs.yygh.hosp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HospConfig
 * @Description
 * @Author WangZhisheng
 * @Date 15:55 2023/4/18
 * @Version 11.0.15
 */
@Configuration
@MapperScan("com.atwzs.yygh.hosp.mapper")     //给这个包下的所有mapper接口上都加个@mapper注解，当然这个注解也可以加到启动类上 ，建议加到配置类
public class HospConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new
                PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
