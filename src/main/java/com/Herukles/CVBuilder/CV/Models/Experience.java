package com.Herukles.CVBuilder.CV.Models;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
@Data
@Scope("prototype")
public class Experience {
    LocalDate WorkExperienceDateStart;
    LocalDate WorkExperienceDateEnd;
    String companyName;
    String description;
}
