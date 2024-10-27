package com.example.MicroA.controller;

import com.example.MicroA.feign.TrainingClient;
import com.example.MicroA.model.TrainingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/microA")
public class MicroAController {


    private final TrainingClient trainingClient;

    @Autowired
    public MicroAController(TrainingClient trainingClient) {
        this.trainingClient = trainingClient;
    }

    @PostMapping("/trainings")
    public ResponseEntity<TrainingDTO> createTraining(@RequestBody TrainingDTO trainingDTO) {
        // Llamar a Microservicio 2 para guardar el entrenamiento
        TrainingDTO savedTraining = trainingClient.saveTraining(trainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
    }
    // Método para obtener el entrenamiento de un aprendiz
    @GetMapping("/trainings/{apprenticeId}")
    public ResponseEntity<TrainingDTO> getTrainingByApprenticeId(@PathVariable String apprenticeId) {
        TrainingDTO trainingDTO = trainingClient.getTrainingByApprenticeId(apprenticeId);
        if (trainingDTO != null) {
            return ResponseEntity.ok(trainingDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no se encuentra
        }
    }



}