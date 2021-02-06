package com.study;

import com.study.config.ConfigController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStudyApiApplication extends ConfigController {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApiApplication.class, args);
    }

}
