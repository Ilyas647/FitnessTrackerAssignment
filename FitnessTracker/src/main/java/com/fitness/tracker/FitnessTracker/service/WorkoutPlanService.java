package com.fitness.tracker.FitnessTracker.service;

import com.fitness.tracker.FitnessTracker.entity.WorkoutPlan;
import com.fitness.tracker.FitnessTracker.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository repository;

    public WorkoutPlanService(WorkoutPlanRepository repository) {
        this.repository = repository;
    }

    public List<WorkoutPlan> getAllWorkoutPlans() {
        return repository.findAll();
    }

    public Optional<WorkoutPlan> getWorkoutPlanById(Long id) {
        return repository.findById(id);
    }

    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        try {
            return repository.save(workoutPlan);
        } catch (Exception e) {
            throw new RuntimeException("Error creating workout plan: " + e.getMessage());
        }
    }

    public void deleteWorkoutPlan(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new RuntimeException("Workout Plan not found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting workout plan: " + e.getMessage());
        }
    }
}
