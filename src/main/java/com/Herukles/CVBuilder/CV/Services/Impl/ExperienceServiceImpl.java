package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.ExperienceEntity;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.ExperienceRepository;
import com.Herukles.CVBuilder.CV.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.ExperienceConverter.*;

@Service
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
        Optional<CVEntity> foundCV = cvRepository.findById(id);
        if(foundCV.isPresent()) {
            CVEntity cv = foundCV.get();
            List<ExperienceEntity> experienceEntityList = cv.getWorkExperienceListEntity();
            experienceEntityList.add(experienceToExperienceEntity(experience));
            cvRepository.save(cv);
        }
        return "saved to db.";
    }

    @Override
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id).map(experience -> experienceEntityToExperience(experience));
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll().stream().map(experienceEntity -> experienceEntityToExperience(experienceEntity)).toList();
    }

    @Override
    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
