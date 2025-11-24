package com.student.data.analyticalEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScoreEntity {

    @Id
    private Long calculationId;
    private String name;
    private double mean;
    private double median;
    private double model;

    public ScoreEntity(Long calculationId, String name, double mean, double median, double model) {
        this.calculationId = calculationId;
        this.name = name;
        this.mean = mean;
        this.median = median;
        this.model = model;
    }

    public ScoreEntity() {
    }

    public Long getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(Long calculationId) {
        this.calculationId = calculationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double getModel() {
        return model;
    }

    public void setModel(double model) {
        this.model = model;
    }
}
