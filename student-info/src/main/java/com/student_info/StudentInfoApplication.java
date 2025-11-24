package com.student_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoApplication.class, args);
    }

}
