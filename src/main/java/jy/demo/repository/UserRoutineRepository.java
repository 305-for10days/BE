package jy.demo.repository;

import java.util.List;
import java.util.Optional;
import jy.demo.model.User;
import jy.demo.model.UserRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoutineRepository extends JpaRepository<UserRoutine, Long> {

    @Query("SELECT ur1 FROM UserRoutine ur1 " +
        "WHERE ur1.createdAt IN (" +
        "  SELECT MAX(ur2.createdAt) " +
        "  FROM UserRoutine ur2 " +
        "  WHERE ur2.user.id = :userId " +
        "  AND ur2.exerciseGoal.id IN :exerciseGoalIds " +
        "  GROUP BY ur2.user.id, ur2.exerciseGoal.id" +
        ") " +
        "AND ur1.user.id = :userId " +
        "AND ur1.exerciseGoal.id IN :exerciseGoalIds")
    List<UserRoutine> findLatestUserRoutines(@Param("userId") Long userId,
        @Param("exerciseGoalIds") List<Long> exerciseGoalIds);


    Optional<UserRoutine> findByIdAndUser(Long id, User user);
}
