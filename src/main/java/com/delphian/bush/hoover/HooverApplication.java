package com.delphian.bush.hoover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HooverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooverApplication.class, args);
    }

}
