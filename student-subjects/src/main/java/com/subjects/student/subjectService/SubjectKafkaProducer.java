package com.subjects.student.subjectService;

import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubjectKafkaProducer {

    @Autowired
    private ScoreCalculation scoreCalculation;
    @Autowired
    private KafkaTemplate<String, Subjects> kafkaTemplate;

    public void sendScores(String value, Subjects recordValue)
    {
        kafkaTemplate.send(value,recordValue);
    }


}
