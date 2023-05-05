package ua.admissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.admissions.system.dto.AdminDto;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.Faculty;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.service.ApplicantService;
import ua.admissions.system.service.ExamScoreService;
import ua.admissions.system.service.FacultyService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

import static ua.admissions.system.util.ApplicantUtil.addedScores;

@Controller
public class AdminController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ExamScoreService examScoreService;

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public ModelAndView showAdminPage(Model model) {

        AdminDto adminDto = new AdminDto();

        List<FacultyName> faculties = Arrays.asList(FacultyName.values());
        model.addAttribute("faculties", faculties);
        model.addAttribute("adminDto", adminDto);

        return new ModelAndView("adminPage", "model", model);
    }

    @PostMapping("/selectFaculty")
    public String showFacultyApplicants(@Valid @ModelAttribute("adminDto") AdminDto adminDto, Model model) {
        String facultyName = adminDto.getSelectedFacultyName();
        Faculty faculty = facultyService.findByStringName(facultyName);
        List<Applicant> applicants = applicantService.findAllByFaculty(faculty);
        List<ExamScore> scores = examScoreService.findAll();
        model.addAttribute("applicants", addedScores(applicants, scores));
        return "adminPage";
    }
}
