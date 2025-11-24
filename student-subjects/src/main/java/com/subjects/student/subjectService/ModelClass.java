package com.subjects.student.subjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class ModelClass implements ScoreCalculation {
    @Override
    public double CalculateValue(List<Double> doubleValue) {
        Map<Double, Double> map = new HashMap<>();
        Double result = 0.0;
        for (Double value : doubleValue) {
            map.put(value, map.getOrDefault(value, 0.0) + 1);
        }
        List<Double> values = map.values().stream().toList();
        Optional<Double> d = map.values().parallelStream().max(Double::compareTo);
        for (Map.Entry<Double, Double> v : map.entrySet()) {
            if (d.get().equals(map.get(v.getKey()))) {
                result = d.get();
            }
        }

        return result;
    }
}
