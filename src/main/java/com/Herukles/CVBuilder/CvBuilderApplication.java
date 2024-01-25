package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.ResumeData.CV;
import com.Herukles.CVBuilder.CV.ResumeData.CVInsertValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CvBuilderApplication {

	private final CVConcreteBuilder concreteBuilder;
	private final CVDirector director;
	private final CVInsertValues insertValues;

	@Autowired
	public CvBuilderApplication(CVConcreteBuilder concreteBuilder, CVDirector director, CVInsertValues insertValues) {
		this.concreteBuilder = concreteBuilder;
		this.director = director;
		this.insertValues = insertValues;
	}

	public static void main(String[] args) {
		SpringApplication.run(CvBuilderApplication.class, args);
	}

	public void run() {
		director.constructCV(concreteBuilder);
		CV cvKacper = concreteBuilder.getResult();
		insertValues.insertPersonValues(cvKacper.getPerson(),"Kacper", "Gacke", 23,LocalDate.of(1999,12,15),"Krapkowice");
		insertValues.insertAboutMeValues(cvKacper.getAboutMe(), "Hello World!","engineer");
		insertValues.insertEducationValues(cvKacper.getEducation(),"Politechnika Opolska", LocalDate.of(2020,10,1),null);

		System.out.println(cvKacper.toString());
	}
}
