package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    String save(@RequestParam Long id, Experience experience);
    Optional<Experience> findById(@RequestParam Long id);

    List<Experience> findAll();
    void deleteById(@RequestParam Long id);
}
