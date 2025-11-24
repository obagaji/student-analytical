package com.student.data.reposi;

import com.student.data.analyticalEntity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnalyseRepo extends JpaRepository<ScoreEntity, Long> {
    Optional<ScoreEntity>findByName(String name);
    @Query("select mean from ScoreEntity s where s.name = : name ")
    Optional<Double>findMeanValue(@Param("name")String name);
    @Query("select median from ScoreEntity s where s.name = : name ")
    Optional<Double>findMedianValue(@Param("name")String name);
    @Query("select model from ScoreEntity s where s.name = : name ")
    Optional<Double>findModelValue(@Param("name")String name);
}
