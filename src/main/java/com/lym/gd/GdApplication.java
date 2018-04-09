package com.lym.gd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liuyaming
 * @date 2018/3/11
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class GdApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdApplication.class, args);
    }
}
