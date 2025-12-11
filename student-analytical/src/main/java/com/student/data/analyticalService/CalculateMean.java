package com.student.data.analyticalService;

import org.springframework.stereotype.Component;

@Component
public class CalculateMean extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new MeanClass();
    }
}
