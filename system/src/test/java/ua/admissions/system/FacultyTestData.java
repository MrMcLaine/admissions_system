package ua.admissions.system;

import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;

public class FacultyTestData {
    public static final Faculty CREATED_FACULTY_COMPUTER_SCIENCE =
            new Faculty(FacultyName.COMPUTER_SCIENCE, 121, null);
    public static final Faculty CREATED_FACULTY_ENGINEERING =
            new Faculty(FacultyName.ENGINEERING, 84 , null);
}
