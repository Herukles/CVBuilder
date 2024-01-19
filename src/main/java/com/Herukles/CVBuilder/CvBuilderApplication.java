package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Builders.CVConcreteBuilder;
import com.Herukles.CVBuilder.CV.Builders.CVDirector;
import com.Herukles.CVBuilder.CV.ResumeData.Person;
import com.Herukles.CVBuilder.CV.ResumeData.ResumeForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CvBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvBuilderApplication.class, args);

		CVConcreteBuilder builder = new CVConcreteBuilder();
		builder.buildPersonal(new Person());

		Person person = new Person();
		person.setName("Adam");
		person.setSurname("kowalski");
		person.setDateOfBorn("01-01-2010");
		person.setAge(13);
		ResumeForm resumeForm = new ResumeForm();
		resumeForm.setPerson(person);
		




	}



}
