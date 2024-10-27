package betek.activity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import betek.activity.model.Training;
import betek.activity.model.TrainingDTO;
import betek.activity.repository.TrainingRepository;
import betek.activity.service.TrainingService;


@RestController
@RequestMapping("/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingService trainingService, TrainingRepository trainingRepository) {
        this.trainingService = trainingService;
        this.trainingRepository = trainingRepository;
    }

    @PostMapping
    public ResponseEntity<Training> saveTraining(@RequestBody TrainingDTO trainingDTO) {
        Training savedTraining = trainingService.saveTraining(trainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
    }
    // Endpoint para obtener los entrenamientos por apprenticeId
    @GetMapping("/report")
    public ResponseEntity<String> getMonthlyReport(@RequestParam String apprenticeId,
                                                   @RequestParam int year,
                                                   @RequestParam int month) {
        String report = trainingService.generateMonthlyReport(apprenticeId, year, month);
        return ResponseEntity.ok(report);
    }

}