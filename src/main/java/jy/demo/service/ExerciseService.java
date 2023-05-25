package jy.demo.service;

import java.util.List;
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

}
