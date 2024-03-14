package com.in28minnutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HellowWorldController {
	// /hello world
	
	private MessageSource msgSource;
	//메시지의 매개변수화나 국제화에 대한 지원을 통해 메시지를 처리  
	
	public HellowWorldController(MessageSource msgSource) {
		this.msgSource = msgSource;
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world") //get mapping은 생략가능 
	@RequestMapping(path = "/hello-world") 
	public String helloWorld() {
		return "Hello world";
	}
	
	@RequestMapping(path = "/hello-world-bean") 
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world"); //json 응답  
	}
	
	@RequestMapping(path = "/hello-world/path/variable/{name}") 
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hellow world, %s", name)); //json 응답  
	}
	
	@RequestMapping(path = "/hello-world-Internatlized") 
	public String helloWorldInternatlized() {
		
		Locale locale = LocaleContextHolder.getLocale();
		//현재 스레드와 연관된 로케일을 반환 
		//사용자는 요청과 함께 Accept 헤더를 감지하는데, 그다음 해당 헤더에 대한 로케일은 LocaleContextHolder.getLocale();에 의해 반환.
		return msgSource.getMessage("good.morning.message", null, "Default Msg", locale);
		//return "Hello world V2";
		
		//1: 메세지 저장
		//2: 이 값을 가져올 수 있는 코드 작성  
	}
	
}
