package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.CVInsertValues;
import com.Herukles.CVBuilder.CV.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
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
		director.setHowManyEducationFields(2);
		director.setHowManyExperienceFields(2);
		director.constructCV(concreteBuilder);
		CV cvKacper = concreteBuilder.getResult();
		CVInsertValues insertValues = context.getBean(CVInsertValues.class, cvKacper);
		insertValues.insertPersonValues(cvKacper.getPerson(),"Kacper","Gacek",24,LocalDate.of(1999,12,1),"Krapkowice");
		insertValues.insertAboutMeValues(cvKacper.getAboutMe(),"hello world","engineer?");
		insertValues.insertEducationValues(cvKacper.getEducationList().get(0),"polibuda",LocalDate.of(1999,12,1),LocalDate.of(1999,12,1));
		insertValues.insertEducationValues(cvKacper.getEducationList().get(1),"polibuda",LocalDate.of(1999,12,1),LocalDate.of(1999,12,1));
		insertValues.insertExperienceValues(cvKacper.getWorkExperienceList().get(0),"CompanyX","CompanyXDesc",LocalDate.of(1999,12,1),LocalDate.of(1999,12,1));
		insertValues.insertExperienceValues(cvKacper.getWorkExperienceList().get(1),"CompanyY","CompanyYDesc",LocalDate.of(1999,12,1),LocalDate.of(1999,12,1));
		insertValues.insertContactMeValues(cvKacper.getContactMe(), "123456789","asdf@asdf.com","github.com/Herukles");
		System.out.println(cvKacper.toString());
	}

}
