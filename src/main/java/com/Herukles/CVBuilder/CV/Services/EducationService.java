package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Experience;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface EducationService {

    String create(Long id, Education education);
    String update(@RequestParam Long id, Education education);
    Optional<Education> findById(@RequestParam Long id);
    List<Education> findAll();
    void deleteById(@RequestParam Long eduId, Long cvId);
}
