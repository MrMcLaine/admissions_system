package ua.admissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.admissions.system.dto.ApplicantDto;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.service.ApplicantService;
import ua.admissions.system.service.ExamScoreService;

import javax.validation.Valid;

@Controller
public class ExamScoreController {

    @Autowired
    private ExamScoreService examScoreService;
    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/submitExamScores")
    public ModelAndView submitExamScores(@Valid @ModelAttribute("applicantDto") ApplicantDto applicantDto,
                                         BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/fillExamScores");
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Applicant applicant = applicantService.findByEmail(userDetails.getUsername());

        // save the ExamScore objects to the database
        examScoreService.saveExamScoresForApplicant(applicant, applicantDto.getScores());

        modelMap.addAttribute("successMessage", "Exam scores saved successfully");

        return new ModelAndView("redirect:/home");
    }
}
