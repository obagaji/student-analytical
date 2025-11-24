package com.subjects.student.subjectEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    @Embedded/*
    @Nullable
    @Max(value = 100)
    @Min(value = 0)*/
    private StudentScores studentSubjectScore;

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public StudentScores getStudentSubjectScore() {
        return studentSubjectScore;
    }

    public void setStudentSubjectScore(@Nullable StudentScores studentSubjectScore) {
        this.studentSubjectScore = studentSubjectScore;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
