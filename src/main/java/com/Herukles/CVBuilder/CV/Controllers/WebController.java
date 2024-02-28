package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Controller
//public class WebController {
//
//    PersonalInfoService personalInfoService;
//    CVEntity cvEntity;
//
//    CV cv;
//
//    @Autowired
//    public WebController(PersonalInfoService personalInfoService, CVEntity cvEntity, CV cv) {
//        this.personalInfoService = personalInfoService;
//        this.cvEntity = cvEntity;
//        this.cv = cv;
//    }
//
//    @GetMapping(path="/home/")
//    public String mainPage(Model model) {
//        return "home";
//    }
//
//    @GetMapping(path="/home/fillPersonal")
//    public String fillPersonalInfoSite(Model model) {
//        model.addAttribute("personalInfo", cv.getPerson());
//        return "fillPersonal";
//    }
//
//    @GetMapping(path="/home/education")
//    public String fillEducation(Model model) {
//        model.addAttribute("educationList", cvEntity.getEducationEntityList());
//        //cv.getEducationEntityList().getFirst().getNameOfInstitution()
//        return "education";
//    }
//    @GetMapping(path="/home/educationForm")
//    public String educationForm(Model model) {
//        model.addAttribute("education", new Education());
//        return "educationForm";
//    }
//
//}
