package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface PersonalService {
    String save(@RequestParam Long id, PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(@RequestParam Long id);
    void deleteById(@RequestParam Long id);
}
