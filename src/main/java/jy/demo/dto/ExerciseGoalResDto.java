package jy.demo.dto;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.model.ExerciseGoal;
import jy.demo.model.Routine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseGoalResDto {

    private String goal;
    private List<RoutineDto> routine;

    public ExerciseGoalResDto(ExerciseGoal exerciseGoal, List<? extends Routine> routines) {
        this.goal = exerciseGoal.getPurpose();
        this.routine = routines
            .stream().map(RoutineDto::new).collect(Collectors.toList());
    }
}
