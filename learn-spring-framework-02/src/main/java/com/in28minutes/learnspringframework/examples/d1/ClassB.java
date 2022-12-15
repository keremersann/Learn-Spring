package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClassB {
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Dependency is injected via constructor");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something!");
	}
}
