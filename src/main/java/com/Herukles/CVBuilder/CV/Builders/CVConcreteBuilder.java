package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.*;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class CVConcreteBuilder implements CVBuilder{

    @Autowired
    private AboutMe aboutMe;
    @Autowired
    private Education education;
    @Autowired
    private Person person;
    @Autowired
    private WorkExperience workExperience;
    @Autowired
    private ContactMe contactMe;



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

    public void setContactMe(ContactMe contactMe) {
        this.contactMe = contactMe;
    }




    public CV getResult() {
        return new CV(person,aboutMe,education,workExperience,contactMe);
    }

    public ContactMe getContactMe() {
        return contactMe;
    }

    public AboutMe getAboutMe() {
        return aboutMe;
    }

    public Education getEducation() {
        return education;
    }

    public Person getPerson() {
        return person;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
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

    @Override
    public void buildContactMe(ContactMe contactMe) {
        this.contactMe = contactMe;
    }
}
