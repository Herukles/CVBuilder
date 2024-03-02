package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.Impl.CVServiceImpl;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;

@RestController
@RequestMapping("CV")
public class CVController {
    private final CVService cvService;

    @Autowired
    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @PutMapping(value = "create", consumes = {"application/json"})
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {

        PersonalInfo personalInfo = cv.getPerson();
        personalInfo.setCv(cvToCVEntity(cv));

        ContactInfo contactInfo = cv.getContactMe();
        contactInfo.setCv(cvToCVEntity(cv));

        List<Experience> experiences = cv.getWorkExperienceListEntity();
        for(Experience exp : experiences) {exp.setCv(cvToCVEntity(cv));}

        List<Education> educations = cv.getEducationEntityList();
        for(Education edu : educations) {edu.setCv(cvToCVEntity(cv));}


        CV cvTMP = CV.builder()
                .person(personalInfo)
                .contactMe(contactInfo)
                .workExperienceListEntity(experiences)
                .educationEntityList(educations)
                .build();



        CV cvOut = cvService.save(cvTMP);
        System.out.println(cv.toString());
        return new ResponseEntity<>(cvOut, HttpStatus.CREATED);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<CV>> getCVbyId(@PathVariable Long id) {
        Optional<CV> cv = cvService.findById(id);
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }





    @PostMapping(path="/save/{id}")
    public String saveCVById(@PathVariable Long id, @RequestBody CV cv) {
        Optional<CV> foundCV = cvService.findById(id);
        cv.setId(id);
        if(foundCV.isPresent()) {
            CV cvTMP = foundCV.get();


        }
        return "saved.";
    }
}
