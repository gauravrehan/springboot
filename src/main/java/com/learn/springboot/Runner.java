package com.learn.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * Either of the interfaces can be used to access some bean and start processing.
 * We can have as many CommandLineRunner or ApplicationRunners. we can do ordering using
 * @Order
 */
@Component
public class Runner implements CommandLineRunner, ApplicationRunner{

	static final Logger log = LoggerFactory.getLogger(Runner.class);
	@Autowired
	String info;
	
	@Autowired
	MyAppProperties myAppProperties;
	
	@Value("${myapp.serverIp}")
	String serverIp; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		log.info("### > info bean logged as " + info); 
		log.info("### > serverIp " + serverIp);
		log.info("### > name and description " + myAppProperties.getName() + " " + myAppProperties.getDescription());
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("### > info bean logged as " + info);
	}
	
	

}
