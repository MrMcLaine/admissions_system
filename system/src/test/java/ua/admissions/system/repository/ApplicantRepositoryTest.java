package ua.admissions.system.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.admissions.system.ApplicantTestData.*;
import static ua.admissions.system.ExamScoreTestData.EXAM_SCORES;
import static ua.admissions.system.ExamScoreTestData.MISSING_EXAM_SCORES;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY_COMPUTER_SCIENCE;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY_ENGINEERING;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.person.Applicant;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicantRepositoryTest {
/*
    @Autowired
    private ApplicantRepository repository;
    @Autowired
    private ApplicationForAdmissionRepository admissionRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private ExamScoreRepository examScoreRepository;

    @BeforeEach
    public void initFields() {
        facultyRepository.save(CREATED_FACULTY_COMPUTER_SCIENCE);
        facultyRepository.save(CREATED_FACULTY_ENGINEERING);
        Applicant applicant = repository.save(CREATED_APPLICANT);
        for (ExamScore score : EXAM_SCORES) {
            Applicant applicantCurrent = repository.findById(applicant.getId()).orElseThrow(()
                    -> new EntityNotFoundException("Applicant not found"));
            score.setApplicant(applicantCurrent);
            examScoreRepository.save(score);
        }
    }

    @Test
    void createApplicant() {
        Applicant savedApplicant = repository.save(CREATED_APPLICANT_2);
        checkApplicantFields(savedApplicant, CREATED_APPLICANT_2);
    }

    @Test
    void update() {
        Applicant applicant = repository.save(CREATED_APPLICANT);
        Long id = applicant.getId();
        Applicant updated = getUpdatedApplicant();
        updated.setId(id);
        repository.save(getUpdatedApplicant());
        checkApplicantFields(updated, getUpdatedApplicant());
    }

    @Test
    void delete() {
        Applicant applicant = repository.save(saverCheck(CREATED_APPLICANT));
        Long applicantId = applicant.getId();
        repository.deleteById(applicantId);
        assertFalse(repository.existsById(applicantId));
    }

    @Test
    void findByEmail() {
        Applicant applicant = repository.save(CREATED_APPLICANT);
        String applicantEmail = applicant.getEmail();
        Applicant foundApplicant = repository.findByEmail(applicantEmail);
        checkApplicantFields(foundApplicant, CREATED_APPLICANT);
    }

    @Test
    void findById() {
        Applicant applicant = repository.save(CREATED_APPLICANT);
        Long applicantId = applicant.getId();
        Applicant foundApplicant = repository.getReferenceById(applicantId);
        checkApplicantFields(foundApplicant, CREATED_APPLICANT);
    }

    @Test
    void findAll() {
        repository.save(CREATED_APPLICANT);
        repository.save(CREATED_APPLICANT_2);
        repository.save(CREATED_APPLICANT_3);

        List<Applicant> applicants = repository.findAll();
        checkApplicantLists(applicants, APPLICANT_LIST);
    }

    @Test
    void findByIdNotFound() {
        assertFalse(repository.existsById(Long.MAX_VALUE));
    }

    @Test
    void createWithIllegalArg() {
        CREATED_APPLICANT.setScores(MISSING_EXAM_SCORES);
        assertThrows(ConstraintViolationException.class, () -> repository.save(CREATED_APPLICANT));
    }

    void checkApplicantFields(Applicant a1, Applicant a2) {
        Assertions.assertNotNull(a1);
        Assertions.assertNotNull(a1.getId());
        Assertions.assertEquals(a2.getFirstName(), a1.getFirstName());
        Assertions.assertEquals(a2.getLastName(), a1.getLastName());
        Assertions.assertEquals(a2.getBirthday(), a1.getBirthday());
        Assertions.assertEquals(a2.getEmail(), a1.getEmail());
        Assertions.assertEquals(a2.getPassword(), a1.getPassword());
        Assertions.assertEquals(a2.getScores(), a1.getScores());
        Assertions.assertEquals(a2.getFaculty(), a1.getFaculty());
        Assertions.assertFalse(a2.isEnabled());
    }

    void checkApplicantLists(List<Applicant> al1, List<Applicant> al2) {
        Assertions.assertEquals(al1.size(), al2.size());
        for (int i = 0; i < al1.size(); i++) {
            checkApplicantFields(al1.get(i), al2.get(i));
        }
    }

    private Applicant saverCheck(Applicant applicant){
        if(repository.findByEmail(applicant.getEmail()) == null) {
            return repository.save(applicant);
        }
        return repository.findByEmail(applicant.getEmail());
    }*/
}