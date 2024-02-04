package com.Herukles.CVBuilder.CV.Models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
@Scope("prototype")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalInfos")
public class PersonalInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String surname;
    private String countryOfBorn;
    private LocalDate dateOfBorn;
    private int age;
    private String aboutMe;
}
