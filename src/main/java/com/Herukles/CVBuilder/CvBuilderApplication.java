package com.Herukles.CVBuilder;

import com.Herukles.CVBuilder.CV.Models.CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CvBuilderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CvBuilderApplication.class, args);



	}
}
