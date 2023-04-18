package ua.admissions.system.entity;

import ua.admissions.system.entity.person.Admin;
import ua.admissions.system.entity.person.Applicant;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationForAdmission extends AbstractBaseEntity{
    private Applicant applicant;
    private Admin admin;
    private Boolean isProcessed;
}
