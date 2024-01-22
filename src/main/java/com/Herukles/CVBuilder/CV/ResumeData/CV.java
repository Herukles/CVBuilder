package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Setter
@Getter
@ToString
@Data
public class CV {

    Person person;
    AboutMe aboutMe;
    Education education;
    WorkExperience workExperience;
    ContactMe contactMe;

    public CV() {
    }

    public CV(Person person, AboutMe aboutMe, Education education, WorkExperience workExperience, ContactMe contactMe) {
        this.person = person;
        this.aboutMe = aboutMe;
        this.education = education;
        this.workExperience = workExperience;
        this.contactMe = contactMe;
    }

//    public void insertPersonData(String name, String surname, int age, LocalDate dateOfBorn, String country) {
//        this.person.setName(name);
//        this.person.setAge(age);
//        this.person.setSurname(surname);
//        this.person.setCountryOfBorn(country);
//        this.person.setDateOfBorn(dateOfBorn);
//    }
//
//    public void insertAboutMeData(String aboutMe, String degree, LocalDate dateStart, LocalDate dateEnd) {
//        this.aboutMe.setAboutMeString(aboutMe);
//        this.aboutMe.setDegree(degree);
//        this.aboutMe.setDateStart(dateStart);
//        this.aboutMe.setDateEnd(dateEnd);
//    }
//
//    public void insertContactMeData(ContactMe contactMe) {
//
//    }
//
//    public void setEducationData(Education education) {
//
//    }
//
//    public void setWorkExperienceData(WorkExperience workExperience) {
//
//    }
}
