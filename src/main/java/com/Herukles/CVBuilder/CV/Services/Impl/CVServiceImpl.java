package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Repository.CVRepository;
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
        Iterator<Experience> expIterator = cv.getWorkExperienceList().iterator();
        Iterator<Education> eduIterator = cv.getEducationList().iterator();

        List<Experience> experiences = new ArrayList<>();
        List<Education> educations = new ArrayList<>();

        PersonalInfoEntity personal = PersonalInfoEntity.builder()
                .name(cv.getPerson().getName())
                .surname(cv.getPerson().getSurname())
                .age(cv.getPerson().getAge())
                .countryOfBorn(cv.getPerson().getCountryOfBorn())
                .dateOfBirth(cv.getPerson().getDateOfBirth())
                .aboutMe(cv.getPerson().getAboutMe()).build();

        ContactInfo contactInfo = ContactInfo.builder()
                .email(cv.getContactMe().getEmail())
                .website(cv.getContactMe().getWebsite())
                .phoneNumber(cv.getContactMe().getPhoneNumber()).build();


        while(expIterator.hasNext()) {
            Experience next = expIterator.next();
            experiences.add(Experience.builder()
                    .dateStart(next.getDateStart())
                    .dateEnd(next.getDateEnd())
                    .companyName(next.getCompanyName())
                    .description(next.getDescription()).build());

        }
        while(eduIterator.hasNext()) {
            Education next = eduIterator.next();
            educations.add(
                    Education.builder()
                            .nameOfInstitution(next.getNameOfInstitution())
                            .EducationDateStart(next.getEducationDateStart())
                            .EducationDateEnd(next.getEducationDateEnd()).build()
            );
        }
        return CVEntity.builder()
                .person(personal)
                .contactMe(contactInfo)
                .educationList(educations)
                .workExperienceList(experiences)
                .build();
    }

    private CV cvEntityToCV(CVEntity cvEntity) {
        Iterator<Experience> expIterator = cvEntity.getWorkExperienceList().iterator();
        Iterator<Education> eduIterator = cvEntity.getEducationList().iterator();

        List<Experience> experiences = new ArrayList<>();
        List<Education> educations = new ArrayList<>();

        PersonalInfoEntity personal = PersonalInfoEntity.builder()
                .name(cvEntity.getPerson().getName())
                .surname(cvEntity.getPerson().getSurname())
                .age(cvEntity.getPerson().getAge())
                .countryOfBorn(cvEntity.getPerson().getCountryOfBorn())
                .dateOfBirth(cvEntity.getPerson().getDateOfBirth())
                .aboutMe(cvEntity.getPerson().getAboutMe()).build();

        ContactInfo contactInfo = ContactInfo.builder()
                .email(cvEntity.getContactMe().getEmail())
                .website(cvEntity.getContactMe().getWebsite())
                .phoneNumber(cvEntity.getContactMe().getPhoneNumber()).build();


        while(expIterator.hasNext()) {
            Experience next = expIterator.next();
            experiences.add(Experience.builder()
                    .dateStart(next.getDateStart())
                    .dateEnd(next.getDateEnd())
                    .companyName(next.getCompanyName())
                    .description(next.getDescription()).build());

        }
        while(eduIterator.hasNext()) {
            Education next = eduIterator.next();
            educations.add(
                    Education.builder()
                            .nameOfInstitution(next.getNameOfInstitution())
                            .EducationDateStart(next.getEducationDateStart())
                            .EducationDateEnd(next.getEducationDateEnd()).build()
            );
        }
        return CV.builder()
                .person(personal)
                .educationList(educations)
                .workExperienceList(experiences)
                .contactMe(contactInfo).build();
    }


}
