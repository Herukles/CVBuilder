package com.Herukles.CVBuilder.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfoEntity;
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

import java.util.List;
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
        final PersonalInfo personalInfo = testPersonalInfo();

        final PersonalInfoEntity personalInfoEntity = testPersonalInfoEntity();

                when(cvRepository.save(eq(personalInfoEntity))).thenReturn(personalInfoEntity);

                final PersonalInfo result = underTest.create(personalInfo);
                assertEquals(personalInfo, result);
    }

    @Test
    public void testThatFindByIdReturnsEmptyWhenNoPersonal() {
        final long id = 9999999;
        when(cvRepository.findById(eq(id))).thenReturn(Optional.empty());
        final Optional<PersonalInfo> result = underTest.findById(id);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testThatFindByIdReturnsPersonalInfoWhenExists() {
        final PersonalInfo personalInfo = testPersonalInfo();
        final PersonalInfoEntity personalInfoEntity = testPersonalInfoEntity();

        when(cvRepository.findById(eq(personalInfo.getId()))).thenReturn(Optional.of(personalInfoEntity));
        final Optional<PersonalInfo> result = underTest.findById(personalInfo.getId());
        assertEquals(Optional.of(personalInfo), result);
    }

    @Test
    public void testThatListOfPersonalsReturnsEmptyWhenNoPersonalsExists() {
        final List<PersonalInfo> result = underTest.listPersonal();
        assertEquals(0, result.size());
    }

    @Test
    public void testThatListOfPersonalsReturnsListWhenPersonalsExists() {
        final PersonalInfoEntity personalInfoEntity = testPersonalInfoEntity();
        when(cvRepository.findAll()).thenReturn(List.of(personalInfoEntity));
        final List<PersonalInfo> result = underTest.listPersonal();
        assertEquals(1,result.size());
    }
}
