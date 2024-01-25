package com.Herukles.CVBuilder.CV.ResumeData;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
@Scope("prototype")
public class Person {
    private String name;
    private String surname;
    private String countryOfBorn;
    private LocalDate dateOfBorn;
    private int age;
}
