package com.example.Actividades.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ActivityRequest {

    @NotBlank(message = "Apprentice ID is mandatory")
    private String apprenticeId;

    @NotBlank(message = "Apprentice Username is mandatory")
    private String apprenticeUsername;

    @NotBlank(message = "Trainer ID is mandatory")
    private String trainerId;

    @NotBlank(message = "Training Name is mandatory")
    private String trainingName;

    @NotBlank(message = "Training Type is mandatory")
    private String trainingType;

    @NotNull(message = "Training Date is mandatory")
    private LocalDate trainingDate;

    @NotNull(message = "Duration is mandatory")
    private Integer durationInMinutes;
}