package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.itextpdf.text.pdf.qrcode.Mode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CV/")
public class CVController {
    private final CVService cvService;
    private final CVEntity cvEntity;

    public CVController(CVService cvService, CVEntity cvEntity) {
        this.cvService = cvService;
        this.cvEntity = cvEntity;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CV> createCV(
            @PathVariable final long id,
            @RequestBody final CV cv) {
        cv.setId(id);
        final CV savedCV = cvService.create(cv);
        return new ResponseEntity<CV>(savedCV, HttpStatus.CREATED);
    }

//    @PostMapping(path = "/addEducationListToCV")
//    public ModelAndView addEducationListToCV(List<EducationEntity> educationEntities) {
//        cvService.setEducationListById(cvEntity.getId(), educationEntities);
//        return new ModelAndView("redirect:/home/fillExperience");
//    }
//
//    @PostMapping(path = "/addEducationToList")
//    public ModelAndView addEduToList(EducationEntity educationEntity) {
//        cvService.addEducationToList(cvEntity.getId(),educationEntity);
//        return new ModelAndView("redirect:/home/education");
//    }

    @GetMapping(path="/{id}")
    public ResponseEntity<CV> retrieveCVsById(@PathVariable final long id) {
        Optional<CV> foundCV = cvService.findById(id);
        return foundCV.map(cv -> new ResponseEntity<CV>(cv, HttpStatus.OK))
                .orElse(new ResponseEntity<CV>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<CV>> allCVsList() {
        return new ResponseEntity<List<CV>>(cvService.listOfCV(), HttpStatus.OK);
    }

    
}
