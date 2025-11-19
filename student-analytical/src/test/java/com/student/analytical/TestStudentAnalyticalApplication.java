package com.student.analytical;

import com.student.data.StudentAnalyticalApplication;
import org.springframework.boot.SpringApplication;

public class TestStudentAnalyticalApplication {

	public static void main(String[] args) {
		SpringApplication.from(StudentAnalyticalApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
