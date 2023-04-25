package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.admissions.system.entity.person.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
