package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.ContactMeRepository;
import com.Herukles.CVBuilder.CV.Services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.ContactInfoConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.PersonalConverter.personalEntityToPersonal;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {
    CVRepository cvRepository;
    ContactMeRepository contactMeRepository;

    @Autowired
    public ContactInfoServiceImpl(CVRepository cvRepository, ContactMeRepository contactMeRepository) {
        this.cvRepository = cvRepository;
        this.contactMeRepository = contactMeRepository;
    }

    @Override
    public ResponseEntity<ContactInfo> save(Long id, ContactInfo contactInfo) {

        ContactInfoEntity contactInfoEntity = contactMeRepository.getReferenceById(id);

        contactInfoEntity.setEmail(contactInfo.getEmail());
        contactInfoEntity.setWebsite(contactInfo.getWebsite());
        contactInfoEntity.setPhoneNumber(contactInfo.getPhoneNumber());

        ContactInfoEntity savedContactInfo = contactMeRepository.save(contactInfoEntity);
        return new ResponseEntity<>(contactInfoEntityToContactInfo(savedContactInfo), HttpStatus.OK);
    }

    @Override
    public Optional<ContactInfo> findById(Long id) {
        Optional<CV> foundContactInfo =  cvRepository.findById(id).map(cvEntity -> cvEntityToCV(cvEntity));
        return Optional.ofNullable(foundContactInfo.get().getContactMe());
    }

    @Override
    public void deleteById(Long id) {
        contactMeRepository.deleteById(id);
    }
}
