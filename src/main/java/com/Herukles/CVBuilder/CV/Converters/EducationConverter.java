package com.Herukles.CVBuilder.CV.Converters;

import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;

public class EducationConverter {
    public static EducationEntity educationToEducationEntity(Education education) {
        return EducationEntity.builder()
                .nameOfInstitution(education.getNameOfInstitution())
                .educationDateStart(education.getEducationDateStart())
                .educationDateEnd(education.getEducationDateEnd())
                .build();
    }

    public static Education educationEntityToEducation(EducationEntity educationEntity) {
        return Education.builder()
                .nameOfInstitution(educationEntity.getNameOfInstitution())
                .educationDateStart(educationEntity.getEducationDateStart())
                .educationDateEnd(educationEntity.getEducationDateEnd())
                .build();
    }
}
