package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Repositories.CVRepository;
import com.Herukles.CVBuilder.CV.Repositories.ContactMeRepository;
import com.Herukles.CVBuilder.CV.Services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.ContactInfoConverter.*;
import static com.Herukles.CVBuilder.CV.Converters.CVConverter.*;

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
    public String save(@RequestParam Long id, ContactInfo contactInfo) {
        Optional<CV> foundCV = cvRepository.findById(id).map(cvEntity -> cvEntityToCV(cvEntity));
        if(foundCV.isPresent()) {
            CV cv = foundCV.get();
            contactInfo.setCv(cv);
            cv.setContactMe(contactInfo);
            cvRepository.save(cvToCVEntity(cv));
        }
        return "done saving data";
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
