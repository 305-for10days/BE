package jy.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.dto.ExerciseResDto;
import jy.demo.model.Exercise;
import jy.demo.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExerciseController {

    final private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/workouts")
    public List<ExerciseResDto> getExercises() {
        List<Exercise> exercises = exerciseService.getExercises();
        return exercises.stream().map(Exercise::toExerciseResDto)
            .collect(Collectors.toList());
    }


}
