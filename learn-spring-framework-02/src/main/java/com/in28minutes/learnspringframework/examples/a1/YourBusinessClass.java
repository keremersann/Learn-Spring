package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YourBusinessClass {
	
	Dependency1 dependency1;
	Dependency2 dependency2;
	
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		System.out.println("Dependency Injection with Ctor");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Dependency Injection with Setters - Dependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Dependency Injection with Setters - Dependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using: " + dependency1 + " And " + dependency2;
	}
}
