package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonalService {
    String save(PersonalInfo personalInfo);
    PersonalInfo findById(@RequestParam Long id);
}
