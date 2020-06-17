package com.wzxlq.score;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wzxlq.score.dao")
@EnableCaching
//@ComponentScan(basePackages = "com.wzxlq.score.controller")
//启动项目
public class ScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreApplication.class, args);
    }

}
