package com.Herukles.CVBuilder.CV.Converters;

import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;

public class PersonalConverter {
    public static PersonalInfoEntity personalToPersonalEntity(PersonalInfo personalInfo) {
        return PersonalInfoEntity.builder()
                .id(personalInfo.getId())
                .name(personalInfo.getName())
                .surname(personalInfo.getSurname())
                .age(personalInfo.getAge())
                .countryOfBirth(personalInfo.getCountryOfBirth())
                .age(personalInfo.getAge())
                .aboutMe(personalInfo.getAboutMe())
                .build();
    }

    public static PersonalInfo personalEntityToPersonal(PersonalInfoEntity personalInfoEntity) {
        return PersonalInfo.builder()
                .id(personalInfoEntity.getId())
                .name(personalInfoEntity.getName())
                .surname(personalInfoEntity.getSurname())
                .age(personalInfoEntity.getAge())
                .countryOfBirth(personalInfoEntity.getCountryOfBirth())
                .age(personalInfoEntity.getAge())
                .aboutMe(personalInfoEntity.getAboutMe())
                .build();
    }
}
