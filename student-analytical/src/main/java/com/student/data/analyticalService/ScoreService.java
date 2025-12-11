package com.student.data.analyticalService;

import com.student.data.analyticalEntity.ScoreEntity;
import com.student.data.reposi.AnalyseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ScoreService {

    private List<Double> cal = new ArrayList<>();
   /* @Autowired
    private CalculateClass calculateClass;*/
    @Autowired
    private AnalyseRepo analyseRepo;
    @Autowired
    private Subjects recieveSubject;
    private Long scoreStudentId;
    private String name;

    public ScoreService() {
        /*this.cal = doubleList;
        setCal(cal);*/
    }

    @KafkaListener(topics = "subjects-score", groupId = "subject-score")
    public void consume(Subjects subject)  {
        recieveSubject = subject;
        List<Double> getDouble = new ArrayList<>();
        this.name = recieveSubject.getStudentName();
        this.scoreStudentId = recieveSubject.getId();
        StudentScores studentScores = recieveSubject.getStudentSubjectScore();
        getDouble.add(studentScores.first());
        getDouble.add(studentScores.second());
        getDouble.add(studentScores.third());
        getDouble.add(studentScores.fourth());
        getDouble.add(studentScores.fifth());
        setCal(getDouble);
     //   saveCalculation();
        getCalculation().join();

    }

    private void setCal(List<Double> subScore) {
        this.cal = subScore;
    }

    public List<Double> getCal() {
        return cal;
    }
    public CompletableFuture<Void>getCalculation()
    {
        return CompletableFuture.runAsync(this::saveCalculation);
    }

    private void saveCalculation() {
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setMean(calculatedValue(new CalculateMean()));
        scoreEntity.setMedian(calculatedValue(new CalculateMedian()));
        scoreEntity.setModel(calculatedValue(new CalculateModel()));
        scoreEntity.setName(name);
        scoreEntity.setCalculationId(scoreStudentId);
        analyseRepo.save(scoreEntity);
    }

/*    private Double CalMean() {
      CalculateClass  calculateClass = new CalculateMean();
        return calculateClass.scoreCalculation().CalculateValue(getCal());
    }

    private Double CalModel() {
      CalculateClass  calculateClass = new CalculateModel();
        return calculateClass.scoreCalculation().CalculateValue(getCal());
    }

    private Double CalMedian() {
      CalculateClass  calculateClass = new CalculateMedian();
        return calculateClass.scoreCalculation().CalculateValue(getCal());
    }*/
    private Double calculatedValue(CalculateClass calculateClass)
    {

        return switch (calculateClass)
        {
            case CalculateModel calculateModel-> calculateClass.scoreCalculation().CalculateValue(getCal());
            case CalculateMedian calculateMedian-> calculateClass.scoreCalculation().CalculateValue(getCal());
            case CalculateMean calculateMean-> calculateClass.scoreCalculation().CalculateValue(getCal());
            default -> 0.0;
        };
    }

    public Double findMean(String name) {
        Optional<Double> result = analyseRepo.findMeanValue(name);
        if (result.isPresent()) {
            return result.get();
        } else return -1.0;
    }

    public Double findModel(String name) {
        Optional<Double> result = analyseRepo.findModelValue(name);
        if (result.isPresent()) {
            return result.get();
        } else return -1.0;
    }

    public Double findMedian(String name) {
        Optional<Double> result = analyseRepo.findMeanValue(name);
        if (result.isPresent()) {
            return result.get();
        } else return -1.0;
    }

}
