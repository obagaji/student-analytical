package com.subjects.student.subjectService;

import java.util.List;

public final class MedianClass implements ScoreCalculation {
    @Override
    public double CalculateValue(List<Double> doubleValue) {
        List<Double> streamValue= doubleValue.stream().sorted().toList();
        if (streamValue.size()%2 ==0)
        {
            int med = streamValue.size()/2;
            int med2 = med + 1;
            return (double)(streamValue.get(med) + streamValue.get(med2))/2;
        }
        else {
            int med = streamValue.size()/2;
            return (double)streamValue.get(med);
        }
    }
}
