package com.els.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class CorsConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
				.maxAge(6000);

	}

}
