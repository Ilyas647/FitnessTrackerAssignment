package com.fitness.tracker.FitnessTracker.service;

import com.fitness.tracker.FitnessTracker.entity.FitnessApp;
import com.fitness.tracker.FitnessTracker.repository.FitnessAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FitnessAppService {
    private final FitnessAppRepository fitnessAppRepository;

    @Autowired
    public FitnessAppService(FitnessAppRepository fitnessAppRepository) {
        this.fitnessAppRepository = fitnessAppRepository;
    }

    public List<FitnessApp> getAllFitnessApps() {
        return fitnessAppRepository.findAll();
    }

    public Optional<FitnessApp> getFitnessAppById(Long id) {
        return fitnessAppRepository.findById(id);
    }

    public FitnessApp createFitnessApp(FitnessApp fitnessApp) {
        return fitnessAppRepository.save(fitnessApp);
    }

    public void deleteFitnessApp(Long id) {
        fitnessAppRepository.deleteById(id);
    }
}
