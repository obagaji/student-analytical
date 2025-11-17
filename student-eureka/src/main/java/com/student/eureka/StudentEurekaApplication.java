package com.student.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudentEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentEurekaApplication.class, args);
	}

}
