package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
@Data
public class AboutMe {
    String  aboutMeString;
    String degree;
//    LocalDate dateStart;
//    LocalDate dateEnd;
}
