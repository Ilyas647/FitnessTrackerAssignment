package com.fitness.tracker.FitnessTracker.controller;

import com.fitness.tracker.FitnessTracker.entity.FitnessApp;
import com.fitness.tracker.FitnessTracker.service.FitnessAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fitness-apps")
public class FitnessAppController {
    private final FitnessAppService fitnessAppService;

    @Autowired
    public FitnessAppController(FitnessAppService fitnessAppService) {
        this.fitnessAppService = fitnessAppService;
    }

    @GetMapping
    public List<FitnessApp> getAllFitnessApps() {
        return fitnessAppService.getAllFitnessApps();
    }

    @GetMapping("/{id}")
    public Optional<FitnessApp> getFitnessAppById(@PathVariable Long id) {
        return fitnessAppService.getFitnessAppById(id);
    }

    @PostMapping
    public FitnessApp createFitnessApp(@RequestBody FitnessApp fitnessApp) {
        return fitnessAppService.createFitnessApp(fitnessApp);
    }

    @DeleteMapping("/{id}")
    public void deleteFitnessApp(@PathVariable Long id) {
        fitnessAppService.deleteFitnessApp(id);
    }
}
