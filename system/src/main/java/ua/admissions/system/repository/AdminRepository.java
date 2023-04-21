package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.person.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
