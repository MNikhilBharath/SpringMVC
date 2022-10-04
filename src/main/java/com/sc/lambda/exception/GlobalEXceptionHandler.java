package com.sc.lambda.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sc.lambda.beans.ResponseMessage;


@RestControllerAdvice
public class GlobalEXceptionHandler {		

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleCustomerNotFoundException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setResponseMessage(ex.getMessage());
		rm.setStatusCode(404);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateIdException.class)
	public ResponseEntity<ResponseMessage> handleDuplicateIdException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setResponseMessage(ex.getMessage());
		rm.setStatusCode(409);
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.CONFLICT);
	}
	}	
