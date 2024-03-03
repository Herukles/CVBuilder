package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.PersonalInfoRepository;
import com.Herukles.CVBuilder.CV.Services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<PersonalInfo> saveWithCVId(Long id, PersonalInfo personalInfo) {
        Optional<CV> foundCV = cvRepository.findById(id).map(cvEntity -> cvEntityToCV(cvEntity));
        if(foundCV.isPresent()) {
            CV cv = foundCV.get();
            PersonalInfoEntity personalInfoEntity = personalToPersonalEntity(personalInfo);
            personalInfoEntity.setCvEntity(cvToCVEntity(cv));
            cv.setPerson(personalInfo);
            cvRepository.save(cvToCVEntity(cv));
            return Optional.ofNullable(cv.getPerson());
        }
        else {
            return Optional.empty();
        }
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
