package com.example.MicroA.service;

import com.example.MicroA.feign.TrainingClient;
import com.example.MicroA.model.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrainingService {

    private final TrainingClient trainingClient;

    @Autowired
    public TrainingService(TrainingClient trainingClient) {
        this.trainingClient = trainingClient;
    }

    public TrainingDTO saveTraining(TrainingDTO trainingDTO) {
        return trainingClient.saveTraining(trainingDTO);
    }


}