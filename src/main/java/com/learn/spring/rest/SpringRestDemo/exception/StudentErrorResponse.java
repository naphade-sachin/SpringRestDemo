package com.learn.spring.rest.SpringRestDemo.exception;

public class StudentErrorResponse {
	private int http_status;
	private String message;
	private long timeStamp;

	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentErrorResponse(int http_status, String message, long timeStamp) {
		super();
		this.http_status = http_status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getHttp_status() {
		return http_status;
	}

	public void setHttp_status(int http_status) {
		this.http_status = http_status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
