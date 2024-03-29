package com.Herukles.CVBuilder.CV.Models.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;



@Data
@Component
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoEntity {

    @Id
    @Column(name = "cv_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="cv_id_contact")
    private CVEntity cvEntity;

    private String phoneNumber;
    private String email;
    private String website;

}
