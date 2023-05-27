package jy.demo.dto;

import java.time.LocalDateTime;
import jy.demo.model.UserRoutine;
import jy.demo.model.UserRoutineRecord;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoutineRecordDto {

    private Long routineId;
    private Long emojiId;
    private LocalDateTime date;
    private String goal;
    private int calories;

    public UserRoutineRecordDto(UserRoutineRecord routineRecord) {
        UserRoutine routine = routineRecord.getRoutine();
        this.routineId = routine.getId();
        this.goal = routine.getExerciseGoal().getGoal();

        this.emojiId = routineRecord.getEmoji();
        this.date = routineRecord.getCreatedAt();
        this.calories = routineRecord.getTotalCalorie();
    }
}
