package jy.demo.dto;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.model.ExerciseGoal;
import jy.demo.model.UserRoutine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseGoalResDto {

    private String goal;
    private List<RoutineDto> routine;

    public ExerciseGoalResDto(ExerciseGoal exerciseGoal, List<UserRoutine> routines) {
        this.goal = exerciseGoal.getGoal();
        this.routine = routines
            .stream().map(RoutineDto::new).collect(Collectors.toList());
    }
}
