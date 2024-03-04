package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("CV")
public class EducationController {

    CVService cvService;
    EducationService educationService;

    @Autowired
    public EducationController(CVService cvService, EducationService educationService) {
        this.cvService = cvService;
        this.educationService = educationService;
    }

    @GetMapping(path = "{cvId}/education/")
    public Optional<List<Education>> allEducations(@PathVariable Long cvId) {
        Optional<CV> cv = cvService.findById(cvId);
        if(cv.isPresent()) {
            return Optional.of(cv.get().getEducationList());
        } else {return Optional.empty();}
    }

    @GetMapping("{cvId}/education/{eduId}")
    public Optional<Education> getEduById(@PathVariable Long cvId, @PathVariable Long eduId) {
       Optional<CV> cv = cvService.findById(cvId);
       if(cv.isPresent()) {
           return Optional.of(cv.get().getEducationList().get(eduId.intValue()));
       } else {return Optional.empty();}
    }

    @PostMapping(path="{cvId}/education/add")
    public RedirectView addEdu(@PathVariable Long cvId, Education education) {
            educationService.create(cvId, education);
            return new RedirectView("/home/education");
    }

    @PostMapping(path = "{cvId}/education/{eduId}/update")
    public void updateEducationFieldById(@PathVariable Long cvId, @PathVariable Long eduId, @RequestBody Education education) {
        Optional<CV> cv = cvService.findById(cvId);
        if(cv.isPresent()) {
            educationService.update(cvId, education);
        }
    }

    @PostMapping(path="{cvId}/education/{eduId}/delete")
    public void deleteEducationById(@PathVariable Long cvId, @PathVariable Long eduId) {
            educationService.deleteById(eduId, cvId);
    }

}
