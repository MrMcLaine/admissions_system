package ua.admissions.system.service;

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

    @Autowired
    private ExamScoreRepository examScoreRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    public void saveExamScoresForApplicant(Applicant applicant, List<ExamScore> examScores){
        List<ExamScore> resultList = new ArrayList<>();
        if(applicant == null) {
            throw new NullPointerException("user is null");
        }
        for(ExamScore es : examScores) {
            es.setApplicant(applicant);
            resultList.add(es);
        }
        examScoreRepository.saveAll(resultList);
    }
}
