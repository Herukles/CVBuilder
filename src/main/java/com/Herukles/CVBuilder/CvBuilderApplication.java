package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.ResumeData.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CvBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvBuilderApplication.class, args);


		CVConcreteBuilder concreteBuilder = new CVConcreteBuilder();
		CVDirector director = new CVDirector();
		director.constructCV(concreteBuilder);
		CV cvKacper = concreteBuilder.getResult();
		CVInsertValues insertValues = new CVInsertValues(cvKacper);
		insertValues.insertPersonValues(cvKacper.getPerson(),"Kacper", null, 23,LocalDate.of(1999,12,15),"Krapkowice");
		insertValues.insertAboutMeValues(cvKacper.getAboutMe(), "Hello World!","engineer");
		insertValues.insertEducationValues(cvKacper.getEducation(),"Politechnika Opolska", LocalDate.of(2020,10,1),null);







	}



}
