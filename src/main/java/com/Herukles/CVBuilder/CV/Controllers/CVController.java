package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/getCV")
public class CVController {

    @Autowired
    CV cv;

    @GetMapping
    public String getCV() {
        return cv.toString();
    }

}
