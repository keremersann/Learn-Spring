package com.in28minutes.learnspringframework.examples.f1;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency {

	public void getReady() {
		System.out.println("Getting Ready for SomeClass");
	}

}
