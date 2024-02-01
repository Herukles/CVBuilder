package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Models.*;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CVConcreteBuilder implements CVBuilder{

    @Autowired
    private AboutMe aboutMe;
    @Autowired
    private List<Education> educationList;
    @Autowired
    private Person person;
    @Autowired
    private List<WorkExperience> workExperienceList;
    @Autowired
    private ContactMe contactMe;


    public CV getResult() {
        return new CV(person,aboutMe, educationList, workExperienceList, contactMe);
    }

    @Override
    public void buildPersonal(Person person) {
        this.person = person;
    }

    @Override
    public void buildExperienceList(WorkExperience workExperience) {
        this.workExperienceList = new ArrayList<>();
    }


    @Override
    public void buildAboutMe(AboutMe aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public void buildEducationList(Education education) {
        this.educationList = new ArrayList<>();
    }

    @Override
    public void addExperienceFieldToList(WorkExperience workExperience) {
        this.workExperienceList.add(workExperience);
    }

    @Override
    public void addEducationFieldToList(Education education) {
        this.educationList.add(education);
    }

    @Override
    public void buildContactMe(ContactMe contactMe) {
        this.contactMe = contactMe;
    }
}
