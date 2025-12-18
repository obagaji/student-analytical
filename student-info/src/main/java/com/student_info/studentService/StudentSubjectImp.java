package com.student_info.studentService;

import com.student_info.repo.StudentRepository;
import com.student_info.studentEntiry.StudentEntity;
import com.student_info.studentException.NoStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSubjectImp  implements StudentSubject {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String getStudentString(long id) {
        return studentRepository.findNameById(id).orElseThrow(NoStudentException::new);
    }
    public StudentNameId getStudentName(long id)
    {
        StudentEntity student = studentRepository.findById(id).orElseThrow();
        return new StudentNameId(student.getStudentName(), student.getStudentId());
    }
    public StudentEntity saveStudent(StudentEntity entity)
    {
      return   studentRepository.save(entity);
    }

    public List<StudentEntity> allSaveStudent() {
        return studentRepository.findAll();
    }
}
