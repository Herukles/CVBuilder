package com.Herukles.CVBuilder.CV.ResumeData;

import java.time.LocalDate;

public class CVInsertValues {
    private CV cv;

    public CVInsertValues(CV cv) {
        this.cv = cv;
    }

    public void insertPersonValues(Person person, String name, String surname, int age, LocalDate dateOfBorn, String country) {
        person.setName(name);
        person.setAge(age);
        person.setCountryOfBorn(country);
        person.setDateOfBorn(dateOfBorn);
        person.setSurname(surname);
    }
    public void insertAboutMeValues(AboutMe aboutMe, String aboutMeString, String degree) {
        aboutMe.setAboutMeString(aboutMeString);
        aboutMe.setDegree(degree);
//        aboutMe.setDateStart(dateStart);
//        aboutMe.setDateEnd(dateEnd);
    }
    public void insertExperienceValues(WorkExperience experience, String companyName, String description, LocalDate dateStart, LocalDate dateEnd) {
        experience.setCompanyName(companyName);
        experience.setDescription(description);
        experience.setWorkExperienceDateStart(dateStart);
        experience.setWorkExperienceDateEnd(dateEnd);
    }
    public void insertEducationValues(Education education, String institution, LocalDate dateStart, LocalDate dateEnd) {
           education.setNameOfInstitution(institution);
           education.setEducationDateStart(dateStart);
           education.setEducationDateEnd(dateEnd);
    }
}
