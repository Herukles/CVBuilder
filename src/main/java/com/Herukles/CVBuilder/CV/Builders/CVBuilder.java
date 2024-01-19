package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.AboutMe;
import com.Herukles.CVBuilder.CV.ResumeData.Education;
import com.Herukles.CVBuilder.CV.ResumeData.Person;
import com.Herukles.CVBuilder.CV.ResumeData.WorkExperience;

public interface CVBuilder {
    public void buildPersonal(Person person);
    public void buildExperience(WorkExperience workExperience);
    public void buildAboutMe(AboutMe aboutMe);
    public void buildEducation(Education education);

}
