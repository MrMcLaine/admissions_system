package ua.admissions.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.repository.ApplicantRepository;
import ua.admissions.system.repository.ExamScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamScoreService {

    private final Logger LOGGER = LoggerFactory.getLogger(ExamScoreService.class);

    @Autowired
    private ExamScoreRepository examScoreRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    public void saveExamScoresForApplicant(Applicant applicant, List<ExamScore> examScores) {
        LOGGER.info("Saved {} exam scores for applicant with ID {}", examScores.size(), applicant.getId());
        List<ExamScore> resultList = new ArrayList<>();
        for (ExamScore es : examScores) {
            es.setApplicant(applicant);
            resultList.add(es);
        }
        examScoreRepository.saveAll(resultList);
    }

    public List<ExamScore> findAllByApplicantId(Long applicantId) {
        LOGGER.info("Find all exam scores for applicant with ID {}", applicantId);
        return examScoreRepository.findAllByApplicantId(applicantId);
    }

    public List<ExamScore> findAll() {
        LOGGER.info("Find all exam scores");
        return examScoreRepository.findAll();
    }
}
