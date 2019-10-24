package com.gyl.gmall.user;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.springframework.web.bind.annotation.RestController;

@EnableDubbo
@EnableAspectJAutoProxy

@SpringBootApplication
@RestController
public class GmallUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserWebApplication.class, args);
    }


}
