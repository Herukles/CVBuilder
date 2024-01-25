package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Data
@Component
@Scope("prototype")
public class Education {
    String nameOfInstitution;
    LocalDate EducationDateStart;
    LocalDate EducationDateEnd;
    // dateStart = LocalDate.of(2020,12,1);

}
