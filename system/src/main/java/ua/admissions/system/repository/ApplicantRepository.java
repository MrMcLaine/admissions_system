package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.person.Applicant;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findByEmail(String email);

    List<Applicant> findAllByFaculty(Faculty faculty);
}
