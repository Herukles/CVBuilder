package com.Herukles.CVBuilder.CV;

import com.Herukles.CVBuilder.CV.ResumeData.AboutMe;
import com.Herukles.CVBuilder.CV.ResumeData.Education;
import com.Herukles.CVBuilder.CV.ResumeData.Person;
import com.Herukles.CVBuilder.CV.ResumeData.WorkExperience;

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
