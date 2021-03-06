package com.example.My.App8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyApp8Application {

	public static void main(String[] args) {
		SpringApplication.run(MyApp8Application.class, args);
		System.out.println("My App 8 now started");
	}

}
