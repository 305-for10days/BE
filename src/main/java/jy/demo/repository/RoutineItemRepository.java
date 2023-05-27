package jy.demo.repository;

import jy.demo.model.RoutineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineItemRepository extends JpaRepository<RoutineItem, Long> {

}
