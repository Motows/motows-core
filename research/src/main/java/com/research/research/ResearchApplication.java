package com.research.research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class ResearchApplication extends SpringBootServletInitializer {

	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ResearchApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(ResearchApplication.class, args);

	}

}
