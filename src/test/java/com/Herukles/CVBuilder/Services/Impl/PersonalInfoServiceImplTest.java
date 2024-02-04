package com.Herukles.CVBuilder.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.CV.Models.PersonalInformationEntity;
import com.Herukles.CVBuilder.CV.Repository.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.Impl.PersonalInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonalInfoServiceImplTest {
    @Mock
    private PersonalInfoRepository cvRepository;
    @InjectMocks
    private PersonalInfoServiceImpl underTest;

    @Test
    public void checkThatPersonalInfoIsSaved() {
        final PersonalInformation personalInformation = PersonalInformation.builder().
                id(1)
                .name("Albert")
                .surname("Einstein")
                .countryOfBorn("Ulm")
                .dateOfBorn(LocalDate.of(1879,3,14))
                .age(76)
                .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                .build();

                final PersonalInformationEntity personalInformationEntity = PersonalInformationEntity.builder().
                        id(1)
                        .name("Albert")
                        .surname("Einstein")
                        .countryOfBorn("Ulm")
                        .dateOfBorn(LocalDate.of(1879,3,14))
                        .age(76)
                        .aboutMe("German-born theoretical physicist who is widely held to be one of the greatest and most influential scientists of all time.")
                        .build();

                when(cvRepository.save(eq(personalInformationEntity))).thenReturn(personalInformationEntity);

                final PersonalInformation result = underTest.create(personalInformation);
                assertEquals(personalInformation, result);
    }
}
