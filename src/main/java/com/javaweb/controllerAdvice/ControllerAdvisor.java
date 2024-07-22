package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorReponseDTO;

import customException.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest ws) {
		ErrorReponseDTO errResponse = new ErrorReponseDTO();
		errResponse.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("So nguyen lam sao chia ...");
		errResponse.setDetails(details);
		return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest ws) {
		ErrorReponseDTO errResponse = new ErrorReponseDTO();
		errResponse.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("name or number error ...");
		errResponse.setDetails(details);
		return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
	}
}
