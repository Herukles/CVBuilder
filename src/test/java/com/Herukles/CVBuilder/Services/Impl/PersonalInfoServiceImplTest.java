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

//import static methods to use in tests.
import static com.Herukles.CVBuilder.TestData.testPersonalInfoEntity;
import static com.Herukles.CVBuilder.TestData.testPersonalInfo;

import java.time.LocalDate;
import java.util.Optional;

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
        final PersonalInformation personalInformation = testPersonalInfo();

        final PersonalInformationEntity personalInformationEntity = testPersonalInfoEntity();

                when(cvRepository.save(eq(personalInformationEntity))).thenReturn(personalInformationEntity);

                final PersonalInformation result = underTest.create(personalInformation);
                assertEquals(personalInformation, result);
    }

    @Test
    public void testThatFindByIdReturnsEmptyWhenNoPersonal() {
        final long id = 9999999;
        when(cvRepository.findById(eq(id))).thenReturn(Optional.empty());
        final Optional<PersonalInformation> result = underTest.findById(id);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testThatFindByIdReturnsPersonalInfoWhenExists() {
        final PersonalInformation personalInformation = testPersonalInfo();
        final PersonalInformationEntity personalInformationEntity = testPersonalInfoEntity();

        when(cvRepository.findById(eq(personalInformation.getId()))).thenReturn(Optional.of(personalInformationEntity));
        final Optional<PersonalInformation> result = underTest.findById(personalInformation.getId());
        assertEquals(Optional.of(personalInformation), result);
    }
}
