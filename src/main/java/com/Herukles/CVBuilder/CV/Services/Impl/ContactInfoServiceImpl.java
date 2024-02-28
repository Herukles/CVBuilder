package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Repositories.ContactMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoServiceImpl {
    private final ContactMeRepository contactMeRepository;

    @Autowired
    public ContactInfoServiceImpl(ContactMeRepository contactMeRepository) {
        this.contactMeRepository = contactMeRepository;
    }


    public ContactInfoEntity createContactInfo(final ContactInfo contactInfo) {
        ContactInfoEntity contactInfoEntity = contactInfoToEntity(contactInfo);
        return contactMeRepository.save(contactInfoEntity);
    }


    public Optional<ContactInfo> findById(Long id) {
        final Optional<ContactInfoEntity> foundContactInfo = contactMeRepository.findById(id);
        return foundContactInfo.map(contactInfo -> contactInfoEntitytoContactInfo(contactInfo));
    }


    public List<ContactInfo> listContactInfo() {
        final List<ContactInfoEntity> foundContactInfo = contactMeRepository.findAll();
        return foundContactInfo.stream().map(contactInfo -> contactInfoEntitytoContactInfo(contactInfo)).toList();
    }

    private ContactInfoEntity contactInfoToEntity(ContactInfo contactInfo) {
        return ContactInfoEntity.builder()
                .email(contactInfo.getEmail())
                .phoneNumber(contactInfo.getPhoneNumber())
                .website(contactInfo.getWebsite())
                .build();
    }
    private ContactInfo contactInfoEntitytoContactInfo(ContactInfoEntity contactInfoEntity) {
       return ContactInfo.builder()
               .email(contactInfoEntity.getEmail())
               .phoneNumber(contactInfoEntity.getPhoneNumber())
               .website(contactInfoEntity.getWebsite())
               .build();
    }
}

