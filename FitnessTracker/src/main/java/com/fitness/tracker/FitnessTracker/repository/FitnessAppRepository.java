package com.fitness.tracker.FitnessTracker.repository;

import com.fitness.tracker.FitnessTracker.entity.FitnessApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessAppRepository extends JpaRepository<FitnessApp, Long> {
}
