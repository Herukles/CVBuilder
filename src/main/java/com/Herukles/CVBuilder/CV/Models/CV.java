package com.Herukles.CVBuilder.CV.Models;

import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Scope("prototype")
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Autowired
    private PersonalInfoEntity person;

    @Autowired
    private List<Education> educationList;

    @Autowired
    private List<Experience> workExperienceList;

    @Autowired
    private ContactInfo contactMe;

}
