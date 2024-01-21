package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Education {
    String nameOfInstitution;
    LocalDate EducationDateStart;
    LocalDate EducationDateEnd;
    // dateStart = LocalDate.of(2020,12,1);

}
