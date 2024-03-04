package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.Experience;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    String create(Long id, Experience experience);
    String update(@RequestParam Long id, Experience experience);
    Optional<Experience> findById(@RequestParam Long id);

    List<Experience> findAll();
    void deleteById(@RequestParam Long expId, Long cvId);
}
