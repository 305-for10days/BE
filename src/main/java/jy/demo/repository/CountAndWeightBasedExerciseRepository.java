package jy.demo.repository;

import jy.demo.model.CountAndWeightBasedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountAndWeightBasedExerciseRepository extends
    JpaRepository<CountAndWeightBasedExercise, Long> {

}
