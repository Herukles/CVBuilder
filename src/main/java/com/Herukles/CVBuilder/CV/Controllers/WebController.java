package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    PersonalInfoService personalInfoService;
    CVEntity cvEntity;



    @Autowired
    public WebController(PersonalInfoService personalInfoService, CVEntity cvEntity) {
        this.personalInfoService = personalInfoService;
        this.cvEntity = cvEntity;

    }

    @GetMapping(path="/home/")
    public String mainPage(Model model) {
        return "home";
    }

    @GetMapping(path="/home/fillPersonal")
    public String fillPersonalInfoSite(Model model) {
        model.addAttribute("personalInfo", new PersonalInfo());
        return "fillPersonal";
    }

    @GetMapping(path="/home/education")
    public String fillEducation(Model model) {
        model.addAttribute("education", new Education());
        return "fillEducation";
    }

    @GetMapping(path="/home/experience")
    public String fillExperience(Model model) {
        model.addAttribute("experience", new Experience());
        return "fillExperience";
    }

    @GetMapping(path="/home/experience")
    public String fillContactMe(Model model) {
        model.addAttribute("contactMe", new ContactInfoEntity());
        return "fillContactMe";
    }




}
