package ua.admissions.system.entity.constant;

public enum SubjectName {
    MATHEMATICS(0),
    ENGLISH(1),
    SCIENCE(2),
    HISTORY_OF_UKRAINE(3),
    GEOGRAPHY(4),
    PHYSICS(5),
    CHEMISTRY(6),
    BIOLOGY(7),
    COMPUTER_SCIENCE(8),
    PSYCHOLOGY(9);

    private final int index;

    private SubjectName(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
