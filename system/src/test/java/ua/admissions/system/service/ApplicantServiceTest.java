package ua.admissions.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicantRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApplicantServiceTest {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Test
    public void saveApplicant() {
        Applicant applicant = createApplicant("test@example.com", "password", "password",
                "Test", "Applicant", true);

        applicantService.save(applicant);

        Applicant savedApplicant = applicantRepository.findByEmail("test@example.com").orElse(null);
        assertNotNull(savedApplicant);
        assertEquals("Test", savedApplicant.getFirstName());
        assertEquals("Applicant", savedApplicant.getLastName());

    }

    @Test
    public void findByEmail() {
        Applicant applicant = createApplicant("test2@example.com", "password", "password",
                "Test", "Applicant", true);

        applicantRepository.save(applicant);

        Applicant foundApplicant = applicantService.findByEmail("test2@example.com");
        assertNotNull(foundApplicant);
        assertEquals("Test", foundApplicant.getFirstName());
        assertEquals("Applicant", foundApplicant.getLastName());
    }

    public static Applicant createApplicant(String email, String password, String passwordConfirm, String firstName,
                                            String lastName, boolean isEnabled) {
        Applicant applicant = new Applicant();
        applicant.setEmail(email);
        applicant.setPassword(password);
        applicant.setPasswordConfirm(passwordConfirm);
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setEnabled(isEnabled);

        return applicant;
    }
}