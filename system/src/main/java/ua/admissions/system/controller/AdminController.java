package ua.admissions.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.admissions.system.dto.AdminDto;
import ua.admissions.system.entity.constant.FacultyName;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public ModelAndView adminPage(Model model) {

        AdminDto adminDto = new AdminDto();

        List<FacultyName> faculties = Arrays.asList(FacultyName.values());
        model.addAttribute("faculties", faculties);
        model.addAttribute("adminDto", adminDto);

        return new ModelAndView("adminPage", "model", model);
    }

    @PostMapping("/selectedFaculty")
    public ModelAndView submitExamScores(@Valid @ModelAttribute("adminDto") AdminDto adminDto,
                                         BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/apply-admission");
        }

        modelMap.addAttribute("successMessage", "Exam scores saved successfully");
        return new ModelAndView("/adminPage");
    }
}
