package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.*;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CVServiceImpl implements CVService {
    private final CVRepository cvRepository;

    @Autowired
    public CVServiceImpl(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }



    @Override
    public CV create(final CV cv) {
        CVEntity cvEntity = cvToCVEntity(cv);
        CVEntity savedCvEntity = cvRepository.save(cvEntity);
        return cvEntityToCV(savedCvEntity);
    }

    @Override
    public Optional<CV> findById(Long id) {
        final Optional<CVEntity> foundCVEntity = cvRepository.findById(id);
        return foundCVEntity.map(cv -> cvEntityToCV(cv));
    }

    @Override
    public List<CV> listOfCV() {
        final List<CVEntity> foundCVs = cvRepository.findAll();
        return foundCVs.stream().map(cv -> cvEntityToCV(cv)).collect(Collectors.toList());
    }

    private CVEntity cvToCVEntity(CV cv) {


        List<ExperienceEntity> experienceEntities = new ArrayList<>();
        List<EducationEntity> educationEntities = new ArrayList<>();

        PersonalInfoEntity personal = PersonalInfoEntity.builder()
                .name(cv.getPerson().getName())
                .surname(cv.getPerson().getSurname())
                .age(cv.getPerson().getAge())
                .countryOfBirth(cv.getPerson().getCountryOfBirth())
                .dateOfBirth(cv.getPerson().getDateOfBirth())
                .aboutMe(cv.getPerson().getAboutMe()).build();

        ContactInfoEntity contactInfoEntity = ContactInfoEntity.builder()
                .email(cv.getContactMe().getEmail())
                .website(cv.getContactMe().getWebsite())
                .phoneNumber(cv.getContactMe().getPhoneNumber()).build();

        Iterator<ExperienceEntity> expIterator = cv.getWorkExperienceListEntity().iterator();
        Iterator<EducationEntity> eduIterator = cv.getEducationEntityList().iterator();
        while(expIterator.hasNext()) {
            ExperienceEntity next = expIterator.next();
            experienceEntities.add(ExperienceEntity.builder()
                    .dateStart(next.getDateStart())
                    .dateEnd(next.getDateEnd())
                    .companyName(next.getCompanyName())
                    .description(next.getDescription()).build());
        }
        while(eduIterator.hasNext()) {
            EducationEntity next = eduIterator.next();
            educationEntities.add(
                    EducationEntity.builder()
                            .nameOfInstitution(next.getNameOfInstitution())
                            .educationDateStart(next.getEducationDateStart())
                            .educationDateEnd(next.getEducationDateEnd()).build()
            );
        }
        return CVEntity.builder()
                .person(personal)
                .contactMe(contactInfoEntity)
                .educationEntityList(educationEntities)
                .workExperienceListEntity(experienceEntities)
                .build();
    }

    private CV cvEntityToCV(CVEntity cvEntity) {
        Iterator<ExperienceEntity> expIterator = cvEntity.getWorkExperienceListEntity().iterator();
        Iterator<EducationEntity> eduIterator = cvEntity.getEducationEntityList().iterator();

        List<ExperienceEntity> experienceEntities = new ArrayList<>();
        List<EducationEntity> educationEntities = new ArrayList<>();

        PersonalInfoEntity personal = PersonalInfoEntity.builder()
                .name(cvEntity.getPerson().getName())
                .surname(cvEntity.getPerson().getSurname())
                .age(cvEntity.getPerson().getAge())
                .countryOfBirth(cvEntity.getPerson().getCountryOfBirth())
                .dateOfBirth(cvEntity.getPerson().getDateOfBirth())
                .aboutMe(cvEntity.getPerson().getAboutMe()).build();

        ContactInfoEntity contactInfoEntity = ContactInfoEntity.builder()
                .email(cvEntity.getContactMe().getEmail())
                .website(cvEntity.getContactMe().getWebsite())
                .phoneNumber(cvEntity.getContactMe().getPhoneNumber()).build();


        while(expIterator.hasNext()) {
            ExperienceEntity next = expIterator.next();
            experienceEntities.add(ExperienceEntity.builder()
                    .dateStart(next.getDateStart())
                    .dateEnd(next.getDateEnd())
                    .companyName(next.getCompanyName())
                    .description(next.getDescription()).build());

        }
        while(eduIterator.hasNext()) {
            EducationEntity next = eduIterator.next();
            educationEntities.add(
                    EducationEntity.builder()
                            .nameOfInstitution(next.getNameOfInstitution())
                            .educationDateStart(next.getEducationDateStart())
                            .educationDateEnd(next.getEducationDateEnd()).build()
            );
        }
        return CV.builder()
                .person(personal)
                .educationEntityList(educationEntities)
                .workExperienceListEntity(experienceEntities)
                .contactMe(contactInfoEntity).build();
    }


}
