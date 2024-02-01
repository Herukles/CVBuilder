package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.Models.*;

public interface CVBuilder {
    public void buildPersonal(Person person);
    public void buildExperienceList(WorkExperience workExperience);
    public void buildEducationList(Education education);

    public void addExperienceFieldToList(WorkExperience workExperience);
    public void addEducationFieldToList(Education education);

    public void buildAboutMe(AboutMe aboutMe);
    public void buildContactMe(ContactMe contactMe);

}
