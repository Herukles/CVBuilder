package com.Herukles.CVBuilder.CV.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
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

    @GetMapping(path="/home/")
    public String mainPage(Model model) {
        return "home";
    }}
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
