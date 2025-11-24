package com.subjects.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentSubjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSubjectsApplication.class, args);
    }

}
