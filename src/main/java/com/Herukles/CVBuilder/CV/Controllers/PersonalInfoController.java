package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.Impl.CVServiceImpl;
import com.Herukles.CVBuilder.CV.Services.Impl.PersonalServiceImpl;
import com.Herukles.CVBuilder.CV.Services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;

@RestController
@RequestMapping("CV")
public class PersonalInfoController {
    private final CVServiceImpl cvService;
    private final PersonalServiceImpl personalService;
    @Autowired
    public PersonalInfoController(CVServiceImpl cvService, PersonalServiceImpl personalService) {
        this.cvService = cvService;
        this.personalService = personalService;

    }

    @GetMapping(path = "{id}/personal")
    public Optional<PersonalInfo> getPersonalByCVId(@PathVariable Long id) {
        Optional<CV> foundCv = cvService.findById(id);
        return foundCv.map(CV::getPerson);
    }

    @PostMapping(path = "{id}/personal/update")
    public RedirectView updatePersonalDataWithCVId(@PathVariable Long id, PersonalInfo personalInfo){
        personalService.save(id, personalInfo);
        return new RedirectView("/home/contactme");
    }
}
