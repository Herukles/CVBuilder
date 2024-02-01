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
    private Person person;

    @Autowired
    private AboutMe aboutMe;

    @Autowired
    private List<Education> educationList;

    @Autowired
    private List<WorkExperience> workExperienceList;

    @Autowired
    private ContactMe contactMe;

    public CV() {
    }

    public CV(Person person, AboutMe aboutMe, List<Education> education, List<WorkExperience> workExperience, ContactMe contactMe) {
        this.person = peprivate rson;
        this.aboutMe = aboutMe;
        this.educationList = education;
        this.workExperienceList = workExperience;
        this.contactMe = contactMe;
    }

}
