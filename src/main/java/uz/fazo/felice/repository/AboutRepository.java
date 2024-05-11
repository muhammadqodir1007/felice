package uz.fazo.felice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fazo.felice.entity.About;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}
