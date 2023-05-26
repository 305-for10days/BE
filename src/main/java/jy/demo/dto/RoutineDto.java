package jy.demo.dto;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.model.Routine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoutineDto {

    private Long id;
    private String goal;
    private List<RoutineItemDto> details;

    public RoutineDto(Routine routine) {
        this.id = routine.getId();
        this.goal = routine.getExerciseGoal().getPurpose();
        this.details = routine.getRoutineItems()
            .stream().map(RoutineItemDto::new).collect(Collectors.toList());
    }
}
