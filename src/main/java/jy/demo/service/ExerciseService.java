package jy.demo.service;

import java.util.List;
import java.util.Objects;
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

//    public Exercise getExerciseRecommend(ExerciseRecommendDto dto) {
//        List<Exercise> exercisesByType = exerciseRepository.findAllByType(dto.getType());
//
//
//    }

    private Exercise getRandomExercise(List<Exercise> exercises, Long overlapId) {
        exercises.removeIf(exercise1 -> Objects.equals(exercise1.getId(), overlapId));
        int random = (int) (Math.random() / exercises.size());

        return exercises.get(random);
    }
}
