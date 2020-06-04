package com.lock2_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lock2_demo.dao")
public class Lock2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lock2DemoApplication.class, args);
    }

}
