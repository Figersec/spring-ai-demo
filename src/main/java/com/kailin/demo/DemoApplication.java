package com.kailin.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author 杨松
 */
@SpringBootApplication(scanBasePackages = {"com.kailin.demo.*"},exclude= {DataSourceAutoConfiguration.class})
@EnableRetry
@MapperScan(basePackages={"com.kailin.demo.**.mapper"})
@EnableAspectJAutoProxy
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
