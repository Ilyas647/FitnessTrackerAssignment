package com.fitness.tracker.FitnessTracker.repository;

import com.fitness.tracker.FitnessTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
