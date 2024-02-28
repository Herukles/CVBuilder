package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface ContactInfoService {
    String save(@RequestParam Long id, ContactInfo contactInfo);
    Optional<ContactInfo> findById(@RequestParam Long id);

    void deleteById(@RequestParam Long id);
}
