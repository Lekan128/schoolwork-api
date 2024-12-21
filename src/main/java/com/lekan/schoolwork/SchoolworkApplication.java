package com.lekan.schoolwork;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEntityViews("com.lekan.schoolwork")
public class SchoolworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolworkApplication.class, args);
	}

}
