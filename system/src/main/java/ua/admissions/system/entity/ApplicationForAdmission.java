package ua.admissions.system.entity;

import lombok.*;
import org.hibernate.Hibernate;
import ua.admissions.system.entity.person.Applicant;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_for_admission")
public class ApplicationForAdmission extends AbstractBaseEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id", nullable = false, unique = true)
    @ToString.Exclude
    private Applicant applicant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    @ToString.Exclude
    private Faculty faculty;
    @Column
    private Boolean isProcessed;

    public ApplicationForAdmission(ApplicationForAdmission application) {
        this.applicant = application.getApplicant();
        this.faculty = application.getFaculty();
        this.isProcessed = application.getIsProcessed();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApplicationForAdmission that = (ApplicationForAdmission) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
