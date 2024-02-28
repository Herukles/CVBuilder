package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.EducationRepository;
import com.Herukles.CVBuilder.CV.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.EducationConverter.*;

public class EducationServiceImpl implements EducationService {

    CVRepository cvRepository;
    EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(CVRepository cvRepository, EducationRepository educationRepository) {
        this.cvRepository = cvRepository;
        this.educationRepository = educationRepository;
    }

    @Override
    public String save(Long id, Education education) {
        Optional<CV> foundCV = cvRepository.findById(id).map(cv1 -> cvEntityToCV(cv1));
        if(foundCV.isPresent()) {
            CV cv = foundCV.get();
            List<Education> edu = cv.getEducationEntityList();
            edu.add(education);
            cvRepository.save(cvToCVEntity(cv));
        }
        return "saved education to db.";
    }

    @Override
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id).map(education -> educationEntityToEducation(education));
    }

    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }
}
