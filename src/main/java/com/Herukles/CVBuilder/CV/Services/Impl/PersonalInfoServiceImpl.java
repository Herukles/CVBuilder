package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Repository.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    @Autowired
    public PersonalInfoServiceImpl(PersonalInfoRepository cvRepository) {
        this.personalInfoRepository = cvRepository;
    }

    @Override
    public PersonalInfo create(final PersonalInfo personalInfo) {
        final PersonalInfoEntity personalInfoEntity = personalInfoToEntity(personalInfo);
        final PersonalInfoEntity savedPersonalInfoEntity = personalInfoRepository.save(personalInfoEntity);
        return personalInfoEntityToPersonalInfo(savedPersonalInfoEntity);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        final Optional<PersonalInfoEntity> foundPersonalInfo = personalInfoRepository.findById(id);
        return foundPersonalInfo.map(personalInformation -> personalInfoEntityToPersonalInfo(personalInformation) );
    }

    private PersonalInfoEntity personalInfoToEntity(PersonalInfo personalInfo) {
            return PersonalInfoEntity.builder()
                    .id(personalInfo.getId())
                    .name(personalInfo.getName())
                    .surname(personalInfo.getSurname())
                    .countryOfBorn(personalInfo.getCountryOfBorn())
                    .dateOfBorn(personalInfo.getDateOfBorn())
                    .age(personalInfo.getAge())
                    .aboutMe(personalInfo.getAboutMe())
                    .build();

    }

    private PersonalInfo personalInfoEntityToPersonalInfo(PersonalInfoEntity personalInfoEntity) {
        return PersonalInfo.builder()
                .id(personalInfoEntity.getId())
                .name(personalInfoEntity.getName())
                .surname(personalInfoEntity.getSurname())
                .countryOfBorn(personalInfoEntity.getCountryOfBorn())
                .dateOfBorn(personalInfoEntity.getDateOfBorn())
                .age(personalInfoEntity.getAge())
                .aboutMe(personalInfoEntity.getAboutMe())
                .build();
    }
}
