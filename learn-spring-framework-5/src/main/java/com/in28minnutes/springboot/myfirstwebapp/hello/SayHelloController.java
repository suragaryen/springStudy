package com.in28minnutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



//1. 이 객체가 Spring Bean이라는 것을 알려줘야한다 
@Controller
public class SayHelloController {
	//"say-hello" => Hello! what are you learning today?"
	
	//say-hello
	// http://localhost:8080/say-hello
	@RequestMapping("say-hello")
	@ResponseBody //이 메시지가 리턴한 것 그대로 브라우저에 리턴  
	public String sayHello() {
		return "Hello! what are you learning today?";
	}
	
	//say-hello
	// http://localhost:8080/say-hello
	@RequestMapping("say-hello-html")
	@ResponseBody //이 메시지가 리턴한 것 그대로 브라우저에 리턴
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	//
	//"say-hello-jsp"=> sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
