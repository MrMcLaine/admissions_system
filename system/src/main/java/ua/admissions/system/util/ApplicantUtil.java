package ua.admissions.system.util;

import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;

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
}
