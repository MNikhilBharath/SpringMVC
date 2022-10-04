package com.sc.lambda.exception;

public class CustomerNotFoundException extends Exception {
	
	private String msg;
	
	public CustomerNotFoundException(String msg) {
		this.msg=msg;
		
	}
	@Override
	public String getMessage() {
		return this.msg;
	}

}
