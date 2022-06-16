package com.imed.imobiliaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ImobiliariaNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ImobiliariaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ImobiliariaNotFoundException ex) {
		return ex.getMessage();
	}
}