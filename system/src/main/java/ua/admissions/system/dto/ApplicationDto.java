package ua.admissions.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationDto {
    private Long applicantId;
    private String facultyName;
    private Boolean isProcessed;
}
