package jy.demo.repository;

import jy.demo.model.DistanceBasedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceBasedExerciseRepository extends JpaRepository<DistanceBasedExercise, Long> {

}
