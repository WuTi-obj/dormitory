package com.wuti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.wuti.mapper")
public class DormitorymsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitorymsApplication.class, args);
    }

}

