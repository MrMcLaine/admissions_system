package ua.admissions.system.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ua.admissions.system.ApplicantTestData.*;
import static ua.admissions.system.ExamScoreTestData.EXAM_SCORES;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.person.Applicant;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicantRepositoryTest {

    @Autowired
    private ApplicantRepository repository;

    @Test
    void createApplicant() {
        Applicant savedApplicant = repository.save(CREATED_APPLICANT);

        Assertions.assertNotNull(savedApplicant);
        Assertions.assertNotNull(savedApplicant.getId());
        Assertions.assertEquals(FIRST_NAME_APPLICANT, savedApplicant.getFirstName());
        Assertions.assertEquals(LAST_NAME_APPLICANT, savedApplicant.getLastName());
        Assertions.assertEquals(BIRTHDAY_APPLICANT, savedApplicant.getBirthday());
        Assertions.assertEquals(EMAIL_APPLICANT, savedApplicant.getEmail());
        Assertions.assertEquals(PASSWORD_APPLICANT, savedApplicant.getPassword());
        Assertions.assertEquals(EXAM_SCORES, savedApplicant.getScores());
        Assertions.assertEquals(CREATED_FACULTY, savedApplicant.getFaculty());
        Assertions.assertFalse(savedApplicant.isEnabled());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByEmail() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByIdNotFound() {
    }

    @Test
    void createWithIllegalArg() {
    }
}