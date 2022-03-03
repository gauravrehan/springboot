package com.learn.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
/*
 * To pass the arguments: 
 * gradlew bootJar -Dspring-boot.run.arguments="--enable args1 args2"
 * or jar it first using gradlew build and run
 * java -jar springboot-internals.jar --enable args1 args2
 */
@Component
public class MyComponent {

	static final Logger log = LoggerFactory.getLogger(MyComponent.class);

	@Autowired
	public MyComponent(ApplicationArguments args) {
		super();
		boolean enable = args.containsOption("enable");
		if (enable)
			log.info("## > You are enabled");
		
		List<String> listNonOptionArgs = args.getNonOptionArgs();
		log.info("## > extra args ...");

		{
			log.info(listNonOptionArgs.toString());
			listNonOptionArgs.forEach(file -> log.info(file));
		}
		
		Set<String> listOfOptionNames = args.getOptionNames();
		
		listOfOptionNames.forEach(log::info);
		
		
		
	}

}
