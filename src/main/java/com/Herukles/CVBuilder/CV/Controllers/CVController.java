package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/CV")
public class CVController {

    private final PersonalInfoService personalInfoService;

    @Autowired
    public CVController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    // PersonalInfo/id
    @PutMapping(path = "/personalInfo/{id}")
    public ResponseEntity<PersonalInfo> createPersonalInfo(
            @PathVariable final long id,
            @RequestBody final PersonalInfo personalInfo) {
            personalInfo.setId(id);
            final PersonalInfo savedPersonalInfo = personalInfoService.create(personalInfo);
            final ResponseEntity<PersonalInfo> response = new ResponseEntity<PersonalInfo>(savedPersonalInfo, HttpStatus.CREATED);
            return response;
    }

    @GetMapping(path = "/personalInfo/{id}")
    public ResponseEntity<PersonalInfo> retrievePersonalInfo(@PathVariable final long id) {
        Optional<PersonalInfo> foundPersonalInfo =  personalInfoService.findById(id);
        return foundPersonalInfo.map(personalInformation -> new ResponseEntity<PersonalInfo>(personalInformation, HttpStatus.OK)).orElse(new ResponseEntity<PersonalInfo>(HttpStatus.NOT_FOUND));
    }

}
