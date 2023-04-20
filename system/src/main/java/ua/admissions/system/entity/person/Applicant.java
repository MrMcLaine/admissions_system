package ua.admissions.system.entity.person;

import lombok.*;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.util.ExamScoreListValidation;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applicant")
@DiscriminatorValue("APPLICANT")
public class Applicant extends User {
    @ExamScoreListValidation
    @Enumerated(EnumType.STRING)
    @OneToMany
    @ToString.Exclude
    private List<ExamScore> scores;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id", nullable = false)
    @ToString.Exclude
    private Faculty faculty;
    @Column
    private boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applicant applicant)) return false;
        if (!super.equals(o)) return false;

        if (isEnabled() != applicant.isEnabled()) return false;
        if (getScores() != null ? !getScores().equals(applicant.getScores()) : applicant.getScores() != null)
            return false;
        return getFaculty() != null ? getFaculty().equals(applicant.getFaculty()) : applicant.getFaculty() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getScores() != null ? getScores().hashCode() : 0);
        result = 31 * result + (getFaculty() != null ? getFaculty().hashCode() : 0);
        result = 31 * result + (isEnabled() ? 1 : 0);
        return result;
    }
}
