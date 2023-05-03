package ua.admissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.admissions.system.dto.ApplicationDto;
import ua.admissions.system.entity.ApplicationForAdmission;
import ua.admissions.system.entity.ExamScore;
import ua.admissions.system.entity.constant.FacultyName;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.service.ApplicantService;
import ua.admissions.system.service.ApplicationForAdmissionService;
import ua.admissions.system.service.ExamScoreService;
import ua.admissions.system.service.FacultyService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

import static ua.admissions.system.util.ApplicantUtil.checkExamScores;

@Controller
public class FacultyController {

    @Autowired
    ApplicantService applicantService;
    @Autowired
    ExamScoreService examScoreService;
    @Autowired
    ApplicationForAdmissionService applicationForAdmissionService;
    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/apply-admission", method = RequestMethod.GET)
    public ModelAndView applyAdmission(Model model) {
        List<FacultyName> faculties = Arrays.asList(FacultyName.values());

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Applicant applicant = applicantService.findByEmail(userDetails.getUsername());

        List<ExamScore> examScores = examScoreService.findAllByApplicantId(applicant.getId());

        Boolean examScoresIsValid = checkExamScores(examScores);

        model.addAttribute("faculties", faculties);
        model.addAttribute("examScoresIsValid", examScoresIsValid);
        model.addAttribute("applicationDto", new ApplicationDto());

        return new ModelAndView("applicationForAdmission", "model", model);
    }

    @PostMapping("/sendApplication")
    public ModelAndView submitExamScores(@Valid @ModelAttribute("applicationDto") ApplicationDto applicationDto,
                                         BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/apply-admission");
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Applicant applicant = applicantService.findByEmail(userDetails.getUsername());

        ApplicationForAdmission application = new ApplicationForAdmission();
        application.setApplicant(applicant);
        application.setFaculty(facultyService.findByNameForApplication(applicationDto.getFacultyName()));

        // save the ApplicationForAdmission objects to the database
        applicationForAdmissionService.save(application);

        modelMap.addAttribute("successMessage", "Exam scores saved successfully");
        return new ModelAndView("redirect:/home");
    }
}
