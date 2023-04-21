package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.person.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Applicant findByEmail(String email);
}
