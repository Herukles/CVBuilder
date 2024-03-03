package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.EducationRepository;
import com.Herukles.CVBuilder.CV.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.EducationConverter.*;

@Service
public class EducationServiceImpl implements EducationService {

    CVRepository cvRepository;
    EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(CVRepository cvRepository, EducationRepository educationRepository) {
        this.cvRepository = cvRepository;
        this.educationRepository = educationRepository;
    }

    @Override
    public String create(Long id, Education education) {
        EducationEntity education1 = educationToEducationEntity(education);
        Optional<CVEntity> cv = cvRepository.findById(id);
        if(cv.isPresent()) {
            education1.setCvEntity(cv.get());
            educationRepository.save(education1);
        }

        return "created";
    }

    @Override
    public String update(Long id, Education education) {
        EducationEntity edu = educationRepository.getReferenceById(id);

        edu.setEducationDateEnd(education.getEducationDateEnd());
        edu.setEducationDateStart(education.getEducationDateStart());
        edu.setNameOfInstitution(education.getNameOfInstitution());

        educationRepository.save(edu);

        return "saved education to db.";
    }

    @Override
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id).map(education -> educationEntityToEducation(education));
    }

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll().stream().map(educationEntity -> educationEntityToEducation(educationEntity)).toList();
    }

    @Override
    public void deleteById(Long eduId, Long cvId) {

        CVEntity cvRef = cvRepository.getReferenceById(cvId);
        List<EducationEntity> educationEntities = cvRef.getEducationEntityList();
        educationEntities.remove(eduId.intValue());
        cvRepository.save(cvRef);

    }
}
