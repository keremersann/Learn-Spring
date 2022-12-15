package com.in28minutes.learnspringframework.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
public class BusinessService {
	private DataService dataService;

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {		
		this.dataService = dataService;
		System.out.println("Setter injection is completed");
	}
	
	public DataService getDataService() {
		return dataService;
	}
	
}
