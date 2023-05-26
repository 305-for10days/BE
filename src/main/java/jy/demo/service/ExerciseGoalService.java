package jy.demo.service;

import java.util.List;
import jy.demo.model.ExerciseGoal;
import jy.demo.repository.ExerciseGoalRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseGoalService {

    private final ExerciseGoalRepository exerciseGoalRepository;

    public ExerciseGoalService(ExerciseGoalRepository exerciseGoalRepository) {
        this.exerciseGoalRepository = exerciseGoalRepository;
    }


    public List<ExerciseGoal> getDefaultRoutines() {
        // TODO: default routine 과 관련된 정보 조인해서 한번해 가져오도록 구현
        return exerciseGoalRepository.findAll();
    }


}
