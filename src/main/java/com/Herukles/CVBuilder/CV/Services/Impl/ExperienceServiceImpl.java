package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.ExperienceRepository;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.ExperienceConverter.*;

public class ExperienceServiceImpl implements ExperienceService {
    CVRepository cvRepository;
    ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(CVRepository cvRepository, ExperienceRepository experienceRepository) {
        this.cvRepository = cvRepository;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public String save(Long id, Experience experience) {
        Optional<CV> foundCV = cvRepository.findById(id).map(cvEntity -> cvEntityToCV(cvEntity));
        if(foundCV.isPresent()) {
            CV cv = foundCV.get();
            experience.setCv(cv);
            List<Experience> experienceList = cv.getWorkExperienceListEntity();
            experienceList.add(experience);
            cvRepository.save(cvToCVEntity(cv));
        }
        return "saved to db.";
    }

    @Override
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id).map(experience -> experienceEntityToExperience(experience));
    }

    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
