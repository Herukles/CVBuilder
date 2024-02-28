package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Experience;
import org.springframework.web.bind.annotation.RequestParam;

public interface EducationService {
    String save(Education education);
    Education findById(@RequestParam Long id);
}
