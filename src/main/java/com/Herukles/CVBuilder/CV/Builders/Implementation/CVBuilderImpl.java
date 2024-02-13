package com.Herukles.CVBuilder.CV.Builders.Implementation;

import com.Herukles.CVBuilder.CV.Builders.CVBuilder;
import com.Herukles.CVBuilder.CV.Models.*;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CVBuilderImpl implements CVBuilder {

    @Autowired
    private List<Education> educationList;
    @Autowired
    private PersonalInfoEntity person;
    @Autowired
    private List<Experience> workExperienceList;
    @Autowired
    private ContactInfo contactMe;


    public CV getResult() {
        return new CV(person, educationList, workExperienceList, contactMe);
    }

    @Override
    public void buildPersonal(PersonalInfoEntity person) {
        this.person = person;
    }

    @Override
    public void buildExperienceList() {
        this.workExperienceList = new ArrayList<>();
    }


    @Override
    public void buildEducationList() {
        this.educationList = new ArrayList<>();
    }

    @Override
    public void addExperienceFieldToList(Experience workExperience) {
        this.workExperienceList.add(workExperience);
    }

    @Override
    public void addEducationFieldToList(Education education) {
        this.educationList.add(education);
    }

    @Override
    public void buildContactMe(ContactInfo contactMe) {
        this.contactMe = contactMe;
    }
}
