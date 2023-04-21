package ua.admissions.system;

import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.SubjectName;

import java.util.List;

public class ExamScoreTestData {
    public static final ExamScore MATHEMATICS_SCORE = new ExamScore(SubjectName.MATHEMATICS, 52.0, null);
    public static final ExamScore ENGLISH_SCORE = new ExamScore(SubjectName.ENGLISH, 33.5, null);
    public static final ExamScore SCIENCE_SCORE = new ExamScore(SubjectName.SCIENCE, 63.0, null);
    public static final ExamScore HISTORY_OF_UKRAINE_SCORE = new ExamScore(SubjectName.HISTORY_OF_UKRAINE,
            40.0, null);
    public static final ExamScore GEOGRAPHY_SCORE = new ExamScore(SubjectName.GEOGRAPHY, 12.0, null);
    public static final ExamScore PHYSICS_SCORE = new ExamScore(SubjectName.PHYSICS, 57.0, null);
    public static final ExamScore CHEMISTRY_SCORE = new ExamScore(SubjectName.CHEMISTRY, 11.5, null);
    public static final ExamScore BIOLOGY_SCORE = new ExamScore(SubjectName.BIOLOGY, 32.0, null);
    public static final ExamScore COMPUTER_SCIENCE_SCORE = new ExamScore(SubjectName.COMPUTER_SCIENCE, 62.0, null);
    public static final ExamScore PSYCHOLOGY_SCORE = new ExamScore(SubjectName.PSYCHOLOGY, 50.0, null);
    public static final List<ExamScore> EXAM_SCORES = List.of(MATHEMATICS_SCORE, ENGLISH_SCORE, SCIENCE_SCORE,
            HISTORY_OF_UKRAINE_SCORE, GEOGRAPHY_SCORE, PHYSICS_SCORE, CHEMISTRY_SCORE, BIOLOGY_SCORE,
            COMPUTER_SCIENCE_SCORE, PSYCHOLOGY_SCORE);
}
