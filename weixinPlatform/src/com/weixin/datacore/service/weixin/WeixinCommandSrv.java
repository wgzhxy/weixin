/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinCommand;
import com.weixin.comm.PageInfo;

public interface WeixinCommandSrv extends ServiceSrv {

	public WeixinCommand addWeixinCommand(WeixinCommand weixinCommand);
	
	public void deleWeixinCommand(WeixinCommand weixinCommand);
	
	public void deleWeixinCommand(Long id);
	
	public void updateWeixinCommand(WeixinCommand weixinCommand);
	
	public void saveBatchWeixinCommand(List<WeixinCommand> weixinCommandLs);
	
	public PageInfo<WeixinCommand> findWeixinCommandList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinCommand> findWeixinCommandList(Object[] params, int pageNo, int pageSize);
	
	public WeixinCommand getWeixinCommand(Long id);
	
	public WeixinCommand getWeixinCommand(Map<String, Object> params);
}
