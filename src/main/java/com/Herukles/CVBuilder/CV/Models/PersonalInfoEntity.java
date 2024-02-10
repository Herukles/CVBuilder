package com.Herukles.CVBuilder.CV.Models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Optional;

@Data
@Component
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalInfo")
public class PersonalInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String countryOfBorn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBorn;
    private int age;
    private String aboutMe;
}
