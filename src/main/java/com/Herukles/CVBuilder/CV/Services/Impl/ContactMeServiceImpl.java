package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Repositories.ContactMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class ContactMeServiceImpl {
    private final ContactMeRepository contactMeRepository;

    @Autowired
    public ContactMeServiceImpl(ContactMeRepository contactMeRepository) {
        this.contactMeRepository = contactMeRepository;
    }


    public ContactInfoEntity createContactInfo(final ContactInfoEntity contactInfoEntity) {
        //final PersonalInfoEntity personalInfoEntity = personalInfoToEntity(personalInfo);
        return contactMeRepository.save(contactInfoEntity);
    }


    public Optional<ContactInfoEntity> findById(Long id) {
        final Optional<ContactInfoEntity> foundContactInfo = contactMeRepository.findById(id);
        return foundContactInfo;
    }


    public List<ContactInfoEntity> listContactInfo() {
        final List<ContactInfoEntity> foundContactInfo = contactMeRepository.findAll();
        return foundContactInfo;
    }
}

