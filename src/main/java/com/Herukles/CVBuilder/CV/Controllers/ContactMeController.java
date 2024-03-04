package com.Herukles.CVBuilder.CV.Controllers;

import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Services.CVService;
import com.Herukles.CVBuilder.CV.Services.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

import static com.Herukles.CVBuilder.CV.Converters.ContactInfoConverter.*;

@RestController
@RequestMapping("CV")
public class ContactMeController {
    CVService cvService;
    ContactInfoService contactInfoService;

    @Autowired
    public ContactMeController(CVService cvService, ContactInfoService contactInfoService) {
        this.cvService = cvService;
        this.contactInfoService = contactInfoService;
    }

    @GetMapping("{id}/contactme")
    public Optional<ContactInfo> getContactMe(@PathVariable Long id) {
        Optional<CV> foundCv = cvService.findById(id);
        if(foundCv.isPresent()) {return Optional.of(foundCv.get().getContactMe());}
        else{return Optional.empty();}
    }

    @PostMapping("{id}/contactme/update")
    public RedirectView updateContactInfo(@PathVariable Long id, ContactInfo contactInfo) {
        contactInfoService.save(id, contactInfo);
        return new RedirectView("/home/contactme");
    }
}
