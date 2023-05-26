package jy.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExerciseRecommendDto {

    private Long WorkoutId;
    private String type;
    private int calorie;
}
