package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EducationService {
    EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public EducationEntity create(final Education education) {
        EducationEntity educationEntity = educationModelToEntity(education);
        return educationRepository.save(educationEntity);
    }

    public Optional<Education> findById(final long id) {
        Optional<Education> education  = educationRepository.findById(id).map(educationEntity -> educationEntityToModel(educationEntity));
        return education;
    }

    private EducationEntity educationModelToEntity(Education education) {
        return EducationEntity.builder()
                .nameOfInstitution(education.getNameOfInstitution())
                .educationDateStart(education.getEducationDateStart())
                .educationDateEnd(education.getEducationDateEnd())
                .build();
    }
    private Education educationEntityToModel(EducationEntity educationEntity) {
        return Education.builder()
                .nameOfInstitution(educationEntity.getNameOfInstitution())
                .educationDateStart(educationEntity.getEducationDateStart())
                .educationDateEnd(educationEntity.getEducationDateEnd())
                .build();
    }
}
