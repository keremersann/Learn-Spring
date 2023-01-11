package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// "say-hello" => 'Hello! What are you learning today?'
	// http://localhost:8080/say-hello
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String SayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("This is my page title");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("This is the body of the html");
		sb.append("</body>");
		
		return sb.toString();
	}
	// /myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
