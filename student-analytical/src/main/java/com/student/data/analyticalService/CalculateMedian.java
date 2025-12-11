package com.student.data.analyticalService;

import org.springframework.stereotype.Component;

@Component
public class CalculateMedian extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new MedianClass();
    }
}
