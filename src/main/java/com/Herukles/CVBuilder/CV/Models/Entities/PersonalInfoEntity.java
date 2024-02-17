package com.Herukles.CVBuilder.CV.Models.Entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalInfo")
@Getter
@Setter
public class PersonalInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String countryOfBorn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private int age;
    private String aboutMe;
}
