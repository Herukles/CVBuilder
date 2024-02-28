package com.Herukles.CVBuilder.CV.Services;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.PersonalInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContactInfoService {
    String save(ContactInfo contactInfo);
    ContactInfo findById(@RequestParam Long id);

    void deleteById(@RequestParam Long id);
}
