package com.geektechnique.colorvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geektechnique.colorvote.model.ColorDataBase;
import com.geektechnique.colorvote.model.PersonDataBase;
@SpringBootApplication
public class CrashCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrashCourseApplication.class, args);
		
		PersonDataBase DB = new PersonDataBase();
		ColorDataBase DB2 = new ColorDataBase(); 
		
		//DB2.testCreateUserRecord("norman101");
		

	}

}
