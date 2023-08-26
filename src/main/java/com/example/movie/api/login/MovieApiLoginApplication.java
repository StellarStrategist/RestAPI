package com.example.movie.api.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovieApiLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiLoginApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			@CrossOrigin(origins = "*", allowedHeaders = "*")
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}
