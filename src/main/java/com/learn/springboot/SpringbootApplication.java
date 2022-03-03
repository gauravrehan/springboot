package com.learn.springboot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringbootApplication {
	
	static org.slf4j.Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {
		/*
		 * bootstrap class
		 */
//		SpringApplication.run(ShortcutsApplication.class, args);
		SpringApplication app = new SpringApplication(SpringbootApplication.class);
		
//		by default the banner is loaded from /src/main/resources/banner.txt
//		app.setBanner((Environment environment, Class<?> sourceClass, PrintStream out) ->  out.print("\n\n\t This is my own banner! \n\n".toUpperCase()) );
//		app.run(args);
//		
		
		
		new SpringApplicationBuilder(SpringbootApplication.class)
		.listeners(new ApplicationListener<ApplicationEvent>() {
		
			@Override 
			public void onApplicationEvent(ApplicationEvent event)
			{
				logger.info("#### > " + event.getClass().getCanonicalName());
			}
		})
		.bannerMode(Banner.Mode.OFF)
//		if we have web related jars on class path and we want to not run the the app as web app then we
//		can tell spring that don't start the web context
		.web(WebApplicationType.NONE)
		.run(args);
	}

}
