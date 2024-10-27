package com.example.MicroA.feign;

import com.example.MicroA.model.TrainingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MicroB", url = "http://localhost:8081")
public interface TrainingClient {

    @PostMapping("/trainings")
    TrainingDTO saveTraining(@RequestBody TrainingDTO trainingDTO);

    @GetMapping("/trainings/{apprenticeId}")
    TrainingDTO getTrainingByApprenticeId(@PathVariable("apprenticeId") String apprenticeId);

}