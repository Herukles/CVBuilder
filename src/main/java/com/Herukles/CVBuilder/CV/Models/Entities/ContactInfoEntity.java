package com.Herukles.CVBuilder.CV.Models.Entities;

import com.Herukles.CVBuilder.CV.Models.Entities.CVEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Setter
@Data
@Component
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    CVEntity cvEntity;

    private String phoneNumber;
    private String email;
    private String website;

}
