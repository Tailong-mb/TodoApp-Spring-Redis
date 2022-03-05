package com.tailong.javatodolist;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@EnableWebMvc
@EnableRedisDocumentRepositories(basePackages = "com.tailong.javatodolist.*")
public class JavaTodolistApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
				.allowedMethods("*");
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaTodolistApplication.class, args);
	}

}
