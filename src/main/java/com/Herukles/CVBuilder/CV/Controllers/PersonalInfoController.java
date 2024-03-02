package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.Impl.CVServiceImpl;
import com.Herukles.CVBuilder.CV.Services.Impl.PersonalServiceImpl;
import com.Herukles.CVBuilder.CV.Services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;

@RestController
@RequestMapping("CV/personal")
public class PersonalInfoController {
    private final CVServiceImpl cvService;
    private final PersonalServiceImpl personalService;

    private final CV cv;

    @Autowired
    public PersonalInfoController(CVServiceImpl cvService, PersonalServiceImpl personalService, CV cv) {
        this.cvService = cvService;
        this.personalService = personalService;
        this.cv = cv;
    }

    @PostMapping(value="{id}/save")
    public Optional<PersonalInfo> savePersonal(@RequestParam(name = "id") long id, @RequestBody PersonalInfo personalInfo) {
        Optional<CV> foundCV = cvService.findById(id);
        if(foundCV.isPresent()){
            CV cvTmp = foundCV.get();
            personalInfo.setCv(cvTmp);
            cvTmp.setPerson(personalInfo);
            personalService.saveWithCVId(foundCV.get().getId(), personalInfo);
            return Optional.ofNullable(personalInfo);
        }
        else {return Optional.empty();}
    }
}
