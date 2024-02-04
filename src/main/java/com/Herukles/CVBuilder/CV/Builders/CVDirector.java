package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CVDirector {
    int howManyEducationFields;
    int howManyExperienceFields;

    @Autowired
    private PersonalInformationEntity person;

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

    public void setHowManyEducationFields(int howManyEducationFields) {
        this.howManyEducationFields = howManyEducationFields;
    }

    public void setHowManyExperienceFields(int howManyExperienceFields) {
        this.howManyExperienceFields = howManyExperienceFields;
    }

    public CVDirector(int howManyEducationFields, int howManyExperienceFields) {
        this.howManyEducationFields = howManyEducationFields;
        this.howManyExperienceFields = howManyExperienceFields;
    }

    public void constructCV(CVConcreteBuilder cvConcreteBuilder) {
        cvConcreteBuilder.buildPersonal(person);
        cvConcreteBuilder.buildEducationList();
        cvConcreteBuilder.buildExperienceList();
        for(int i = 0; i < howManyEducationFields;i++) {
            cvConcreteBuilder.addEducationFieldToList(new Education());
        }
        for(int i = 0; i < howManyExperienceFields;i++) {
            cvConcreteBuilder.addExperienceFieldToList(new Experience());
        }
        cvConcreteBuilder.buildContactMe(contactMe);
    }
}
