package com.sc.lambda.exception;

public class DuplicateIdException extends Exception{// checked
	private final String msg;
	
	public DuplicateIdException(String msg) {
		this.msg=msg;
	}
	@Override
	public String getMessage() {
        return this.msg;
    }

	
}