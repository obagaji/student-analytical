package com.subjects.student.reposi;

import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Subjects,Long> {
    Optional<Subjects> findByStudentName(String name);
}
