package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.*;

public class CVDirector {
    int howManyEducationFields;
    int howManyExperienceFields;

    public CVDirector() {
        this.howManyEducationFields = 1;
        this.howManyExperienceFields = 1;
    }

    public CVDirector(int howManyEducationFields, int howManyExperienceFields) {
        this.howManyEducationFields = howManyEducationFields;
        this.howManyExperienceFields = howManyExperienceFields;
    }

    public void constructCV(CVConcreteBuilder cvConcreteBuilder) {
      cvConcreteBuilder.buildPersonal(new Person());
      cvConcreteBuilder.buildAboutMe(new AboutMe());

      for(int i = 0; i < howManyEducationFields;i++) {
          cvConcreteBuilder.buildEducation(new Education());
      }
      for(int i = 0; i < howManyExperienceFields;i++) {
          cvConcreteBuilder.buildExperience(new WorkExperience());
      }
      cvConcreteBuilder.buildContactMe(new ContactMe());
    }
}
