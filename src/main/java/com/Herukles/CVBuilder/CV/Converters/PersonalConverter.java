package com.Herukles.CVBuilder.CV.Converters;

import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;



public class PersonalConverter {
    public static PersonalInfoEntity personalToPersonalEntity(PersonalInfo personalInfo) {
        return PersonalInfoEntity.builder()
                .name(personalInfo.getName())
                .surname(personalInfo.getSurname())
                .age(personalInfo.getAge())
                .countryOfBirth(personalInfo.getCountryOfBirth())
                .age(personalInfo.getAge())
                .aboutMe(personalInfo.getAboutMe())
                .dateOfBirth(personalInfo.getDateOfBirth())
                .build();
    }

    public static PersonalInfo personalEntityToPersonal(PersonalInfoEntity personalInfoEntity) {
        return PersonalInfo.builder()
                .name(personalInfoEntity.getName())
                .surname(personalInfoEntity.getSurname())
                .age(personalInfoEntity.getAge())
                .countryOfBirth(personalInfoEntity.getCountryOfBirth())
                .age(personalInfoEntity.getAge())
                .aboutMe(personalInfoEntity.getAboutMe())
                .dateOfBirth(personalInfoEntity.getDateOfBirth())
                .build();
    }
}
