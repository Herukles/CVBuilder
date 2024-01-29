package com.Herukles.CVBuilder.CV;

import com.Herukles.CVBuilder.CV.Models.AboutMe;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Person;
import com.Herukles.CVBuilder.CV.Models.WorkExperience;

public class ResumeForm {
    Person person;
    AboutMe aboutMe;
    WorkExperience workExperience;
    Education education;

    public ResumeForm(Person person, AboutMe aboutMe, WorkExperience workExperience, Education education) {
        this.person = person;
        this.aboutMe = aboutMe;
        this.workExperience = workExperience;
        this.education = education;
    }

}
