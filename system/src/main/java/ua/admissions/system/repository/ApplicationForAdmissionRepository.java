package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.ApplicationForAdmission;

public interface ApplicationForAdmissionRepository extends JpaRepository<ApplicationForAdmission, Long> {
}
