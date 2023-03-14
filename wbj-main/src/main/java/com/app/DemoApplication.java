package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@Configuration
//	public class WebConfig implements WebMvcConfigurer {
//		 
//	    @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**")
//	            .allowedOrigins("http://localhost:3000")
//	            .allowedMethods("GET", "POST", "PUT", "DELETE")
//	            .allowedHeaders("*")
//	            .allowCredentials(true)
//	            .maxAge(3600);
//	    }
//	}

	
}
