package com.subjects.student.subjectService;


import java.util.List;

public sealed interface ScoreCalculation permits ModelClass, MedianClass, MeanClass {
   public double CalculateValue(List<Double> doubleValue);
}
