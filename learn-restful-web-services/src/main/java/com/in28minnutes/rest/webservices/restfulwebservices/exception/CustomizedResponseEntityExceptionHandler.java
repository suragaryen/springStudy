package com.in28minnutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minnutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice //이 클래스를 모든 컨트롤러에 적용, 이 프로젝트에 정의된 모든 컨트롤러, 테스트 컨트롤러를 대상으
//ExceptionHandler를 선언하는 클래스를 대상 
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	 
		@ExceptionHandler(Exception.class) //어떤 예외를 처리할것인지 정의 (Exception.class) = 발생한 모든 예외를 정의 
		public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
			ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
					ex.getMessage(), request.getDescription(false));
			
			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		// JSON 응답구조를 원하는데로 설정.
		// testerJson으로 찍어볼 것
		
		
		//유저가 없을때 500에러가 아닌 404에러 돌려받기. 
		@ExceptionHandler(UserNotFoundException.class)
		public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
			ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
					ex.getMessage(), request.getDescription(false));
			
			return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		}
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
					"Total Error : "+ex.getErrorCount()+"First Error:" +ex.getFieldError().getDefaultMessage(), request.getDescription(false));
			
			return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
			
		}
}
