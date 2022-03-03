package com.learn.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	String info()
	{
		return "Just a simple String Bean";
	}

}
