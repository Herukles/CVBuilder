package com.Herukles.CVBuilder.CV.ResumeData;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Person {
    private String name;
    private String surname;
    private String countryOfBorn;
    private String dateOfBorn;
    private int age;

}
