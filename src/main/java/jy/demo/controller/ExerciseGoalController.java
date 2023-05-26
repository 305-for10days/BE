package jy.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.dto.ExerciseGoalResDto;
import jy.demo.service.ExerciseGoalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExerciseGoalController {

    private ExerciseGoalService exerciseGoalService;

    public ExerciseGoalController(ExerciseGoalService exerciseGoalService) {
        this.exerciseGoalService = exerciseGoalService;
    }

    @GetMapping("/routine")
    public List<ExerciseGoalResDto> getExerciseGoals() {
        return exerciseGoalService.getDefaultRoutines().stream()
            .map(exerciseGoal -> new ExerciseGoalResDto(exerciseGoal, exerciseGoal.getDefaultRoutines()))
            .collect(Collectors.toList());
    }

}
