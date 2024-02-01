package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.Models.CV;
import com.Herukles.CVBuilder.CV.Models.CVInsertValues;
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
		director.constructCV(concreteBuilder);
		CV cvKacper = concreteBuilder.getResult();
		CVInsertValues insertValues = context.getBean(CVInsertValues.class, cvKacper);
		cvKacper.setPerson();

		System.out.println(cvKacper.toString());
	}

}
