package com.Herukles.CVBuilder.CV.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Scope("prototype")
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CVEntity")
@Builder
@Entity
public class CVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "cvEntity")
    private PersonalInfoEntity person;

    @OneToMany(mappedBy = "cvEntity")
    private List<EducationEntity> educationEntityList;
    @OneToMany(mappedBy = "cvEntity")
    private List<ExperienceEntity> workExperienceListEntity;

    @OneToOne(mappedBy = "cvEntity")
    private ContactInfoEntity contactMe;

}
