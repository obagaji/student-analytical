package com.student.data.analyticalService;

import org.springframework.stereotype.Component;

@Component
public class CalculateModel extends CalculateClass{
    @Override
    public ScoreCalculation scoreCalculation() {
        return new ModelClass();
    }
}
