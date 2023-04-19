package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.entity.person.Admin;

import java.util.List;

public interface ApplicationForAdmissionRepository extends JpaRepository<ApplicationForAdmission, Long> {
    List<ApplicationForAdmission> findByAdmin(Admin admin);
}
