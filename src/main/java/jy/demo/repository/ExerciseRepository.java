package jy.demo.repository;

import jy.demo.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

//    List<Exercise> findAllByType(String type);
}
