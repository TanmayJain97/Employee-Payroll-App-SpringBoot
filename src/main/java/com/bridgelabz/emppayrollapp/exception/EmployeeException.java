package com.bridgelabz.emppayrollapp.exception;

public class EmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3648569392765124987L;
	
	private int statusCode;
	private String errormsg;
	
	//Constructor
	public EmployeeException(int statusCode, String errormsg) {
		this.statusCode = statusCode;
		this.errormsg = errormsg;
	}

	//Getters n Setters
	
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the Error Messages
	 */
	public String getErrormsg() {
		return errormsg;
	}

	/**
	 * @param errormsg the Error Messages to set
	 */
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
}