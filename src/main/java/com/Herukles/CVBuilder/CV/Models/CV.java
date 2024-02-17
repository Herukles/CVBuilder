package com.Herukles.CVBuilder.CV.Models;

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
public class CV {

    @Autowired
    private PersonalInfoEntity person;

    @Autowired
    private List<Education> educationList;

    @Autowired
    private List<Experience> workExperienceList;

    @Autowired
    private ContactInfo contactMe;

}
