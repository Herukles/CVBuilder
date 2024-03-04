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
    public String create(Long id, Experience experience) {
        ExperienceEntity experienceEntity = experienceToExperienceEntity(experience);
        Optional<CVEntity> cv = cvRepository.findById(id);
        if(cv.isPresent()){
            experienceEntity.setCvEntity(cv.get());
            experienceRepository.save(experienceEntity);
        }
        return "created";
    }

    @Override
    public String update(Long id, Experience experience) {
        ExperienceEntity expEntity = experienceRepository.getReferenceById(id);
        expEntity.setCompanyName(experience.getCompanyName());
        expEntity.setDescription(experience.getDescription());
        expEntity.setDateStart(experience.getDateStart());
        expEntity.setDateEnd(experience.getDateEnd());

        experienceRepository.save(expEntity);
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
    public void deleteById(Long expId, Long cvId) {
        CVEntity cvRef = cvRepository.getReferenceById(cvId);
        List<ExperienceEntity> expEntities = cvRef.getWorkExperienceListEntity();
        expEntities.remove(expId.intValue());
        cvRepository.save(cvRef);
    }
}
