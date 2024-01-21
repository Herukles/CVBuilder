package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Setter
@Getter
@ToString
public class CV {

    Person person;
    AboutMe aboutMe;
    Education education;
    WorkExperience workExperience;

    public CV() {
    }

    public CV(Person person, AboutMe aboutMe, Education education, WorkExperience workExperience) {
        this.person = person;
        this.aboutMe = aboutMe;
        this.education = education;
        this.workExperience = workExperience;
    }
}
