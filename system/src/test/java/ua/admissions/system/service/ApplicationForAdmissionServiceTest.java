package ua.admissions.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicationForAdmissionRepository;
import ua.admissions.system.repository.FacultyRepository;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static ua.admissions.system.service.ApplicantServiceTest.createApplicant;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApplicationForAdmissionServiceTest {
    @Autowired
    ApplicationForAdmissionService applicationForAdmissionService;

    @Autowired
    ApplicantService applicantService;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    ApplicationForAdmissionRepository applicationForAdmissionRepository;

    @Test
    public void saveApplicationForAdmissionTest() {

        Applicant applicant = createApplicant("test2@example.com", "password", "password",
                "Test", "Applicant", true);
        applicant = applicantService.save(applicant);

        Faculty faculty = new Faculty();
        faculty.setName(FacultyName.COMPUTER_SCIENCE);
        faculty.setFixedAdmissionPlan(10);
        faculty.setApplicants(new ArrayList<>());
        facultyRepository.save(faculty);


        ApplicationForAdmission newApplication = new ApplicationForAdmission();
        newApplication.setApplicant(applicant);
        newApplication.setFaculty(faculty);
        newApplication.setIsProcessed(false);
        applicationForAdmissionService.save(newApplication);

        ApplicationForAdmission savedApplication = applicationForAdmissionRepository
                .findById(newApplication.getId()).orElse(null);
        assertEquals(newApplication, savedApplication);
    }
}