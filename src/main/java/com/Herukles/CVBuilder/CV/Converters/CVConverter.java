package com.Herukles.CVBuilder.CV.Converters;
import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.ExperienceEntity;
import com.Herukles.CVBuilder.CV.Models.Experience;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;

import java.util.ArrayList;
import java.util.List;

import static com.Herukles.CVBuilder.CV.Converters.PersonalConverter.personalEntityToPersonal;
import static com.Herukles.CVBuilder.CV.Converters.PersonalConverter.personalToPersonalEntity;
import static  com.Herukles.CVBuilder.CV.Converters.ContactInfoConverter.contactInfoEntityToContactInfo;
import static  com.Herukles.CVBuilder.CV.Converters.ContactInfoConverter.contactInfoToContactInfoEntity;
import static  com.Herukles.CVBuilder.CV.Converters.EducationConverter.educationEntityToEducation;
import static  com.Herukles.CVBuilder.CV.Converters.EducationConverter.educationToEducationEntity;
import static  com.Herukles.CVBuilder.CV.Converters.ExperienceConverter.experienceEntityToExperience;
import static  com.Herukles.CVBuilder.CV.Converters.ExperienceConverter.experienceToExperienceEntity;

public class CVConverter {
    public static CV cvEntityToCV(CVEntity cvEntity) {

        List<Education> educationList = new ArrayList<>();
        for(EducationEntity edu : cvEntity.getEducationEntityList())  {
            educationList.add(educationEntityToEducation(edu));
        }

        List<Experience> experienceList = new ArrayList<>();
        for(ExperienceEntity exp : cvEntity.getWorkExperienceListEntity()) {
            experienceList.add(experienceEntityToExperience(exp));
        }

        return CV.builder()
                .id(cvEntity.getId())
                .person(personalEntityToPersonal(cvEntity.getPerson()))
                .educationEntityList(educationList)
                .workExperienceListEntity(experienceList)
                .contactMe(contactInfoEntityToContactInfo(cvEntity.getContactMe()))
                .build();
    }
    public static CVEntity cvToCVEntity(CV cv) {

        List<EducationEntity> educationEntityList = new ArrayList<>();
        for(Education edu : cv.getEducationEntityList())  {
            educationEntityList.add(educationToEducationEntity(edu));
        }

        List<ExperienceEntity> experienceEntityList = new ArrayList<>();
        for(Experience exp : cv.getWorkExperienceListEntity()) {
            experienceEntityList.add(experienceToExperienceEntity(exp));
        }

        return CVEntity.builder()
                .id(cv.getId())
                .person(personalToPersonalEntity(cv.getPerson()))
                .educationEntityList(educationEntityList)
                .workExperienceListEntity(experienceEntityList)
                .contactMe(contactInfoToContactInfoEntity(cv.getContactMe()))
                .build();
    }
}
