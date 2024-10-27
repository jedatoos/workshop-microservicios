package betek.activity.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import betek.activity.model.Training;

import java.time.LocalDate;
import java.util.List;



public interface TrainingRepository extends MongoRepository<Training, String> {
    List<Training> findByApprenticeIdAndTrainingDate(String apprenticeId, LocalDate trainingDate);

    @Query("{ 'apprenticeId': ?0, 'trainingDate': { $gte: ?1, $lt: ?2 } }")
    List<Training> findByApprenticeIdAndDate(String apprenticeId, LocalDate startDate, LocalDate endDate);
}
