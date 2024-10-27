package betek.activity.service;

import betek.activity.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betek.activity.model.Training;
import betek.activity.model.TrainingDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class TrainingService {


    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    // Método para guardar entrenamientos
    public Training saveTraining(TrainingDTO trainingDTO) {
        Training training = new Training();
        training.setId(trainingDTO.getId());
        training.setApprenticeId(trainingDTO.getApprenticeId());
        training.setApprenticeUsername(trainingDTO.getApprenticeUsername());
        training.setTrainerId(trainingDTO.getTrainerId());
        training.setTrainingName(trainingDTO.getTrainingName());
        training.setTrainingDate(trainingDTO.getTrainingDate());
        training.setTrainingType(trainingDTO.getTrainingType());
        training.setTrainingDuration(trainingDTO.getTrainingDuration());

        // No establecer manualmente el ID aquí, MongoDB lo hará por ti

        return trainingRepository.save(training);
    }

    public String generateMonthlyReport(String apprenticeId, int year, int month) {
        // Definir el rango de fechas para el mes
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1); // Asegúrate de que sea hasta el último día del mes

        // Obtener entrenamientos del repositorio
        List<Training> trainings = trainingRepository.findByApprenticeIdAndDate(apprenticeId, startDate, endDate);

        // Agrupar entrenamientos por semana
        Map<Integer, List<Training>> weeklyTrainings = trainings.stream()
                .collect(Collectors.groupingBy(training -> training.getTrainingDate().get(WeekFields.of(Locale.getDefault()).weekOfMonth())));

        StringBuilder report = new StringBuilder();
        report.append("Reporte Mensual del Aprendiz ").append(apprenticeId)
                .append(" (").append(Month.of(month).name()).append(" ").append(year).append("):\n");

        // Iterar sobre las semanas del mes (1 a 5)
        for (int week = 1; week <= 4; week++) {
            report.append("Semana ").append(week).append(":\n");

            // Obtener los entrenamientos de la semana actual
            List<Training> weekTrainings = weeklyTrainings.getOrDefault(week, new ArrayList<>());

            if (weekTrainings.isEmpty()) {
                report.append("- No asistió\n");
            } else {
                for (Training training : weekTrainings) {
                    // Obtener el día de la semana
                    DayOfWeek dayOfWeek = training.getTrainingDate().getDayOfWeek();
                    // Formatear la fecha y el entrenamiento
                    report.append("- ").append(dayOfWeek).append(": ")
                            .append(training.getTrainingDate()).append(", ")
                            .append(training.getTrainingType()).append("\n");
                }
            }
        }
        return report.toString();
    }
}