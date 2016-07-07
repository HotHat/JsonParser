package com.lyhux.jsonparse;


public class JsonParseException extends Exception {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JsonParseException(String msg) {
		super(msg);
	}
	public JsonParseException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
