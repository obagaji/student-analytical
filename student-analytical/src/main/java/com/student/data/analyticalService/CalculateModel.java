package com.student.data.analyticalService;

public class CalculateModel extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new ModelClass();
    }
}
