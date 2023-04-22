package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.entity.person.Applicant;

import java.util.List;

public interface ApplicationForAdmissionRepository extends JpaRepository<ApplicationForAdmission, Long> {
    ApplicationForAdmission findByApplicant(Applicant applicant);
    @Query("SELECT afa FROM ApplicationForAdmission afa WHERE afa.isProcessed=true")
    List<ApplicationForAdmission> findAllEnabled();
}
