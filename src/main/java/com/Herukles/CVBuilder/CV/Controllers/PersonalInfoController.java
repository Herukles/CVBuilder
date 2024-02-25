package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personal/")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @Autowired
    public PersonalInfoController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonalInfo> createPersonalInfo(
            @PathVariable final long id,
            @RequestBody final PersonalInfo personalInfo) {
            personalInfo.setId(id);
            final PersonalInfo savedPersonalInfo = personalInfoService.create(personalInfo);
            final ResponseEntity<PersonalInfo> response = new ResponseEntity<PersonalInfo>(savedPersonalInfo, HttpStatus.CREATED);
            return response;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonalInfo> retrievePersonalInfo(@PathVariable final long id) {
        Optional<PersonalInfo> foundPersonalInfo =  personalInfoService.findById(id);
        return foundPersonalInfo.map(personalInformation -> new ResponseEntity<PersonalInfo>(personalInformation, HttpStatus.OK)).orElse(new ResponseEntity<PersonalInfo>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<PersonalInfo>> listPersonalInfo() {
        return new ResponseEntity<List<PersonalInfo>>(personalInfoService.listPersonal(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ModelAndView postPersonalInfo(PersonalInfo personalInfo) {
        personalInfoService.create(personalInfo);
        return new ModelAndView("redirect:/home/education");
    }

    // CVform page
    
}
