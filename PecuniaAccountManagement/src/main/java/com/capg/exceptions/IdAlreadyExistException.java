package com.capg.exceptions;

@SuppressWarnings("serial")
public class IdAlreadyExistException extends Exception {
	public  IdAlreadyExistException(String errorMsg){
		super(errorMsg);
	}
}
