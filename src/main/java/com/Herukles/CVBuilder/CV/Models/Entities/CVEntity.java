package com.Herukles.CVBuilder.CV.Models.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CVEntity")
@Builder
@Entity
public class CVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(mappedBy = "cvEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonalInfoEntity person;

    @OneToOne(mappedBy = "cvEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContactInfoEntity contactMe;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cvEntity", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<EducationEntity> educationEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cvEntity", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<ExperienceEntity> workExperienceListEntity;

}
