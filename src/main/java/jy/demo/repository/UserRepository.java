package jy.demo.repository;

import java.util.Optional;
import jy.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findBySocialProviderKey(String socialProviderKey);
}
