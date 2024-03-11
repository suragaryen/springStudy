package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//비즈니스 로직에 @Component 대신 사용 가능
//@Component
//2. @Component 추가  
public class BusinessCalculationService {
	
	 //@Autowired
	 //필드를 통한 의존성 주입 : 필드 주입은 단위 테스트를 어렵게 만들고 느슨한 결합을 유지하기 어려워서 일반적으로 권장되지 않습니다. 
	 //private DataService dataService;

	DataService dataService;

	//1.생성자 주입을 사용한 의존성 주입. 
	
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
		
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
		
	
}
