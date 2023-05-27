package jy.demo.dto;

import jy.demo.model.Exercise;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExerciseRecommendDto {

    private Long workoutId;
    private String category;
    private int set;
    private int calorie;

    public ExerciseRecommendDto(Exercise exercise, int calorie, int set) {
        this.workoutId = exercise.getId();
        this.category = exercise.getCategory();
        this.set = calculateSet(exercise, calorie * set);
        if (this.set == 0) {
            this.set = 1;
        }
        this.calorie = calorie;
    }

    private int calculateSet(Exercise exercise, int totalCalorie) {
        return Math.round(totalCalorie / exercise.getCalorie());
    }
}
