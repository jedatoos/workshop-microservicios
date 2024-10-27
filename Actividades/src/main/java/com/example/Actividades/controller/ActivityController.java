package com.example.Actividades.controller;

import com.example.Actividades.model.DTO.ActivityRequest;
import com.example.Actividades.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // Endpoint para registrar una actividad
    @PostMapping("/register")
    public ResponseEntity<String> registerActivity(@RequestBody @Valid ActivityRequest activityRequest) {
        activityService.registerActivity(activityRequest);
        return ResponseEntity.ok("Activity registered successfully.");
    }

    // Endpoint para obtener el reporte mensual de un aprendiz
    @GetMapping("/report/{apprenticeId}/{year}/{month}")
    public ResponseEntity<String> getMonthlyReport(
            @PathVariable String apprenticeId,
            @PathVariable int year,
            @PathVariable int month) {

        String report = activityService.getMonthlyReport(apprenticeId, year, month);
        return ResponseEntity.ok(report);
    }
}
