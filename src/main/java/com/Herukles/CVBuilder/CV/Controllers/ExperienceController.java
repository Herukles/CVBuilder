package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("CV")
public class ExperienceController {
    CVService cvService;
    ExperienceService experienceService;

    @Autowired
    public ExperienceController(CVService cvService, ExperienceService experienceService) {
        this.cvService = cvService;
        this.experienceService = experienceService;
    }

    @GetMapping(path = "{cvId}/experience")
    public Optional<List<Experience>> allExperience(@PathVariable Long cvId) {
            Optional<CV> cv = cvService.findById(cvId);
            if(cv.isPresent()) {
                return Optional.of(cv.get().getExperienceList());
            } else {return Optional.empty();}
    }

    @GetMapping("{cvId}/experience/{expId}")
    public Optional<Experience> getExpById(@PathVariable Long cvId, @PathVariable Long expId) {
        Optional<CV> cv = cvService.findById(cvId);
        if(cv.isPresent()) {
            return Optional.of(cv.get().getExperienceList().get(expId.intValue()));
        } else {return Optional.empty();}
    }

    @PostMapping(path="{cvId}/experience/add")
    public void addExp(@PathVariable Long cvId, @RequestBody Experience experience) {
        experienceService.create(cvId, experience);
    }

    @PostMapping(path = "{cvId}/experience/{expId}/update")
    public void updateExperienceFieldById(@PathVariable Long cvId, @PathVariable Long expId, @RequestBody Experience experience) {
        Optional<CV> cv = cvService.findById(cvId);
        if(cv.isPresent()) {
            experienceService.update(cvId, experience);
        }
    }

    @PostMapping(path="{cvId}/experience/{expId}/delete")
    public void deleteEducationById(@PathVariable Long cvId, @PathVariable Long eduId) {
        experienceService.deleteById(eduId, cvId);
    }
}
