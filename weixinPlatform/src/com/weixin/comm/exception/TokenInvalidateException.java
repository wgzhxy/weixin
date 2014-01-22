package com.weixin.comm.exception;

public class TokenInvalidateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2259680554815736117L;

	public TokenInvalidateException(String message) {
		super(message);
	}
	
	public TokenInvalidateException() {
		super();
	}

}
