package com.sc.lambda.beans;

public class ResponseMessage {
	
	
	private String responseMessage;
	private Integer statusCode;
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
