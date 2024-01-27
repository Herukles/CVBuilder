package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.ResumeData.CV;
import com.Herukles.CVBuilder.CV.ResumeData.CVInsertValues;
import org.springframework.beans.factory.annotation.Autowired;
import com.Herukles.CVBuilder.CV.ResumeData.*;
import org.apache.catalina.core.ApplicationContext;
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


		System.out.println(cvKacper.toString());
	}

}
