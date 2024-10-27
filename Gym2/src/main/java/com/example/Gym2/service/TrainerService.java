package com.example.Gym2.service;


import com.example.Gym2.model.Trainer;
import com.example.Gym2.repository.TrainerRepository;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {


    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer addTrainer(Trainer trainer) {
        // Validate that the email is unique
        if (trainerRepository.findByEmail(trainer.getEmail()).isPresent()) {
            throw new ValidationException("The email is already registered.");
        }
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer updatedTrainer) {
        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        // Update existing trainer's attributes
        existingTrainer.setName(updatedTrainer.getName());
        existingTrainer.setEmail(updatedTrainer.getEmail());
        existingTrainer.setPassword(updatedTrainer.getPassword());
        existingTrainer.setSpecialty(updatedTrainer.getSpecialty());
        existingTrainer.setExperienceYears(updatedTrainer.getExperienceYears());
        existingTrainer.setExperienceYears(updatedTrainer.getExperienceYears());

        return trainerRepository.save(existingTrainer);
    }
}