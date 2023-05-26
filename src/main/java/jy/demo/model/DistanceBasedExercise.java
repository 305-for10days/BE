package jy.demo.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import jy.demo.common.ExerciseType;
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
@DiscriminatorValue("DISTANCE_BASED")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DistanceBasedExercise extends Exercise {

    @Column(name = "distance")
    private Integer distance;

    @Override
    public ExerciseResDto toExerciseResDto() {
        String type = ExerciseType.DISTANCE_BASED.name();
        int cutLength = 8;
        return ExerciseResDto.builder()
            .id(this.getId())
            .type(type.substring(0, type.length() - cutLength))
            .name(this.getName())
            .description(this.getDescription())
            .category(this.getCategory())
            .calorie(this.getCalorie())
            .distance(this.getDistance())
            .build();
    }
}
