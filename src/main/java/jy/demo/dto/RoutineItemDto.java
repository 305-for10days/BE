package jy.demo.dto;

import jy.demo.model.Exercise;
import jy.demo.model.RoutineItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineItemDto {

    private Long workoutId;
    private int set;
    private int completedSet;
    private int calorie;

    public RoutineItemDto(RoutineItem routineItem) {

        Exercise exercise = routineItem.getExercise();

        this.workoutId = exercise.getId();
        this.set = routineItem.getSetCount();
    }

    private int getCalorie(int goalCalorie, int calorie) {
        int set = (int) Math.floor(goalCalorie / calorie);

        if (set == 0) {
            set = 1;
        }

        return set;
    }

    public RoutineItem toEntity() {
        return RoutineItem.builder()
            .goalCalorie(this.calorie)
            .setCount(this.set)
            .build();
    }
}
