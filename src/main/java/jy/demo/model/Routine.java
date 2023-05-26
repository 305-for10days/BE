package jy.demo.model;

import java.util.List;

public interface Routine {

    public Long getId();

    public List<RoutineItem> getRoutineItems();

    public ExerciseGoal getExerciseGoal();
}
