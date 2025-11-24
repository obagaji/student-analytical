package com.student_info.studentService;

import com.student_info.repo.StudentRepository;
import com.student_info.studentException.NoStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectImp  implements StudentSubject {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String getStudentString(long id) {
        return studentRepository.findNameById(id).orElseThrow(NoStudentException::new);
    }
}
