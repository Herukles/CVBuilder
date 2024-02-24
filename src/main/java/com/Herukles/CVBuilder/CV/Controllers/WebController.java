package com.Herukles.CVBuilder.CV.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    @GetMapping(path="/home/")
    public String mainPage(Model model) {
        return "home";
    }

    @GetMapping(path="/home/start")
    public String startPage(Model model) {
        return "startPage";
    }


}
