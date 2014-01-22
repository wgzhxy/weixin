package com.weixin.comm.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 重载验证事件
 * 
 * @author Liang Dong
 * @createDate 2013-7-31
 */
public class ReloadAuthenticationEvent extends ApplicationEvent {

	public ReloadAuthenticationEvent(Object source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3554299534499088198L;

}
