package jy.demo.dto;

import java.util.List;
import java.util.stream.Collectors;
import jy.demo.model.Routine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDto {

    private Long id;
    private String goal;
    private String calorie;
    private List<RoutineItemDto> details;

    public RoutineDto(Routine routine) {
        this.id = routine.getId();
        this.goal = routine.getExerciseGoal().getGoal();
        this.details = routine.getRoutineItems()
            .stream().map(RoutineItemDto::new).collect(Collectors.toList());
    }

}
