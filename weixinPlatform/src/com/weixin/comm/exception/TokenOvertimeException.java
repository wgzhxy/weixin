/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.exception;

/**
 * token工具类异常
 * @author Wang.g.z
 *
 */
public class TokenOvertimeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8979815760619079948L;

	public TokenOvertimeException(String message) {
		super(message);
	}
	
	public TokenOvertimeException() {
		super();
	}
}
