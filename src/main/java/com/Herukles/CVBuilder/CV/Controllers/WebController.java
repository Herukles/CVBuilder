package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final CVController cvController;
    private final PersonalInfoController personalInfoController;
    private Long cvId;

    @Autowired
    public WebController(CVController cvController, PersonalInfoController personalInfoController) {
        this.cvController = cvController;
        this.personalInfoController = personalInfoController;
    }

    @GetMapping(path = "/home")
    public String mainPage(Model model) {
        ResponseEntity<Long> cvId = cvController.createCV();
        this.cvId = cvId.getBody();
        System.out.println(this.cvId);
        return "home";
    }

    @GetMapping(path = "/home/fillPersonal")
    public String fillPersonalInfoSite(Model model) {
        model.addAttribute("personalInfo", new PersonalInfo());
        model.addAttribute("urlToNext", "/CV/"+this.cvId+"/personal/update");
        model.addAttribute("cvId", this.cvId);
        return "fillPersonal";
    }
    @GetMapping(path = "/home/contactme")
    public String fillContactInfo(Model model) {
        model.addAttribute("contactInfo", new ContactInfo());
        model.addAttribute("urlToNext", "/CV/"+this.cvId+"/contactme/update");
        model.addAttribute("cvId", this.cvId);
        return "contactMe";
    }

}



