package com.Herukles.CVBuilder.CV.Models;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

@ToString
@Scope("prototype")
@Data
@Component


public class CV {


    @Autowired
    Person person;

    @Autowired
    AboutMe aboutMe;

    @Autowired
    Education education;

    @Autowired
    WorkExperience workExperience;

    @Autowired
    ContactMe contactMe;

    public CV() {
    }

    public CV(Person person, AboutMe aboutMe, Education education, WorkExperience workExperience, ContactMe contactMe) {
        this.person = person;
        this.aboutMe = aboutMe;
        this.education = education;
        this.workExperience = workExperience;
        this.contactMe = contactMe;
    }

}
