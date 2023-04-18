package ua.admissions.system.util;

import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExamScoreListValidator implements ConstraintValidator<ExamScoreListValidation, List<ExamScore>> {
    @Override
    public void initialize(ExamScoreListValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<ExamScore> examScores, ConstraintValidatorContext context) {
        if (examScores == null || examScores.isEmpty()) {
            return false;
        }

        Set<SubjectName> subjectNames = new HashSet<>();
        for (ExamScore examScore : examScores) {
            subjectNames.add(examScore.getName());
        }

        Set<SubjectName> missingSubjectNames = new HashSet<>(Arrays.asList(SubjectName.values()));
        missingSubjectNames.removeAll(subjectNames);

        return missingSubjectNames.isEmpty();
    }
}
