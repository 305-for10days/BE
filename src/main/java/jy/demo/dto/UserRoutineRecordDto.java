package jy.demo.dto;

import java.time.LocalDateTime;
import jy.demo.model.UserRoutine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoutineRecordDto {

    private Long routineId;
    private Long emojiId;
    private LocalDateTime date;
    private int calories;

    public UserRoutineRecordDto(UserRoutine routine) {
        this.routineId = routine.getId();
        this.emojiId = routine.getEmoji();
        this.date = routine.getCreatedAt();
        this.calories = routine.getCalorie();
    }
}
