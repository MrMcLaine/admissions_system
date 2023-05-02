package ua.admissions.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.admissions.system.entity.constant.SubjectName;
import ua.admissions.system.entity.person.Applicant;
import ua.admissions.system.entity.person.User;
import ua.admissions.system.service.ApplicantService;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("applicantForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("applicantForm") Applicant applicantForm, BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        applicantService.save(applicantForm);

        return "redirect:/home";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "home";
    }

    @RequestMapping(value = "/examScores", method = RequestMethod.GET)
    public ModelAndView createPeriodical(Model model) {
        List<SubjectName> examScores = Arrays.stream(SubjectName.values()).toList();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Applicant applicant = applicantService.findByEmail(userDetails.getUsername());

        model.addAttribute("applicant", applicant);
        model.addAttribute("examScores", examScores);

        return new ModelAndView("fillExamScores", model.asMap());
    }
}
