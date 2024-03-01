package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    CVController cvController;
    PersonalInfoController personalInfoController;
    CV cv;

    @Autowired
    public WebController(CVController cvController, PersonalInfoController personalInfoController, CV cv) {
        this.cvController = cvController;
        this.personalInfoController = personalInfoController;
        this.cv = cv;
    }

    @GetMapping(path = "/home/")
    public String mainPage(Model model) {
        return "home";
    }

    @GetMapping(path = "/home/fillPersonal")
    public String fillPersonalInfoSite(Model model) {
        model.addAttribute("personalInfo", cv.getPerson());
        return "fillPersonal";
    }
}


