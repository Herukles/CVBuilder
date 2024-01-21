package com.Herukles.CVBuilder.CV.ResumeData;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
public class Person {
    private String name;
    private String surname;
    private String countryOfBorn;
    private LocalDate dateOfBorn;
    private int age;

}
