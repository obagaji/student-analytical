package com.student.data.analyticalService;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public  class MeanClass implements ScoreCalculation {
    @Override
    public double CalculateValue(List<Double> doubleValue) {

      Optional<Double> streamValue= doubleValue.stream().reduce(Double::sum);
        return streamValue.map(aDouble -> aDouble / doubleValue.size()).orElse(0.0);
    }
}
