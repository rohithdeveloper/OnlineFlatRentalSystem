package com.capgemini.frs.exception;

@SuppressWarnings("serial")
public class TenantNotFoundException extends Exception{
	
	public TenantNotFoundException(String string) {
		super(string);
	}

}
