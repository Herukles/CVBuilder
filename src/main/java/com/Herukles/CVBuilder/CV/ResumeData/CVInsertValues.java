package com.Herukles.CVBuilder.CV.ResumeData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CVInsertValues {
//
//    @Autowired
    final private CV cv;

    @Autowired
    public CVInsertValues(CV cv) {
        this.cv = cv;
    }

    public Person insertPersonValues(Person person, String name, String surname, int age, LocalDate dateOfBorn, String country) {
        if(person != null) {
            person.setName(name);
            person.setAge(age);
            person.setCountryOfBorn(country);
            person.setDateOfBorn(dateOfBorn);
            person.setSurname(surname);
        }
        return person;
    }

    public void insertAboutMeValues(AboutMe aboutMe, String aboutMeString, String degree) {
        if(aboutMe != null) {
            aboutMe.setAboutMeString(aboutMeString);
            aboutMe.setDegree(degree);
        }
    }

    public void insertExperienceValues(WorkExperience experience, String companyName, String description, LocalDate dateStart, LocalDate dateEnd) {
        if(experience != null) {
            experience.setCompanyName(companyName);
            experience.setDescription(description);
            experience.setWorkExperienceDateStart(dateStart);
            experience.setWorkExperienceDateEnd(dateEnd);
        }
    }

    public void insertEducationValues(Education education, String institution, LocalDate dateStart, LocalDate dateEnd) {
        if(education != null) {
            education.setNameOfInstitution(institution);
            education.setEducationDateStart(dateStart);
            education.setEducationDateEnd(dateEnd);
        }
    }
}

