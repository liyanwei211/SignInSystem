package com.liyanwei.signinsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@MapperScan("com.liyanwei.signinsystem.mapper")
@EnableRedisHttpSession
@SpringBootApplication
public class SigninsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigninsystemApplication.class, args);
    }

}
