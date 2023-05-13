package ua.admissions.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ExamScoreRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ua.admissions.system.service.ApplicantServiceTest.createApplicant;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExamScoreServiceTests {

    @Autowired
    private ExamScoreRepository examScoreRepository;

    @Autowired
    private ApplicantService applicantService;

    @Test
    public void testSaveExamScoresForApplicant() {
        Applicant applicant = createApplicant("test@example.com", "password", "password",
                "Test", "Applicant", true);
        applicant = applicantService.save(applicant);

        List<ExamScore> examScores = Arrays.asList(
                new ExamScore(SubjectName.MATHEMATICS, 90.0, applicant),
                new ExamScore(SubjectName.ENGLISH, 85.5, applicant),
                new ExamScore(SubjectName.SCIENCE, 92.0, applicant)
        );

        examScoreRepository.saveAll(examScores);
        examScoreRepository.flush();

        List<ExamScore> savedExamScores = examScoreRepository.findAllByApplicantId(applicant.getId());
        assertEquals(savedExamScores.size(), examScores.size());
        assertEquals(savedExamScores, examScores);
    }

    @Test
    public void testFindAllByApplicantId() {
        Applicant applicant = createApplicant("test2@example.com", "password", "password",
                "Test", "Applicant", true);
        applicant = applicantService.save(applicant);

        ExamScore examScore1 = new ExamScore(SubjectName.MATHEMATICS, 90.0, applicant);
        ExamScore examScore2 = new ExamScore(SubjectName.ENGLISH, 85.5, applicant);
        examScoreRepository.saveAll(Arrays.asList(examScore1, examScore2));

        List<ExamScore> savedExamScores = examScoreRepository.findAllByApplicantId(applicant.getId());

        assertEquals(savedExamScores.size(), 2);
        assertEquals(savedExamScores, Arrays.asList(examScore1, examScore2));
    }

    @Test
    public void testFindAll() {
        examScoreRepository.deleteAll();
        Applicant applicant = createApplicant("test4@example.com", "password", "password",
                "Test", "Applicant", true);
        applicant = applicantService.save(applicant);

        ExamScore examScore1 = new ExamScore(SubjectName.MATHEMATICS, 90.0, applicant);
        ExamScore examScore2 = new ExamScore(SubjectName.ENGLISH, 85.5, applicant);
        examScoreRepository.saveAll(Arrays.asList(examScore1, examScore2));

        List<ExamScore> savedExamScores = examScoreRepository.findAll();

        assertEquals(savedExamScores.size(), 2);
        assertEquals(savedExamScores, Arrays.asList(examScore1, examScore2));
    }
}