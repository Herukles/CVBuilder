package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.PersonalConverter.*;

@Service
public class PersonalServiceImpl implements PersonalService {

    CVRepository cvRepository;
    PersonalInfoRepository personalInfoRepository;

    @Autowired
    public PersonalServiceImpl(CVRepository cvRepository, PersonalInfoRepository personalInfoRepository) {
        this.cvRepository = cvRepository;
        this.personalInfoRepository = personalInfoRepository;
    }

    @Override
    public ResponseEntity<PersonalInfo> save(Long id, PersonalInfo personalInfo) {
        PersonalInfoEntity personalInfoEntity = personalInfoRepository.getReferenceById(id);

        personalInfoEntity.setName(personalInfo.getName());
        personalInfoEntity.setSurname(personalInfo.getSurname());
        personalInfoEntity.setAge(personalInfo.getAge());
        personalInfoEntity.setCountryOfBirth(personalInfo.getCountryOfBirth());
        personalInfoEntity.setDateOfBirth(personalInfo.getDateOfBirth());
        personalInfoEntity.setAboutMe(personalInfo.getAboutMe());

        PersonalInfoEntity savedPersonal = personalInfoRepository.save(personalInfoEntity);
        return new ResponseEntity<>(personalEntityToPersonal(savedPersonal), HttpStatus.OK);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
         return personalInfoRepository.findById(id).map(personalInfo -> personalEntityToPersonal(personalInfo));
    }

    @Override
    public void deleteById(Long id) {
        personalInfoRepository.deleteById(id);
    }
}
