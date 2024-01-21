package com.Herukles.CVBuilder.CV.Builders;

import com.Herukles.CVBuilder.CV.ResumeData.*;

import java.time.LocalDate;

public class CVConcreteBuilder implements CVBuilder{

    private AboutMe aboutMe;
    private Education education;
    private Person person;
    private WorkExperience workExperience;
    private ContactMe contactMe;



    public void setAboutMe(AboutMe aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public void setContactMe(ContactMe contactMe) {
        this.contactMe = contactMe;
    }

    @Override
    public void buildPersonal(Person person, String name, String surname, int age, LocalDate dateOfBorn, String countryOfBorn) {
        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);
        person.setDateOfBorn(dateOfBorn);
        person.setCountryOfBorn(countryOfBorn);
        this.person = person;
    }

    @Override
    public void buildExperience(WorkExperience workExperience, String name, LocalDate start, LocalDate end, String desc) {
        workExperience.setCompanyName(name);
        workExperience.setWorkExperienceDateStart(start);
        workExperience.setWorkExperienceDateEnd(end);
        workExperience.setDescription(desc);
        this.workExperience = workExperience;
    }

    @Override
    public void buildAboutMe(AboutMe aboutMe, String aboutMeDesc) {
        aboutMe.setAboutMeString(aboutMeDesc);
        this.aboutMe = aboutMe;
    }

    @Override
    public void buildEducation(Education education, String nameOfInstitution, LocalDate start, LocalDate end) {
        education.setNameOfInstitution(nameOfInstitution);
        education.setEducationDateStart(start);
        education.setEducationDateEnd(end);
        this.education = education;
    }

    @Override
    public void buildContactMe(ContactMe contactMe, String phoneNumber, String email, String website) {
        contactMe.setPhoneNumber(phoneNumber);
        contactMe.setEmail(email);
        contactMe.setWebsite(website);
    }


    public CV getResult() {
        return new CV(person,aboutMe,education,workExperience,contactMe);
    }

    public ContactMe getContactMe() {
        return contactMe;
    }

    public AboutMe getAboutMe() {
        return aboutMe;
    }

    public Education getEducation() {
        return education;
    }

    public Person getPerson() {
        return person;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }
}
