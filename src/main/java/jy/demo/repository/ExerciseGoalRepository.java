package jy.demo.repository;

import java.util.Optional;
import jy.demo.model.ExerciseGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseGoalRepository extends JpaRepository<ExerciseGoal, Long> {

    Optional<ExerciseGoal> findByGoal(String goal);
}
