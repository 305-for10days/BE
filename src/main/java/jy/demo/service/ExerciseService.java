package jy.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import jy.demo.common.HttpResponse;
import jy.demo.dto.ExerciseRecommendDto;
import jy.demo.exception.DataNotFoundException;
import jy.demo.model.Exercise;
import jy.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    final private ExerciseRepository exerciseRepository;


    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseRecommend(ExerciseRecommendDto dto) {
        List<? extends Exercise> exercisesByType = exerciseRepository.findByCategory(dto.getType());

        if (exercisesByType.isEmpty()) {
            throw new DataNotFoundException(HttpResponse.EXERCISE_NOT_FOUND);
        }

        return getRandomExercise(exercisesByType, dto.getWorkoutId());
    }

    private Exercise getRandomExercise(List<? extends Exercise> exercises, Long overlapId) {
        exercises.removeIf(exercise1 -> Objects.equals(exercise1.getId(), overlapId));

        int random = new Random().nextInt(exercises.size());

        return exercises.get(random);
    }

}
