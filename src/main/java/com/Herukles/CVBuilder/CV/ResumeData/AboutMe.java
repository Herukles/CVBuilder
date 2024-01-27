package com.Herukles.CVBuilder.CV.ResumeData;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class AboutMe {
    String  aboutMeString;
    String degree;
}
