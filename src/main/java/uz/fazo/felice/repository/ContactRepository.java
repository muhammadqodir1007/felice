package uz.fazo.felice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fazo.felice.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
