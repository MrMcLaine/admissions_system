package ua.admissions.system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.FacultyName;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private MultipartFile image;
    private String encodedImage;
    private List<ExamScore> scores;
    private FacultyName facultyName;
    private boolean enabled;

    public ApplicantDto(Long id, String firstName, String lastName, List<ExamScore> scores, String encodedImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scores = scores;
        this.encodedImage = encodedImage;
    }

    @Autowired
    public ApplicantDto(List<ExamScore> scores) {
        this.scores = scores;
    }

    public ApplicantDto(String firstName, String lastName, FacultyName facultyName, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyName = facultyName;
        this.enabled = enabled;
    }
}
