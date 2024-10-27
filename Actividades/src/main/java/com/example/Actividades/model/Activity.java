package com.example.Actividades.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activities")
public class Activity {

    @Id
    private String id; // El identificador de Mongo es String por defecto

    private String apprenticeId;    // Identificación del aprendiz
    private String apprenticeUsername; // Nombre del aprendiz
    private String trainerId;       // Identificación del entrenador
    private String trainingName;    // Nombre del entrenamiento
    private String trainingType;    // Tipo de entrenamiento
    private LocalDate trainingDate; // Fecha del entrenamiento
    private Integer durationInMinutes;
}
