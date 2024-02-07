package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.CV.Models.PersonalInformationEntity;

import java.time.LocalDate;

public final class TestData {
    public TestData() {
    }
    public static PersonalInformation testPersonalInfo () {
        return PersonalInformation.builder().
                id(1)
                .name("Albert")
                .surname("Einstein")
                .countryOfBorn("Ulm")
                .dateOfBorn(LocalDate.of(1879,3,14))
                .age(76)
                .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                .build();
    }
    public static PersonalInformationEntity testPersonalInfoEntity() {
        return PersonalInformationEntity.builder().
                id(1)
                .name("Albert")
                .surname("Einstein")
                .countryOfBorn("Ulm")
                .dateOfBorn(LocalDate.of(1879,3,14))
                .age(76)
                .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                .build();
    }
}
