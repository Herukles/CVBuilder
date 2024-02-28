package com.Herukles.CVBuilder.CV.Services.Impl;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Services.ContactInfoService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ContactInfoServiceImpl implements ContactInfoService {
    @Override
    public String save(@RequestParam Long id, ContactInfo contactInfo) {
        return null;
    }

    @Override
    public Optional<ContactInfo> findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
