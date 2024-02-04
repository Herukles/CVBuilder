package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.PersonalInformation;
import com.Herukles.CVBuilder.CV.Models.PersonalInformationEntity;
import com.Herukles.CVBuilder.CV.Repository.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    private final PersonalInfoRepository cvRepository;

    @Autowired
    public PersonalInfoServiceImpl(PersonalInfoRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public PersonalInformation create(final PersonalInformation personalInformation) {
        final PersonalInformationEntity personalInformationEntity = personalInfoToEntity(personalInformation);
        final PersonalInformationEntity savedPersonalInfoEntity = cvRepository.save(personalInformationEntity);
        return personalInfoEntityToPersonalInfo(savedPersonalInfoEntity);
    }

    private PersonalInformationEntity personalInfoToEntity(PersonalInformation personalInformation) {
            return PersonalInformationEntity.builder()
                    .id(personalInformation.getId())
                    .name(personalInformation.getName())
                    .surname(personalInformation.getSurname())
                    .countryOfBorn(personalInformation.getCountryOfBorn())
                    .dateOfBorn(personalInformation.getDateOfBorn())
                    .age(personalInformation.getAge())
                    .aboutMe(personalInformation.getAboutMe())
                    .build();

    }

    private PersonalInformation personalInfoEntityToPersonalInfo(PersonalInformationEntity personalInformationEntity) {
        return PersonalInformation.builder()
                .id(personalInformationEntity.getId())
                .name(personalInformationEntity.getName())
                .surname(personalInformationEntity.getSurname())
                .countryOfBorn(personalInformationEntity.getCountryOfBorn())
                .dateOfBorn(personalInformationEntity.getDateOfBorn())
                .age(personalInformationEntity.getAge())
                .aboutMe(personalInformationEntity.getAboutMe())
                .build();
    }
}
