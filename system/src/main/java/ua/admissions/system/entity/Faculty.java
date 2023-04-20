package ua.admissions.system.entity;

import lombok.*;
import org.hibernate.Hibernate;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.entity.person.Applicant;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty")
public class Faculty extends AbstractBaseEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private FacultyName name;
    @Column(name = "fixed_admission_plan")
    private Integer fixedAdmissionPlan;
    @OneToMany
    @ToString.Exclude
    private List<Applicant> applicants;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Faculty faculty = (Faculty) o;
        return id != null && Objects.equals(id, faculty.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
