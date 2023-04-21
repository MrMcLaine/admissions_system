package ua.admissions.system;

import ua.admissions.system.entity.person.Applicant;

import java.time.LocalDate;

import static ua.admissions.system.ExamScoreTestData.EXAM_SCORES;
import static ua.admissions.system.FacultyTestData.CREATED_FACULTY;

public class ApplicantTestData {

    public static final String FIRST_NAME_APPLICANT = "Applicant's Name";
    public static final String LAST_NAME_APPLICANT = "Applicant's surname";
    public static final LocalDate BIRTHDAY_APPLICANT = LocalDate.of(1970, 1, 1);
    public static final String EMAIL_APPLICANT = "applicant@gmail.com";
    public static final String PASSWORD_APPLICANT = "someEasyPassword";

    public static final Applicant CREATED_APPLICANT = new Applicant(FIRST_NAME_APPLICANT, LAST_NAME_APPLICANT,
            BIRTHDAY_APPLICANT, EMAIL_APPLICANT, PASSWORD_APPLICANT, EXAM_SCORES, CREATED_FACULTY, false);

}

