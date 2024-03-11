package com.in28minnutes.springboot.myfirstwebapp.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



//Spring MVC Front Controller - Dispatcher Servlet

// 디스패처 서블릿은 클라이언트로부터 들어오는 모든 HTTP 요청을 받아서 적절한 핸들러(Controller)에게 요청을 전달하고,
// 해당 요청을 처리할 뷰(View)를 결정한다.
// 애플리케이션에서 중앙 집중식으로 요청을 관리하고 분배하는 역할을 수행합니다.

@Controller
@SessionAttributes("name")
public class WelcomeController {
	/*
	private AuthenticationService authenticationService;
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	//private Logger logger = LoggerFactory.getLogger(getClass());
	//http://localhost:8080/login?name=soo
	//Model
	 
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //사용자 정보를 Security에서 받아올 것  
		
		return authentication.getName();
	}
	
	/*
	@RequestMapping(value = "login",method = RequestMethod.POST)
	//login?nameRanga
	//같은 페이지로 매핑돼도 GET 과 POST 에 따라서 다른 뷰페이지를 보여줄수 있다 
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password
									, ModelMap model) {
		
		if(authenticationService.authenticatte(name, password)) {
			
		
		model.put("name", name);
		model.put("password", password);
		
		//Authentication
		//name - in28minutes
		//password - 
		
		return "welcome";
		
		}
		System.out.println(authenticationService.authenticatte(name, password));
		model.put("errorMessage", "Invalid Credentials! Please try again");
		return "login";
		
	}
	
	
	
	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
		model.put("name", name);
		logger.debug("Request param is{}",name);
		logger.info("I want this printed at info level",name);
		logger.warn("I want this printed at warn level");
		return "login";
	}
	*/
}
