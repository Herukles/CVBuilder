package com.Herukles.CVBuilder.CV.Builders;


import com.Herukles.CVBuilder.CV.Models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CVInsertValues {
        @Autowired
        private final CV cv;


        @Autowired
        public CVInsertValues(CV cv) {
            this.cv = cv;
        }

        public void insertPersonValues(PersonalInfo personalInfo, String name, String surname, int age, LocalDate dateOfBorn, String country) {
            if(cv.getPerson() != null) {
                personalInfo.setName(name);
                personalInfo.setAge(age);
                personalInfo.setCountryOfBorn(country);
                personalInfo.setDateOfBorn(dateOfBorn);
                personalInfo.setSurname(surname);
            }
        }



        public void insertExperienceValues(Experience experience, String companyName, String description, LocalDate dateStart, LocalDate dateEnd) {
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

        public void insertContactMeValues(ContactInfo contactMe, String phoneNumber, String email, String website) {
            if(contactMe != null) {
                contactMe.setEmail(email);
                contactMe.setWebsite(website);
                contactMe.setPhoneNumber(phoneNumber);
            }
        }
}
