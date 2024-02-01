package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CVDirector {
    int howManyEducationFields;
    int howManyExperienceFields;

    @Autowired
    private Person person;

    @Autowired
    private AboutMe aboutMe;

    @Autowired
    private Education education;

    @Autowired
    private WorkExperience workExperience;

    @Autowired
    private ContactMe contactMe;

    public CVDirector() {
        this.howManyEducationFields = 1;
        this.howManyExperienceFields = 1;
    }

    public CVDirector(int howManyEducationFields, int howManyExperienceFields) {
        this.howManyEducationFields = howManyEducationFields;
        this.howManyExperienceFields = howManyExperienceFields;
    }

    public void constructCV(CVConcreteBuilder cvConcreteBuilder) {
        cvConcreteBuilder.buildPersonal(person);
        cvConcreteBuilder.buildAboutMe(aboutMe);

        for(int i = 0; i < howManyEducationFields;i++) {
            cvConcreteBuilder.buildEducationList(education);
        }
        for(int i = 0; i < howManyExperienceFields;i++) {
            cvConcreteBuilder.buildExperienceList(workExperience);
        }
        cvConcreteBuilder.buildContactMe(contactMe);
    }
}
