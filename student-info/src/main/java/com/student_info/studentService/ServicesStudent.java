package com.student_info.studentService;

import com.student_info.studentEntiry.StudentEntity;

import java.util.List;

public interface ServicesStudent {

   public List<StudentEntity> getAllStudent();
   public StudentEntity getStudentWithId(Long id);
   public int updateStudent(long id);
   public int updateStudent(StudentEntity student);
   public void deleteStudent(Long id);
   public StudentEntity saveStudent(StudentEntity entity);

}
