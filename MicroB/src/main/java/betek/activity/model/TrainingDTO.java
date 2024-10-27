package betek.activity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    @Id
     private String id;
    private Long apprenticeId;
    private String apprenticeUsername;
    private Long trainerId;
    private String trainingName;
    private LocalDate trainingDate;
    private String trainingType;
    private String trainingDuration;
}
