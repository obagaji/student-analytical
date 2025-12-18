package com.student_info;

import com.student_info.studentEntiry.Address;
import com.student_info.studentEntiry.StudentEntity;
import com.student_info.studentService.StudentSubjectImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class StudentInputTest {

    @Autowired
    StudentSubjectImp subjectImp;

    @Test
    void addStudentTest()
    {
        StudentEntity student = StudentEntity.builder()
                .studentAddress(new Address("Nigeria","Lagos","Olaoye"))
                .studentName("Musa Daniel")
                .build();
        StudentEntity sEntity = subjectImp.saveStudent(student);
        assertSame(sEntity,student);
    }
}
