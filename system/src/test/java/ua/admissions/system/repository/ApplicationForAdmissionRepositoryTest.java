package ua.admissions.system.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.person.Applicant;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static ua.admissions.system.ApplicantTestData.*;
import static ua.admissions.system.ApplicationForAdmissionTestData.*;
import static ua.admissions.system.ExamScoreTestData.*;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY_COMPUTER_SCIENCE;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY_ENGINEERING;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicationForAdmissionRepositoryTest {

    @Autowired
    ApplicationForAdmissionRepository repository;
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    ExamScoreRepository examScoreRepository;

    @BeforeEach
    public void initFields() {
        Applicant applicant = applicantRepository.save(CREATED_APPLICANT);
        applicantRepository.save(CREATED_APPLICANT_2);
        applicantRepository.save(CREATED_APPLICANT_3);
        facultyRepository.save(CREATED_FACULTY_COMPUTER_SCIENCE);
        facultyRepository.save(CREATED_FACULTY_ENGINEERING);
        for (ExamScore score : EXAM_SCORES) {
            Applicant applicantCurrent = applicantRepository.findById(applicant.getId()).orElseThrow(()
                    -> new EntityNotFoundException("Applicant not found"));
            score.setApplicant(applicantCurrent);
            examScoreRepository.save(score);
        }
    }

    @Test
    void create() {
        ApplicationForAdmission application = repository.save(saverCheck(CREATED_APPLICATION));
        checkApplicationFields(application, CREATED_APPLICATION);
    }

    @Test
    void update() {
        ApplicationForAdmission application = repository.save(saverCheck(CREATED_APPLICATION));
        Long id = application.getId();
        ApplicationForAdmission updated = getUpdatedApplication();
        updated.setId(id);
        repository.save(saverCheck(getUpdatedApplication()));
        checkApplicationFields(updated, getUpdatedApplication());
    }

    @Test
    void delete() {
        ApplicationForAdmission application = repository.save(saverCheck(CREATED_APPLICATION));
        Long applicationId = application.getId();
        repository.deleteById(applicationId);
        assertFalse(repository.existsById(applicationId));
    }

    @Test
    void findById() {
        ApplicationForAdmission application = repository.save(saverCheck(CREATED_APPLICATION));
        Long applicationId = application.getId();
        ApplicationForAdmission foundApplication = repository.getReferenceById(applicationId);
        checkApplicationFields(foundApplication, CREATED_APPLICATION);
    }

    @Test
    void findByApplicant() {
        ApplicationForAdmission application = repository.save(saverCheck(CREATED_APPLICATION));
        Applicant applicationApplicant = application.getApplicant();
        ApplicationForAdmission foundApplication = repository.findByApplicant(applicationApplicant);
        checkApplicationFields(foundApplication, CREATED_APPLICATION);
    }

    @Test
    void findAll() {
        repository.save(saverCheck(CREATED_APPLICATION));
        repository.save(saverCheck(CREATED_APPLICATION_2));
        repository.save(saverCheck(CREATED_APPLICATION_3));

        List<ApplicationForAdmission> applications = repository.findAll();
        checkApplicationLists(applications, APPLICATION_LIST);
    }

    @Test
    void findAllEnabled() {
        repository.save(saverCheck(CREATED_APPLICATION));
        repository.save(saverCheck(CREATED_APPLICATION_2));
        repository.save(saverCheck(CREATED_APPLICATION_3));

        List<ApplicationForAdmission> applications = repository.findAllEnabled();
        checkApplicationLists(applications, APPLICATION_LIST_TRUE);
    }

    @Test
    void findByIdNotFound() {
        assertFalse(repository.existsById(Long.MAX_VALUE));
    }

/*    @Test
    void createWithIllegalArg() {
        ApplicationForAdmission saved = repository.save(saverCheck(CREATED_APPLICATION));
        ApplicationForAdmission missingApplication = new ApplicationForAdmission();
        missingApplication.setApplicant(saved.getApplicant());
        missingApplication.setFaculty(saved.getFaculty());
        missingApplication.setIsProcessed(saved.getIsProcessed());
        assertThrows(DataIntegrityViolationException.class, () -> {
            repository.save(missingApplication);
        });
    }*/

    void checkApplicationFields(ApplicationForAdmission afa1, ApplicationForAdmission afa2) {
        Assertions.assertNotNull(afa1);
        Assertions.assertNotNull(afa1.getId());
        Assertions.assertEquals(afa2.getApplicant().getEmail(), afa1.getApplicant().getEmail());
        Assertions.assertEquals(afa2.getFaculty(), afa1.getFaculty());
        Assertions.assertEquals(afa2.getIsProcessed(), afa1.getIsProcessed());
    }

    void checkApplicationLists(List<ApplicationForAdmission> afal1, List<ApplicationForAdmission> afal2) {
        Assertions.assertEquals(afal1.size(), afal2.size());
        for (int i = 0; i < afal1.size(); i++) {
            checkApplicationFields(afal1.get(i), afal2.get(i));
        }
    }

    private ApplicationForAdmission saverCheck(ApplicationForAdmission application){
        if(repository.findByApplicant(application.getApplicant()) == null) {
            return repository.save(application);
        }
        return repository.findByApplicant(application.getApplicant());
    }
}