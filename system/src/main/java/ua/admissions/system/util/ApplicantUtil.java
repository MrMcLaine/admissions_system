package ua.admissions.system.util;

import ua.admissions.system.dto.ApplicantDto;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicantUtil {
    public static boolean checkExamScores(List<ExamScore> examScores) {
        List<SubjectName> subjectNames = Arrays.asList(SubjectName.values());
        List<SubjectName> subjectNamesByApplicant = new ArrayList<>();

        for (ExamScore eS : examScores) {
            if(eS.getScore() != null) {
                subjectNamesByApplicant.add(eS.getName());
            }
        }

        return !subjectNames.contains(subjectNamesByApplicant);
    }

    public static List<ApplicantDto> getApplicantDtos(List<Applicant> applicants) {
        List<ApplicantDto> applicantDtos = new ArrayList<>();
        for (Applicant a : applicants) {
            applicantDtos.add(new ApplicantDto(a.getFirstName(), a.getLastName(), a.getFaculty().getName(),
                    a.isEnabled()));
        }
        return applicantDtos;
    }

    public static List<Applicant> addedScores(List<Applicant> applicants, List<ExamScore> scores) {
        for(Applicant applicant : applicants) {
            Long applicantId = applicant.getId();
            applicant.setScores(scores.stream()
                            .filter(examScore -> examScore.getApplicant().getId().equals(applicantId)).toList());
        }
        return applicants;
    }
}
