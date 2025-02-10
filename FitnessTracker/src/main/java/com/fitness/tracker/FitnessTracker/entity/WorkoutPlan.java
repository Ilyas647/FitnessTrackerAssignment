package com.fitness.tracker.FitnessTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_plans") // Ensure the table name matches your PostgreSQL schema
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementing ID
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int duration; // Duration in minutes

    @Column(nullable = false)
    private String intensity; // e.g., "Low", "Medium", "High"

    // Default constructor (required by JPA)
    public WorkoutPlan() {}

    // Constructor with parameters
    public WorkoutPlan(String name, int duration, String intensity) {
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    // Override toString() for debugging
    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", intensity='" + intensity + '\'' +
                '}';
    }
}
