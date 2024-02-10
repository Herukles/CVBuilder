package com.Herukles.CVBuilder.CV.Models;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Scope("prototype")
@Data
@Component
public class CV {


    @Autowired
    private PersonalInfoEntity person;

    @Autowired
    private List<Education> educationList;

    @Autowired
    private List<Experience> workExperienceList;

    @Autowired
    private ContactInfo contactMe;

    public CV() {
    }

    public CV(PersonalInfoEntity person, List<Education> education, List<Experience> workExperience, ContactInfo contactMe) {
        this.person = person;
        this.educationList = education;
        this.workExperienceList = workExperience;
        this.contactMe = contactMe;
    }

}
