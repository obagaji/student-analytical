package com.subjects.student;

import org.springframework.boot.SpringApplication;

public class TestStudentSubjectsApplication {

	public static void main(String[] args) {
		SpringApplication.from(StudentSubjectsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
