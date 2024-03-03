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
@Table(name = "personal")
@Getter
@Setter
public class PersonalInfoEntity {
    @Id
    @Column(name="cv_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="cv_id_personal")
    CVEntity cvEntity;

    private String name;
    private String surname;
    private String countryOfBirth;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private int age;
    private String aboutMe;


}
