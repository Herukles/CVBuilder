package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.AboutMe;
import com.Herukles.CVBuilder.CV.ResumeData.Education;
import com.Herukles.CVBuilder.CV.ResumeData.Person;
import com.Herukles.CVBuilder.CV.ResumeData.WorkExperience;

import java.time.LocalDate;

public interface CVBuilder {
    public void buildPersonal(Person person, String name, String surname, int age, LocalDate dateOfBorn, String countryOfBorn);
    public void buildExperience(WorkExperience workExperience, String name, LocalDate start, LocalDate end, String desc);
    public void buildAboutMe(AboutMe aboutMe, String aboutMeDesc);
    public void buildEducation(Education education, String nameOfInstitution, LocalDate start, LocalDate end);

}
