package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfoEntity;

import java.time.LocalDate;

public final class TestData {
    public TestData() {
    }
    public static PersonalInfo testPersonalInfo () {
        return PersonalInfo.builder().
                id(1)
                .name("Albert")
                .surname("Einstein")
                .countryOfBorn("Ulm")
                .dateOfBirth(LocalDate.of(1979,3,14))
                .age(76)
                .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                .build();
    }
    public static PersonalInfoEntity testPersonalInfoEntity() {
        return PersonalInfoEntity.builder().
                id(1)
                .name("Albert")
                .surname("Einstein")
                .countryOfBorn("Ulm")
                .dateOfBirth(LocalDate.of(1979,3,14))
                .age(76)
                .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                .build();
    }
}
