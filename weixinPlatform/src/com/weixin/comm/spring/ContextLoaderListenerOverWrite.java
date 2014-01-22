/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.spring;

import javax.servlet.ServletContextEvent;
import org.springframework.web.context.ContextLoaderListener;

public class ContextLoaderListenerOverWrite extends ContextLoaderListener {
	
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
	}
}
