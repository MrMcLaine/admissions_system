package ua.admissions.system.entity.constant;

import java.util.List;

public enum FacultyName {
    ARCHITECTURE(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.MATHEMATICS, SubjectName.PHYSICS,
            SubjectName.COMPUTER_SCIENCE)),
    ARTS(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.SCIENCE, SubjectName.PSYCHOLOGY)),
    BUSINESS(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.MATHEMATICS, SubjectName.ENGLISH)),
    COMPUTER_SCIENCE(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.COMPUTER_SCIENCE, SubjectName.MATHEMATICS)),
    ENGINEERING(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.MATHEMATICS, SubjectName.PHYSICS)),
    HEALTH_SCIENCES(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.BIOLOGY, SubjectName.CHEMISTRY)),
    LAW(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.MATHEMATICS, SubjectName.ENGLISH)),
    MEDICINE(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.BIOLOGY, SubjectName.CHEMISTRY, SubjectName.PHYSICS)),
    SOCIAL_SCIENCES(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.PSYCHOLOGY, SubjectName.GEOGRAPHY)),
    VETERINARY_MEDICINE(List.of(SubjectName.HISTORY_OF_UKRAINE, SubjectName.BIOLOGY, SubjectName.CHEMISTRY,
            SubjectName.PHYSICS));

    private final List<SubjectName> subjects;

    FacultyName(List<SubjectName> subjects) {
        this.subjects = subjects;
    }

    public List<SubjectName> getSubjects() {
        return subjects;
    }
}
