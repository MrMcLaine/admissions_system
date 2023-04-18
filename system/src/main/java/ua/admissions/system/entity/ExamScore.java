package ua.admissions.system.entity;

import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ExamScore extends AbstractBaseEntity {
    private SubjectName name;
    private Double score;
    private Applicant applicant;
}
