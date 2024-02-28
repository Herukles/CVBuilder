package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface ExperienceService {
    String save(Experience experience);
    Experience findById(@RequestParam Long id);

    void deleteById(@RequestParam Long id);
}
