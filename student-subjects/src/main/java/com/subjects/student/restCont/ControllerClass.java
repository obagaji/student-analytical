package com.subjects.student.restCont;

import com.subjects.student.subjectEntity.Subjects;
import com.subjects.student.subjectService.MeanClass;
import com.subjects.student.subjectService.MedianClass;
import com.subjects.student.subjectService.ScoreCalculation;
import com.subjects.student.subjectService.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/scores")
public class ControllerClass {
    @Autowired
    private ScoreCalculation calculateMean;
    @Autowired
   private ServiceClass serviceClass;

    @GetMapping("/mean/{name}")
    public ResponseEntity<Double> getMeanScore(@PathVariable("name") String name)
    {
        ScoreCalculation cal = new MeanClass();
       double value = cal.CalculateValue(serviceClass.getScoreWithName(name));
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(value);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.APPLICATION_JSON).body(value);
    }
    @PostMapping("/add")
    public ResponseEntity<Subjects>addSubject(@RequestBody Subjects subjects)
    {
        Subjects subj = serviceClass.addNewSubjectScore(subjects);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(subj);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.APPLICATION_JSON).body(subj);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Subjects> getValue(@PathVariable("name") String name)
    {
        Subjects getSubj = serviceClass.getStudentScoreWithName(name);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(getSubj);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.APPLICATION_JSON).body(getSubj);
    }
    @GetMapping("/median/{name}")
    public ResponseEntity<Double> getMedianScore(@PathVariable("name") String name)
    {
        ScoreCalculation cal = new MedianClass();
        double value = cal.CalculateValue(serviceClass.getScoreWithName(name));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(value);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.APPLICATION_JSON).body(value);
    }
    @GetMapping("/mode/{name}")
    public ResponseEntity<Double> getModeScore(@PathVariable("name") String name)
    {
        ScoreCalculation cal = new MedianClass();
        double value = cal.CalculateValue(serviceClass.getScoreWithName(name));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(value);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header)
                .contentType(MediaType.APPLICATION_JSON).body(value);
    }

}
