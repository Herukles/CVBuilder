package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;



@Data
public class WorkExperience {
    LocalDate WorkExperienceDateStart;
    LocalDate WorkExperienceDateEnd;
    String companyName;
    String description;
}
