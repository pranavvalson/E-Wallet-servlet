package com.deloitte.app.exception;

public class InsufficientBalance extends RuntimeException {
	public InsufficientBalance(String msg) {
		super(msg);
	}

}
