package ua.admissions.system.entity;

import lombok.*;
import org.hibernate.Hibernate;
import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exam_score")
public class ExamScore extends AbstractBaseEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private SubjectName name;
    @Column
    private Double score;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applicant_id", nullable = false)
    @ToString.Exclude
    private Applicant applicant;

    public ExamScore(SubjectName name) {
        this.name = name;
    }

    public ExamScore(SubjectName name, Double score) {
        this.name = name;
        this.score = score;
    }

    public SubjectName getName() {
        return name;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExamScore examScore = (ExamScore) o;
        return id != null && Objects.equals(id, examScore.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
