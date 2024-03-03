package com.Herukles.CVBuilder.CV.Models;

import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@Builder
public class CV {

    public CV() {
        this.educationList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
    }

    private PersonalInfo person;
    private ContactInfo contactMe;
    private List<Education> educationList;
    private List<Experience> experienceList;
}
