package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.Impl.CVServiceImpl;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/CV")
public class CVController {
    private final CVService cvService;

    private final CV cv;

    @Autowired
    public CVController(CVService cvService, CV cv) {
        this.cvService = cvService;
        this.cv = cv;
    }

    @PostMapping("/create/")
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {
        CV cvTMP = CV.builder()
                .person(cv.getPerson())
                .contactMe(cv.getContactMe())
                .workExperienceListEntity(cv.getWorkExperienceListEntity())
                .educationEntityList(cv.getEducationEntityList())
                .build();
        CV cvOut = cvService.save(cvTMP);
        return new ResponseEntity<>(cvTMP, HttpStatus.CREATED);
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
