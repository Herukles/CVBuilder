package com.Herukles.CVBuilder.CV.Models.Entities;

import com.Herukles.CVBuilder.CV.Models.ContactInfo;
import com.Herukles.CVBuilder.CV.Models.Education;
import com.Herukles.CVBuilder.CV.Models.Experience;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="CV")
@Builder
public class CVEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private PersonalInfoEntity person;
    private List<Education> educationList;
    private List<Experience> workExperienceList;
    private ContactInfo contactMe;

}
