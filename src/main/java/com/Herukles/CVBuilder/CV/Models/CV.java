package com.Herukles.CVBuilder.CV.Models;

import com.Herukles.CVBuilder.CV.Models.Entities.ContactInfoEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.EducationEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.ExperienceEntity;
import com.Herukles.CVBuilder.CV.Models.Entities.PersonalInfoEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CV {
    private long id;
    @Autowired
    private PersonalInfo person;
    @Autowired
    private ContactInfo contactMe;
    @Autowired
    private List<Education> educationEntityList;
    @Autowired
    private List<Experience> workExperienceListEntity;
}
