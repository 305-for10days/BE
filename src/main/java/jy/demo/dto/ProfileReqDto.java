package jy.demo.dto;


import javax.validation.constraints.NotNull;
import jy.demo.common.Gender;
import jy.demo.model.Profile;
import jy.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileReqDto {

    // TODO: 운동목적 연관관계 필드 추가
    @NotNull(message = ValidationMsg.genderMsg)
    private Gender gender;

    @NotNull(message = ValidationMsg.heightMsg)
    private Integer height;

    @NotNull(message = ValidationMsg.weightMsg)
    private Integer weight;

    private Double bmi;

    public Profile toEntity(Long userId) {
        return Profile.builder()
            .user(new User(userId))
            .gender(gender)
            .height(height)
            .weight(weight)
            .bmi(bmi)
            .build();
    }

}
