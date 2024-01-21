package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.ResumeData.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CvBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvBuilderApplication.class, args);


		CVConcreteBuilder cv = new CVConcreteBuilder();
		cv.buildPersonal(new Person(), "Kacper","Gacek",23, LocalDate.of(1999,12,15),"Krapkowice");
		cv.buildAboutMe(new AboutMe(), "As a highly motivated student, i love to code, learn, solve problems, and explore new posibilities;)");
		cv.buildEducation(new Education(),"Zespół Szkół Żeglugi Śródlądowej w Kędzierzynie- Koźlu", LocalDate.of(2016,1,1), LocalDate.of(2020,1,1));
		cv.buildEducation(new Education(), "Politechnika Opolska", LocalDate.of(2020,10,1),LocalDate.of(2024,2,15));
		cv.buildExperience(new WorkExperience(), "'Fields Of Fame' project", LocalDate.of(2022,10,12),LocalDate.of(2022,11,12),"Turn-based Strategy Game\n" +
				"\n" +
				"How to run ?\n" +
				"\n" +
				"In the current version run the main file in the future will be an .exe file\n" +
				"\n" +
				"Currently only playing in 1280x720 resolution works correctly, it is possible to launch fullscreen, adjust to other resolutions soon");

		CV cvKacperGacek = cv.getResult();

		System.out.println(cvKacperGacek.toString());
		System.out.println(cvKacperGacek.getPerson().getName());




	}



}
