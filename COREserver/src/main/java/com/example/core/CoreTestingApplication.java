package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
//Class level Cross Origin declaration
//@CrossOrigin(origins = "http://localhost:9090")
//@CrossOrigin(origins = "*")
public class CoreTestingApplication {

	//Method level Cross Origin declaration
	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping("/access")
	public String greeting(){
		return "Welcome to our Website";
	}

	//Global level Cross Origin declaration
	@Bean
	public WebMvcConfigurer configurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:9090");
			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(CoreTestingApplication.class, args);
	}
}
