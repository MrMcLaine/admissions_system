package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.person.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
