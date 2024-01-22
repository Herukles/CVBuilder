package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.*;

import java.time.LocalDate;

public interface CVBuilder {
    public void buildPersonal(Person person);
    public void buildExperience(WorkExperience workExperience);
    public void buildAboutMe(AboutMe aboutMe);
    public void buildEducation(Education education);
    public void buildContactMe(ContactMe contactMe);

}
