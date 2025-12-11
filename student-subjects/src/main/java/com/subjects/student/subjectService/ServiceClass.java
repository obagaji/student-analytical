package com.subjects.student.subjectService;

import com.subjects.student.reposi.StudentRepo;
import com.subjects.student.subjectEntity.NameId;
import com.subjects.student.subjectEntity.StudentScores;
import com.subjects.student.subjectEntity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ServiceClass {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    RestClient restClient;


  public Subjects addNewSubjectScore(Subjects subject)
  {
      /*restClient.post()
              .uri("/api/calculate/score")
              .body(subject)
              .contentType(MediaType.APPLICATION_JSON)
              .retrieve()
              .toEntity(Subjects.class);
              */

      return studentRepo.save(subject);
  }
  public Subjects createSubject(StudentScores scores, Long id)
  {
   NameId  nameId = restClient.get()
              .uri("/student/{id}", id)
              .retrieve()
              .toEntity(NameId.class).getBody();
      return new Subjects(nameId.id(), nameId.name(), scores);
  }
  public List<Subjects> findAllScores()
  {
      return studentRepo.findAll();
  }


}
