package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Builders.Implementation.CVBuilderImpl;
import com.Herukles.CVBuilder.CV.Models.*;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CVDirector {
    int howManyEducationFields;
    int howManyExperienceFields;

    @Autowired
    private PersonalInfoEntity person;

    @Autowired
    private List<Education> education;

    @Autowired
    private List<Experience> workExperience;

    @Autowired
    private ContactInfo contactMe;

    public CVDirector() {
        this.howManyEducationFields = 1;
        this.howManyExperienceFields = 1;
    }


    public CVDirector(int howManyEducationFields, int howManyExperienceFields) {
        this.howManyEducationFields = howManyEducationFields;
        this.howManyExperienceFields = howManyExperienceFields;
    }

    public void constructCV(CVBuilderImpl cvBuilderImpl) {
        cvBuilderImpl.buildPersonal(person);
        cvBuilderImpl.buildEducationList();
        cvBuilderImpl.buildExperienceList();
        for(int i = 0; i < howManyEducationFields;i++) {
            cvBuilderImpl.addEducationFieldToList(new Education());
        }
        for(int i = 0; i < howManyExperienceFields;i++) {
            cvBuilderImpl.addExperienceFieldToList(new Experience());
        }
        cvBuilderImpl.buildContactMe(contactMe);
    }
}
