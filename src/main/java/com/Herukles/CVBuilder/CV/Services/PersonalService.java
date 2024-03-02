package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface PersonalService {
    Optional<PersonalInfo> saveWithCVId(Long id, PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);
    void deleteById(Long id);
}
