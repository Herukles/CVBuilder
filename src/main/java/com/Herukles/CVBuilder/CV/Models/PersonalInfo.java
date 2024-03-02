package com.Herukles.CVBuilder.CV.Models;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class PersonalInfo {



    private long id;

    private String name;
    private String surname;
    private int age;
    private String countryOfBirth;
    private LocalDate dateOfBirth;
    private String aboutMe;

    CV cv;
}
