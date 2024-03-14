package com.in28minnutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	//REST API 버전 관리
	//메소드가 업데이트 되었을 때 메소드를 고치는것보다는 버전으로 관리해주는게 좋음  
	
	// 브레이킹 체인지가 일어날 경우, API 버전 관리가 고려할 수 있는 솔루션 중 하나 
	
	//버전 관리법 
	//1. URL
	//2. Request Parameter
	//3. header
	//4. 미디어 유형 버전 관리  
	
	//URL 로 버전 관리  
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//Request Parameter
	@GetMapping(path="/person", params= "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person", params= "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//(Custom) headers versioning 
	//SAME-URL headers=[X-API-VERSION=1]
	//SAME-URL headers=[X-API-VERSION=2]
	
	//Request Parameter
	@GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//미디어 유형 버전 관리
	//Accept 헤더 또는 Accept-Language 헤더 기반
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json") //Accept 헤더로 전송된 값을 얻으려면 produces 사용.
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json") //Accept 헤더로 전송된 값을 얻으려면 produces 사용.
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	//versioning을 할 때 고려사항 
	
	//1. URL Pollution
	//URL을 사용하면 너무 많은 URL을 사용해서 URL pollution 발생
	//헤더 버전 관리와 미디어 유형 버전 관리에서는 동일한 URL을 사용하므로 URL Pollution의 양이 적음
	
	//2. HTTP 헤더의 오용  
	//HTTP 헤더는 버전 관리 용도로 사용해서는 안됌, 따라서 헤더 버전 관리와 미디어 유형 버전 관리는 HTTP 헤더를 오용하고 있는 것.
	
	//캐싱
	// 캐싱은 일반적으로 URL을 기반으로 수행되는데, 헤더 버전 관리와 미디어 유형 버전 관리의 경우 다른 버전을 사용한다. 하지만 두버전 모두 동일한 URL을 씀.
	// 헤더 버전 관리와 미디어 유형 버전 관리에서는 URL을 기반으로 캐싱을 할 수있는지  헤더 버전 관리와 미디어 유형 버전 관리에서는 URL을 기반으로 캐싱을 할 수 있는지 
	//캐싱을 수행하기 전에 헤더를 살펴봐야함 
	
	//브라우저에서 요청을 실행할 수 있는지
	//URL 버전관리와 요청 매개변수 버전 관리의 경우, 브라우저에서 간편하게 실행할 수 있다 하지만 헤더버전 관리와 미디어 유형 버전 관리에서는 차이가 일반적으로 명령줄 유틸리티를 갖고 있거나 
	// REST API 클라이언트를 사용해서 헤드를 기분으로 구분할 수있어야 함
	
	//API 문서
	//URL 버전 관리와 요청 매개변수 버전 관리에 대한 API 문서를 생성하기는 쉽지만 (URL이 다르기 때문) API 문서 생성 툴은 보통 헤더를 기준으로 구분하는 문서의 생성을
	// 지원하지 않을 수 있다. 이에 따라 헤더 버전 관리와 미디어 유형버전 관리에 대한 문서 생성이 까다로워 질수도 있음  
	
	//완벽한 솔루션은 없음. 
	
	
	
} 
