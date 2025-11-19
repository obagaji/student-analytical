package com.student_info.studentService;

import com.student_info.repo.StudentRepository;
import com.student_info.studentEntiry.StudentEntity;
import com.student_info.studentException.NoStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements ServicesStudent{

    @Autowired
    StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }


    public StudentEntity getStudentWithId(Long id) {
        if (id != null ) {
            return studentRepository.findById(id).orElseThrow(NoStudentException::new);
        }
        else {
            throw new NoStudentException();
        }
    }


    public int updateStudent(long id) {
        Object l = id;
        int returnValue =0;
        if (l != null && l instanceof Long lo)
            if (studentRepository.existsById(lo)){
                returnValue= studentRepository.updateEntity(lo);}
        else{
                returnValue= -1;}

        return returnValue;
    }


    public int updateStudent(StudentEntity student) {
        Long studentLong = student.getStudentId();
        return studentRepository.updateEntity(student);
    }


    public void deleteStudent(Long id) {
       boolean value =  studentRepository.existsById(id);
       if (value)
       {
           studentRepository.deleteById(id);
       }
    }

    public StudentEntity saveStudent(StudentEntity entity) {
        return studentRepository.save(entity);
    }
}
