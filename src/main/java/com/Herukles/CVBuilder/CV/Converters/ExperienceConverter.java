package com.Herukles.CVBuilder.CV.Converters;

import com.Herukles.CVBuilder.CV.Models.Entities.ExperienceEntity;
import com.Herukles.CVBuilder.CV.Models.Experience;

public class ExperienceConverter {
    public static Experience experienceEntityToExperience(ExperienceEntity experienceEntity) {
        return Experience.builder()
                .id(experienceEntity.getId())
                .companyName(experienceEntity.getCompanyName())
                .dateStart(experienceEntity.getDateStart())
                .dateEnd(experienceEntity.getDateEnd())
                .description(experienceEntity.getDescription())
                .build();
    }
    public static ExperienceEntity experienceToExperienceEntity(Experience experience) {
        return ExperienceEntity.builder()
                .id(experience.getId())
                .companyName(experience.getCompanyName())
                .dateStart(experience.getDateStart())
                .dateEnd(experience.getDateEnd())
                .description(experience.getDescription())
                .build();
    }
}
