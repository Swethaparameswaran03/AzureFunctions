package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "User not found" , value = HttpStatus.NO_CONTENT)
public class UserNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNullException(String message)
	{
		super(message);
	}

}
