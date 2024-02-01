package com.Herukles.CVBuilder.CV.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class CVInsertValues {
    @Autowired
    private final CV cv;


    @Autowired
    public CVInsertValues(CV cv) {
        this.cv = cv;
    }

    public void insertPersonValues(Person person, String name, String surname, int age, LocalDate dateOfBorn, String country) {
        if(cv.getPerson() != null) {
            person.setName(name);
            person.setAge(age);
            person.setCountryOfBorn(country);
            person.setDateOfBorn(dateOfBorn);
            person.setSurname(surname);
        }
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

    public void insertContactMeValues(ContactMe contactMe, String phoneNumber, String email, String website) {
        if(contactMe != null) {
            contactMe.setEmail(email);
            contactMe.setWebsite(website);
            contactMe.setPhoneNumber(phoneNumber);
        }
    }
}

