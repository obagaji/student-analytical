package com.student_info;

import org.springframework.boot.SpringApplication;

public class TestStudentInfoApplication {

	public static void main(String[] args) {
		SpringApplication.from(StudentInfoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
