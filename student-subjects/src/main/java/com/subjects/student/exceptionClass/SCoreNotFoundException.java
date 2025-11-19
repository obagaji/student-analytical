package com.subjects.student.exceptionClass;

import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;

import java.util.function.Supplier;

public class SCoreNotFoundException extends RuntimeException implements Supplier<Subjects> {
    @Override
    public Subjects get() {
        return Subjects.builder()
                .id(0L)
                .studentName("No Value found")
                .studentSubjectScore(new StudentScores(0.0,0.0,0.0,0.0,0.0))
                .build();
    }
}
