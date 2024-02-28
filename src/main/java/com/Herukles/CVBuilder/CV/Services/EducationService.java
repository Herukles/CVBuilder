package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Experience;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface EducationService {
    String save(@RequestParam Long id, Education education);
    Optional<Education> findById(@RequestParam Long id);

    void deleteById(@RequestParam Long id);
}
