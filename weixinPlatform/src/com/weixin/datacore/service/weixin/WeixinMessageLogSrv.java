/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.comm.PageInfo;

public interface WeixinMessageLogSrv extends ServiceSrv {

	public WeixinMessageLog addWeixinMessageLog(WeixinMessageLog weixinMessageLog);
	
	public void deleWeixinMessageLog(WeixinMessageLog weixinMessageLog);
	
	public void deleWeixinMessageLog(Long id);
	
	public void updateWeixinMessageLog(WeixinMessageLog weixinMessageLog);
	
	public void saveBatchWeixinMessageLog(List<WeixinMessageLog> weixinMessageLogLs);
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Object[] params, int pageNo, int pageSize);
	
	public WeixinMessageLog getWeixinMessageLog(Long id);
}
