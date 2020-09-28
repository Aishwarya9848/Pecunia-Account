package com.capg.exceptions;


@SuppressWarnings("serial")
public class IdNotFoundException extends Exception{
	public IdNotFoundException(String errorMsg){
		super(errorMsg);
	}
}
