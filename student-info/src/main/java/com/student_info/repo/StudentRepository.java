package com.student_info.repo;

import com.student_info.studentEntiry.Address;
import com.student_info.studentEntiry.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query(" Update StudentEntity set studentName=:studentName, studentAddress =:studentAddress where studentId=: studentId")
    int updateEntity(@Param("studentName")String studentName,@Param("studentAddress") Address studentAddress,@Param("studentId")Long studentId);

    @Query("select studentName from StudentEntity where studentId=:studentId ")
    Optional< String> findNameById(@Param("studentId")Long id);
}
