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
@DiscriminatorValue("CountBased")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountBasedExercise extends Exercise {

    @Column(name = "count")
    private Integer count;

    @Override
    public ExerciseResDto toExerciseResDto() {
        String type = CountBasedExercise.class.getSimpleName();
        int cutLength = 8;

        return ExerciseResDto.builder()
            .id(this.getId())
            .type(type.substring(0, type.length() - cutLength))
            .name(this.getName())
            .description(this.getDescription())
            .category(this.getCategory())
            .calorie(this.getCalorie())
            .count(this.getCount())
            .build();
    }
}
