package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Models.*;

public interface CVBuilder {
    public void buildPersonal(PersonalInfoEntity person);
    public void buildExperienceList();
    public void buildEducationList();

    public void addExperienceFieldToList(Experience workExperience);
    public void addEducationFieldToList(Education education);

    public void buildContactMe(ContactInfo contactMe);

}
