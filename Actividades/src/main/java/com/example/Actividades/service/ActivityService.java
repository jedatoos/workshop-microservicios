package com.example.Actividades.service;

import com.example.Actividades.model.Activity;
import com.example.Actividades.model.DTO.ActivityRequest;
import com.example.Actividades.repository.ActivityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // Método para registrar una actividad
    public void registerActivity(@Valid ActivityRequest activityRequest) {
        Activity activity = new Activity();
        activity.setApprenticeId(activityRequest.getApprenticeId());
        activity.setApprenticeUsername(activityRequest.getApprenticeUsername());
        activity.setTrainerId(activityRequest.getTrainerId());
        activity.setTrainingName(activityRequest.getTrainingName());
        activity.setTrainingType(activityRequest.getTrainingType());
        activity.setTrainingDate(activityRequest.getTrainingDate());
        activity.setDurationInMinutes(activityRequest.getDurationInMinutes());

        activityRepository.save(activity);
    }

    // Método para generar un reporte mensual de actividades por aprendiz
    public String getMonthlyReport(String apprenticeId, int year, int month) {
        // Obtenemos el rango de fechas del mes
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        // Obtener las actividades de ese mes
        List<Activity> activities = activityRepository.findAllByApprenticeIdAndTrainingDateBetween(apprenticeId, startDate, endDate);

        // Agrupar las actividades por semanas del mes
        Map<Integer, List<Activity>> activitiesByWeek = activities.stream()
                .collect(Collectors.groupingBy(activity -> activity.getTrainingDate().get(ChronoField.ALIGNED_WEEK_OF_MONTH)));

        // Crear el reporte
        StringBuilder report = new StringBuilder();
        report.append("Reporte Mensual del Aprendiz ").append(apprenticeId).append(" (")
                .append(startDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()))
                .append(" ").append(year).append("):\n");

        // Rellenar con actividades por semanas
        activitiesByWeek.forEach((week, weeklyActivities) -> {
            report.append("Semana ").append(week).append(":\n");
            weeklyActivities.forEach(activity -> {
                report.append("- ").append(activity.getTrainingDate()).append(", ")
                        .append(activity.getTrainingName()).append("\n");
            });
        });

        return report.toString();
    }
}
