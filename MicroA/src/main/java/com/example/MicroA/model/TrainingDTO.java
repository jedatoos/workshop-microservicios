package com.example.MicroA.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {

    private String apprenticeId;
    private String apprenticeUsername;
    private String trainerId;
    private String trainingName;
    private LocalDate trainingDate;
    private String trainingType;
    private String trainingDuration;


}
