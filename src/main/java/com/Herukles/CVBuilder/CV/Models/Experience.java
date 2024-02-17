package com.Herukles.CVBuilder.CV.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
@Data
@Scope("prototype")
@Getter
@Setter
public class Experience {
    LocalDate WorkExperienceDateStart;
    LocalDate WorkExperienceDateEnd;
    String companyName;
    String description;
}
