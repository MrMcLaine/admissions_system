package ua.admissions.system;

import ua.admissions.system.entity.person.Applicant;

import java.time.LocalDate;
import java.util.List;

import static ua.admissions.system.ExamScoreTestData.EXAM_SCORES;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY_COMPUTER_SCIENCE;

public class ApplicantTestData {

    public static final Applicant CREATED_APPLICANT = new Applicant("Applicant's Name",
            "Applicant's surname", LocalDate.of(1970, 1, 1), "applicant@gmail.com",
            "someEasyPassword", EXAM_SCORES, CREATED_FACULTY_COMPUTER_SCIENCE, false);

    public static final Applicant CREATED_APPLICANT_2 = new Applicant("Applicant's Name 2",
            "Applicant's surname 2", LocalDate.of(1970, 1, 1), "applicant2@gmail.com",
            "someEasyPassword2", EXAM_SCORES, CREATED_FACULTY_COMPUTER_SCIENCE, false);

    public static final Applicant CREATED_APPLICANT_3 = new Applicant("Applicant's Name 3",
            "Applicant's surname 3", LocalDate.of(1970, 1, 1), "applicant3@gmail.com",
            "someEasyPassword3", EXAM_SCORES, CREATED_FACULTY_COMPUTER_SCIENCE, false);

    public static final List<Applicant> APPLICANT_LIST = List.of(CREATED_APPLICANT, CREATED_APPLICANT_2, CREATED_APPLICANT_3);

    public static Applicant getUpdatedApplicant() {
        Applicant updatedApplicant = new Applicant(CREATED_APPLICANT);
        updatedApplicant.setLastName("Applicant's updated surname");
        updatedApplicant.setPassword("updatedSomeEasyPassword");
        return updatedApplicant;
    }
}

