package jy.demo.repository;

import jy.demo.model.DefaultRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultRoutineRepository extends JpaRepository<DefaultRoutine, Long> {

}
