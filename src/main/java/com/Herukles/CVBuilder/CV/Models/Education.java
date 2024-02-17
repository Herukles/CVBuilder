package com.Herukles.CVBuilder.CV.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
@Scope("prototype")
@Getter
@Setter
public class Education {
    String nameOfInstitution;
    LocalDate EducationDateStart;
    LocalDate EducationDateEnd;
}
