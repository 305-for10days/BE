package jy.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExerciseResDto {

    private Long id;
    private String name;
    private String type;
    private String description;
    private String category;
    private Integer calorie;
    private Integer count;
    private Integer weight;
    private Integer time;
    private Integer distance;

}
