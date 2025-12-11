package com.student.data.analyticalService;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public  class ModelClass implements ScoreCalculation {
    @Override
    public double CalculateValue(List<Double> doubleValue) {
        Map<Double, Integer> map = new HashMap<>();
        double result = 0;
        for (Double value : doubleValue) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        List<Integer> values = map.values().stream().toList();
        Optional<Integer> d = values.parallelStream().max(Integer::compareTo);
        for (Map.Entry<Double, Integer> v : map.entrySet()) {
            if (d.get().equals(map.get(v.getKey()))) {
                result = v.getKey();
            }
        }
        return result;
    }
}
