package com.gyl.gmall.user;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.gyl.gmall.user")
@MapperScan(basePackages = "com.gyl.gmall.user.mapper")
@EnableDubbo
@EnableAspectJAutoProxy
public class GmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserApplication.class, args);
    }

}
