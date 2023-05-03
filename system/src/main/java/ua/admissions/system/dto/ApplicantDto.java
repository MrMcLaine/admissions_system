package ua.admissions.system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.FacultyName;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ApplicantDto {
    private Long id;
    private List<ExamScore> scores;
    private FacultyName facultyName;

    public ApplicantDto(Long id, List<ExamScore> scores) {
        this.id = id;
        this.scores = scores;
    }

    @Autowired
    public ApplicantDto(List<ExamScore> scores) {
        this.scores = scores;
    }
}
