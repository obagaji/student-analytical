package com.subjects.student.exceptionClass;

import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;

import java.util.function.Supplier;

public class SCoreNotFoundException extends RuntimeException implements Supplier<Subjects> {
    @Override
    public Subjects get() {
        Subjects sub = new Subjects();
               sub.setId(0L);
                sub.setStudentName("No Value found");
                sub.setStudentSubjectScore(new StudentScores(0.0,0.0,0.0,0.0,0.0));
               // .build();
        return sub;
    }
}
