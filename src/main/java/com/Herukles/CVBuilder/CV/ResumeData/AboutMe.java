package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Data
@Component
public class AboutMe {
    String  aboutMeString;
    String degree;
}
