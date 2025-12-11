package com.student.data.analyticalService;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

@Component
public class Subjects {

        private Long id;
        private String studentName;

        private StudentScores studentSubjectScore;

        public Subjects(Long id, String studentName, StudentScores studentSubjectScore) {
            this.id = id;
            this.studentName = studentName;
            this.studentSubjectScore = studentSubjectScore;
        }

        public Subjects() {
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Nullable
        public StudentScores getStudentSubjectScore() {
            return studentSubjectScore;
        }

        public void setStudentSubjectScore( StudentScores studentSubjectScore) {
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

