package com.kerem.learnspringaop;

import com.kerem.learnspringaop.business.BusinessService;
import com.kerem.learnspringaop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

	private BusinessService businessService;
	private BusinessService2 businessService2;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public LearnSpringAopApplication(BusinessService businessService, BusinessService2 businessService2){
		this.businessService = businessService;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value returned is {}", this.businessService.getTheMaximumNumber());
		logger.info("Value returned is {}", this.businessService2.getTheMaximumNumber2());
	}
}
