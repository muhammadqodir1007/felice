package uz.fazo.felice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fazo.felice.entity.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {
}
