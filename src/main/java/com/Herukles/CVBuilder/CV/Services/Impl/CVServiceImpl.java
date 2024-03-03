package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Entities.*;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Services.CVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvToCVEntity;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.cvEntityToCV;
import static com.Herukles.CVBuilder.CV.Converters.EducationConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.ExperienceConverter.*;

@Service
@Slf4j
public class CVServiceImpl implements CVService {

    CVRepository cvRepository;

    @Autowired
    public CVServiceImpl(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public CV save(CV cv) {
        CVEntity cvEntity = cvToCVEntity(cv);
        PersonalInfoEntity personalInfoEntity = cvEntity.getPerson();
        ContactInfoEntity contactInfoEntity = cvEntity.getContactMe();
        List<EducationEntity> educationEntityList = cv.getEducationList().stream().map(education -> educationToEducationEntity(education)).toList();
        List<ExperienceEntity> experienceEntityList = cv.getExperienceList().stream().map(experience -> experienceToExperienceEntity(experience)).toList();

        personalInfoEntity.setCvEntity(cvEntity);
        contactInfoEntity.setCvEntity(cvEntity);
        for(EducationEntity education : educationEntityList){education.setCvEntity(cvEntity);}
        for(ExperienceEntity experience: experienceEntityList){experience.setCvEntity(cvEntity);}
        cvEntity.setEducationEntityList(educationEntityList);
        cvEntity.setWorkExperienceListEntity(experienceEntityList);

        CVEntity savedCV = cvRepository.save(cvEntity);
        return cvEntityToCV(savedCV);
    }


    @Override
    public Optional<CV> findById(Long id) {
        Optional<CVEntity> foundCVEntity = cvRepository.findById(id);
        return foundCVEntity.map(cvEntity -> cvEntityToCV(cvEntity));
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCV(Long id) {
        try {cvRepository.deleteById(id);} catch (Exception e) {
            System.out.println("cannot delete");
        }
        return null;
    }

    private CVEntity addReferenceFieldsToConvertedEntities(CVEntity convertedCV, CVEntity cvEntityRef) {
        //conversion

        //extract fields
        PersonalInfoEntity personalInfoEntity = convertedCV.getPerson();
        ContactInfoEntity contactInfoEntity = convertedCV.getContactMe();
        List<EducationEntity> educationEntityList = convertedCV.getEducationEntityList();
        List<ExperienceEntity> experienceEntityList = convertedCV.getWorkExperienceListEntity();

        personalInfoEntity.setCvEntity(cvEntityRef);
        contactInfoEntity.setCvEntity(cvEntityRef);
        for(ExperienceEntity exp : experienceEntityList) {exp.setCvEntity(cvEntityRef);}
        for(EducationEntity edu : educationEntityList) {edu.setCvEntity(cvEntityRef);}

        convertedCV.setPerson(personalInfoEntity);
        convertedCV.setContactMe(contactInfoEntity);
        convertedCV.setEducationEntityList(educationEntityList);
        convertedCV.setWorkExperienceListEntity(experienceEntityList);
        return convertedCV;
    }
}
