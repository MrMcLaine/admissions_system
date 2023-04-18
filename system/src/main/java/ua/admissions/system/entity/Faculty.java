package ua.admissions.system.entity;

import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.entity.person.Applicant;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends AbstractBaseEntity {
    private FacultyName name;
    private Integer fixedAdmissionPlan;
    private List<Applicant> applicants;
}
