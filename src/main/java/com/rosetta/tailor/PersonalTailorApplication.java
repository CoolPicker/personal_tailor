package com.rosetta.tailor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.rosetta.tailor.dao")
@EnableScheduling
@SpringBootApplication
public class PersonalTailorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PersonalTailorApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        // 指向用main方法执行的application启动类
        return builder.sources(PersonalTailorApplication.class);
    }

}
