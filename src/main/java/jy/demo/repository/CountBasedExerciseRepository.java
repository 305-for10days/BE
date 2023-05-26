package jy.demo.repository;

import jy.demo.model.CountBasedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountBasedExerciseRepository extends JpaRepository<CountBasedExercise, Long> {

}
