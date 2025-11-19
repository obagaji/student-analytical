package com.student_info.repo;

import com.student_info.studentEntiry.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query(" Update StudentEntity set studentName=:studentName, studentAddress =: studentAddress where studentId=: studentId")
    int updateEntity(Long student);

    @Query(" Update StudentEntity set studentName=:studentName, studentAddress =:studentAddress where studentId=: studentId")
    int updateEntity(StudentEntity student);

}
