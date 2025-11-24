package com.student.data.analyticalService;

public class CalculateMedian extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new MedianClass();
    }
}
