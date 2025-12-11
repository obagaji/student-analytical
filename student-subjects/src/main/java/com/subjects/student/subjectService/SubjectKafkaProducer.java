package com.subjects.student.subjectService;

import com.subjects.student.subjectEntity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubjectKafkaProducer {

    @Autowired
    KafkaTemplate<String, Subjects> kafkaTemplate;

    public void sendScores(String key,Subjects subject)
    {
        kafkaTemplate.send(key,subject);
    }

}
