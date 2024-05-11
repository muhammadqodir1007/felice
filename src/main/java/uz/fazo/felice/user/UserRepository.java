package uz.fazo.felice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

boolean existsByUsername(String username);
Optional<User> findByUsername(String username);



}
