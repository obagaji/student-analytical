package com.student.data.analyticalService;

public class CalculateMean extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new MeanClass();
    }
}
