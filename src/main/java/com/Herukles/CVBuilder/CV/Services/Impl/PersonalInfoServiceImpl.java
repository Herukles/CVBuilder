package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Repository.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<PersonalInfo> listPersonal() {
        final List<PersonalInfoEntity> foundPersonals = personalInfoRepository.findAll();
        return foundPersonals.stream().map(personalInfo -> personalInfoEntityToPersonalInfo(personalInfo)).collect(Collectors.toList());
    }

    private PersonalInfoEntity personalInfoToEntity(PersonalInfo personalInfo) {
            return PersonalInfoEntity.builder()
                    .id(personalInfo.getId())
                    .name(personalInfo.getName())
                    .surname(personalInfo.getSurname())
                    .countryOfBorn(personalInfo.getCountryOfBorn())
                    .dateOfBirth(personalInfo.getDateOfBirth())
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
                .dateOfBirth(personalInfoEntity.getDateOfBirth())
                .age(personalInfoEntity.getAge())
                .aboutMe(personalInfoEntity.getAboutMe())
                .build();
    }
}
