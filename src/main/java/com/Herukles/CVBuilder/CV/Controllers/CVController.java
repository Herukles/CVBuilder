package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Services.CVService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/CV/")
public class CVController {
    private final CVService cvService;

    @Autowired
    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CV> createCV(
            @PathVariable final long id,
            @RequestBody final CV cv) {
        cv.setId(id);
        final CV savedCV = cvService.create(cv);
        return new ResponseEntity<CV>(savedCV, HttpStatus.CREATED);
    }

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
