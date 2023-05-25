package jy.demo.dto;

import jy.demo.model.Exercise;
import jy.demo.model.RoutineItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoutineItemDto {

    private Long workoutId;
    private int set;

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
}
