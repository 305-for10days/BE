package jy.demo.repository;

import jy.demo.model.TimeAndCountBasedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeAndCountBasedExerciseRepository extends JpaRepository<TimeAndCountBasedExercise, Long> {

}
