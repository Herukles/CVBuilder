package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;



@Data
public class WorkExperience {
    LocalDate dateStart;
    LocalDate dateEnd;
    String companyName;
    String description;
}
