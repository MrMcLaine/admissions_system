package ua.admissions.system.entity.person;

import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.Role;
import lombok.*;
import ua.admissions.system.util.ExamScoreListValidation;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Applicant extends User {
    private final Role role = Role.APPLICANT;
    @ExamScoreListValidation
    private List<ExamScore> scores;
    private Faculty faculty;
    private boolean enabled;
}
