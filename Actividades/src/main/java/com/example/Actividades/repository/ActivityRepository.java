package com.example.Actividades.repository;

import com.example.Actividades.model.Activity;

import java.time.LocalDate;
import java.util.List;

public class ActivityRepository {
    List<Activity> findAllByApprenticeIdAndTrainingDateBetween(String apprenticeId, LocalDate startDate, LocalDate endDate);


}
