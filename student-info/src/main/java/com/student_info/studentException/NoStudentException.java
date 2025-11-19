package com.student_info.studentException;

import com.student_info.studentEntiry.Address;
import com.student_info.studentEntiry.StudentEntity;

import java.util.function.Supplier;

public class NoStudentException extends RuntimeException implements Supplier<StudentEntity>  {
    @Override
    public StudentEntity get() {
        return StudentEntity.builder()
                .studentAddress(new Address("","",""))
                .studentId(0L)
                .studentName(" No Name Found")
                .build();
    }
}
