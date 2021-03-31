package com.daming.bootstring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//主入口
@SpringBootApplication
@MapperScan("com.daming.bootstring.mapper")
public class BootstringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstringApplication.class, args);
    }

}
