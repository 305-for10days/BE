package jy.demo.controller;

import jy.demo.service.ExerciseGoalService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseGoalController {

    private ExerciseGoalService exerciseGoalService;

    public ExerciseGoalController(ExerciseGoalService exerciseGoalService) {
        this.exerciseGoalService = exerciseGoalService;
    }

}
