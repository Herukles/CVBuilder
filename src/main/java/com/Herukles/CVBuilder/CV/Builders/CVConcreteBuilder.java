package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.AboutMe;
import com.Herukles.CVBuilder.CV.ResumeData.Education;
import com.Herukles.CVBuilder.CV.ResumeData.Person;
import com.Herukles.CVBuilder.CV.ResumeData.WorkExperience;

public class CVConcreteBuilder implements CVBuilder{

    private AboutMe aboutMe;
    private Education education;
    private Person person;
    private WorkExperience workExperience;

    public void setAboutMe(AboutMe aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }


    @Override
    public void buildPersonal(Person person) {
        this.person = person;
    }

    @Override
    public void buildExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public void buildAboutMe(AboutMe aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public void buildEducation(Education education) {
        this.education = education;
    }

}
