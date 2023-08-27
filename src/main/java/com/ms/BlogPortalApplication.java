package com.ms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class BlogPortalApplication {
	private static final Logger logger = LogManager.getLogger(BlogPortalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogPortalApplication.class, args);
		
		logger.info("in main class");
		logger.info("info logging is printed");
		logger.debug("logger debud is worked");
		logger.info("logger warn is worked");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
