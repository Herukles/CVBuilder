package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping(path = "/")
//    public List<CV> cvList() {
//
//    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<CV>> getCVbyId(@PathVariable Long id) {
        Optional<CV> cv = cvService.findById(id);
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

    @PutMapping(value = "create", consumes = {"application/json"})
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {
        CV cvOut = cvService.save(cv);
        System.out.println(cv.toString());
        return new ResponseEntity<>(cvOut, HttpStatus.CREATED);
    }

//    @PutMapping(path="/delete/{id}")
//    public void deleteCVByID(@PathVariable Long id){
//        cvService.deleteById(id);
//    }
}
