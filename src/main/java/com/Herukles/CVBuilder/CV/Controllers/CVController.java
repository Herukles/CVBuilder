package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/CV")
public class CVController {

    private final PersonalInfoService personalInfoService;

    @Autowired
    public CVController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    // PersonalInfo/id
    @PutMapping(path = "/personalInfo/{id}")
    public ResponseEntity<PersonalInformation> createPersonalInfo(
            @PathVariable final long id,
            @RequestBody final PersonalInformation personalInformation) {
            personalInformation.setId(id);
            final PersonalInformation savedPersonalInfo = personalInfoService.create(personalInformation);
            final ResponseEntity<PersonalInformation> response = new ResponseEntity<PersonalInformation>(savedPersonalInfo, HttpStatus.CREATED);
            return response;
    }

}
