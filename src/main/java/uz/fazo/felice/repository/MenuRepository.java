package uz.fazo.felice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.fazo.felice.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
