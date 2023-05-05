package ua.admissions.system.util;

import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;

import java.util.*;

public class AdminUtil {

    public static Map<Long, Double> additionExamScoresForSomeSubjects(List<SubjectName> subjectNames,
                                                                      List<Applicant> applicants) {
        Map<Long, Double> result = new HashMap<>();

        for (Applicant applicant : applicants) {
            double sum = 0.0;
            for (ExamScore score : applicant.getScores()) {
                if (subjectNames.contains(score.getName())) {
                    sum += score.getScore();
                }
            }
            result.put(applicant.getId(), sum);
        }
        return result;
    }

    public static List<Applicant> calculateEnrolled(Map<Long, Double> additionalExamScoresMap,
                                                    List<Applicant> applicants, Integer fixedAdmissionPlan) {
        List<Applicant> enrolledApplicants = new ArrayList<>();

        // Sort additionalExamScoresMap by value
        List<Map.Entry<Long, Double>> sortedEntries = new ArrayList<>(additionalExamScoresMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Take the top fixedAdmissionPlan number of applicants
        List<Long> topApplicantIds = sortedEntries.stream()
                .map(Map.Entry::getKey)
                .limit(fixedAdmissionPlan).toList();

        // Find the applicants with those IDs from the sorted and limited list
        for (Long id : topApplicantIds) {
            Optional<Applicant> optionalApplicant = applicants.stream()
                    .filter(applicant -> applicant.getId().equals(id))
                    .findFirst();
            optionalApplicant.ifPresent(enrolledApplicants::add);
        }

        return enrolledApplicants;
    }

    public static List<Applicant> changeEnabledForList(List<Applicant> applicantsFromDB,
                                                       List<Applicant> enrolledApplicants) {
        for (Applicant applicant : applicantsFromDB) {
            if (enrolledApplicants.contains(applicant)) {
                applicant.setEnabled(true);
            }
        }
        return applicantsFromDB;
    }
}
