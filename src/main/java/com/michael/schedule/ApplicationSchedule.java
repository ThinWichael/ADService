package com.michael.schedule;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.michael.service.impl.AdServiceImpl;

@Configuration
@EnableScheduling
public class ApplicationSchedule {

	private static Logger logger = Logger.getLogger(ApplicationSchedule.class);
	
	@Autowired
	AdServiceImpl adServiceImpl;
	
	public ApplicationSchedule() {
		// TODO Auto-generated constructor stub
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("~~~~~~~~doSomethingAfterStartup Start ~~~~~~~~");
		adServiceImpl.getAdPoolCache();
	}
	
}
