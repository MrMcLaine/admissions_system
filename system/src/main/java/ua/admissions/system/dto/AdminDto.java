package ua.admissions.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.admissions.system.entity.constant.SubjectName;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {
    private List<SubjectName> facultyNames;
    private String selectedFacultyName;
}
