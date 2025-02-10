package com.fitness.tracker.FitnessTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fitness_apps")
public class FitnessApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String appName;

    @Column(nullable = false)
    private String goal;

    @Column(nullable = false)
    private String subscriptionType;

    public FitnessApp() {}

    public FitnessApp(String appName, String goal, String subscriptionType) {
        this.appName = appName;
        this.goal = goal;
        this.subscriptionType = subscriptionType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public String getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(String subscriptionType) { this.subscriptionType = subscriptionType; }

    @Override
    public String toString() {
        return "FitnessApp{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", goal='" + goal + '\'' +
                ", subscriptionType='" + subscriptionType + '\'' +
                '}';
    }
}
