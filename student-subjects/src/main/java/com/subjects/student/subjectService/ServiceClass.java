package com.subjects.student.subjectService;


import com.subjects.student.exceptionClass.SCoreNotFoundException;
import com.subjects.student.reposi.StudentRepo;
import com.subjects.student.subjectEntity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClass //implements ScoreCalculation
{
    @Autowired
    private StudentRepo repo;

    public Subjects getStudentScoreWithName(String name) {
        return repo.findByStudentName(name).orElseThrow(SCoreNotFoundException::new);
    }

    public List<Double> getScoreWithName(String name) {
        Subjects stud = new Subjects();
        stud = repo.findByStudentName(name).orElseThrow(SCoreNotFoundException::new);
        return getDoubleValue(stud);
    }

    private List<Double> getDoubleValue(Subjects subjects) {
        List<Double> listValue = new ArrayList<>();
        listValue.add(subjects.getStudentSubjectScore().firstScore());
        listValue.add(subjects.getStudentSubjectScore().secondScore());
        listValue.add(subjects.getStudentSubjectScore().thirdScore());
        listValue.add(subjects.getStudentSubjectScore().fourthScore());
        listValue.add(subjects.getStudentSubjectScore().fifthScore());
        return listValue;
    }

    public Subjects addNewSubjectScore(Subjects value) {
        return repo.save(value);
    }

    public List<Subjects> findAllScores() {
        return repo.findAll();
    }
}
