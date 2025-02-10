package com.fitness.tracker.FitnessTracker.controller;

import com.fitness.tracker.FitnessTracker.entity.WorkoutPlan;
import com.fitness.tracker.FitnessTracker.service.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout-plans")
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;

    @Autowired
    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanService.getAllWorkoutPlans();
        return ResponseEntity.ok(workoutPlans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutPlanById(@PathVariable Long id) {
        Optional<WorkoutPlan> workoutPlan = workoutPlanService.getWorkoutPlanById(id);
        return workoutPlan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
        try {
            WorkoutPlan createdWorkoutPlan = workoutPlanService.createWorkoutPlan(workoutPlan);
            return ResponseEntity.ok(createdWorkoutPlan);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkoutPlan(@PathVariable Long id) {
        try {
            workoutPlanService.deleteWorkoutPlan(id);
            return ResponseEntity.ok("Workout Plan deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
