package com.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.springsecurity.controller")//optional 
public class SpringsecurityprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityprojectApplication.class, args);
	}

}
