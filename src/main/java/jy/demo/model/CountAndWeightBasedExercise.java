package jy.demo.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import jy.demo.dto.ExerciseResDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@AllArgsConstructor
@DiscriminatorValue("CountAndWeightBased")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountAndWeightBasedExercise extends Exercise {

    @Column(name = "count")
    private Integer count;

    @Column(name = "weight")
    private Integer weight;

    @Override
    public ExerciseResDto toExerciseResDto() {
        String type = CountAndWeightBasedExercise.class.getSimpleName();
        int cutLength = 8;

        return ExerciseResDto.builder()
            .id(this.getId())
            .type(type.substring(0, type.length() - cutLength))
            .name(this.getName())
            .description(this.getDescription())
            .category(this.getCategory())
            .calorie(this.getCalorie())
            .count(this.getCount())
            .weight(this.getWeight())
            .build();
    }

}
