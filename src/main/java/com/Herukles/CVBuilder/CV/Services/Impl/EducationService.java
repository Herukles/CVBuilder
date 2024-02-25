package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.EducationRepository;

public class EducationService {
    EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public EducationEntity create(final EducationEntity education) {
        return educationRepository.save(education);
    }
}
