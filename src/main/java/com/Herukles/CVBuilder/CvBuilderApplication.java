package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.CVInsertValues;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class CvBuilderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CvBuilderApplication.class, args);
		CVConcreteBuilder concreteBuilder = context.getBean(CVConcreteBuilder.class);
		CVDirector director = context.getBean(CVDirector.class);
		director.constructCV(concreteBuilder);
		CV cvKacper = concreteBuilder.getResult();
		CVInsertValues insertValues = context.getBean(CVInsertValues.class, cvKacper);

		insertValues.insertPersonValues(cvKacper.getPerson(),"Kacper", "Gacke", 23,LocalDate.of(1999,12,15),"Krapkowice");
		insertValues.insertAboutMeValues(cvKacper.getAboutMe(), "Hello World!","engineer");
		insertValues.insertEducationValues(cvKacper.getEducation(),"Politechnika Opolska", LocalDate.of(2020,10,1),null);
		insertValues.insertExperienceValues(cvKacper.getWorkExperience(),"Fields Of Fame","Fields Of Fame is a turn- based strategy game developed in Python& Pygame by 4 students.",LocalDate.of(2022,12,1),LocalDate.of(2023,2,2));
		insertValues.insertExperienceValues(cvKacper.getWorkExperience(),"asdf", "asdf",LocalDate.of(2022,12,1),LocalDate.of(2023,2,2));
		insertValues.insertContactMeValues(cvKacper.getContactMe(),"577237201", "kacper.gacek@op.pl","linkedin.com/me/kacper-gacek");

		System.out.println(cvKacper.toString());
	}

}
