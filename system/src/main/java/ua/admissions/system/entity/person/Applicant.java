package ua.admissions.system.entity.person;

import lombok.*;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.Faculty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
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
    @Lob
    private byte[] image;
    @Lob
    private String encodedImage;
    /*@ExamScoreListValidation*/
    @OneToMany
    @ToString.Exclude
    private List<ExamScore> scores;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id", nullable = true)
    @ToString.Exclude
    private Faculty faculty = null;
    @Column
    private boolean enabled;

    public Applicant(Applicant applicant) {
        super(applicant.getFirstName(), applicant.getLastName(), applicant.getBirthday(), applicant.getEmail(),
                applicant.getPassword());
        this.scores = applicant.getScores();
        this.faculty = applicant.getFaculty();
        this.enabled = applicant.isEnabled();
    }

    public Applicant(@NotBlank String firstName, @NotBlank String lastName, LocalDate birthday, @NotBlank String email,
                     @NotBlank String password, List<ExamScore> scores, Faculty faculty, boolean enabled) {
        super(firstName, lastName, birthday, email, password);
        this.scores = scores;
        this.faculty = faculty;
        this.enabled = enabled;
    }

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
