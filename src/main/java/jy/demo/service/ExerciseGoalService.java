package jy.demo.service;

import jy.demo.repository.ExerciseGoalRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseGoalService {

    private final ExerciseGoalRepository exerciseGoalRepository;

    public ExerciseGoalService(ExerciseGoalRepository exerciseGoalRepository) {
        this.exerciseGoalRepository = exerciseGoalRepository;
    }


}
