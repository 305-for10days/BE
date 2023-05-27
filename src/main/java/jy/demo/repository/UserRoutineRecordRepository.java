package jy.demo.repository;

import java.util.Optional;
import jy.demo.model.User;
import jy.demo.model.UserRoutineRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoutineRecordRepository extends JpaRepository<UserRoutineRecord, Long> {

    Optional<UserRoutineRecord> findByIdAndUser(Long id, User user);

    Page<UserRoutineRecord> findAllByUser(User user, Pageable pageable);
}
