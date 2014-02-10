/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinPicture;
import com.weixin.comm.PageInfo;

public interface WeixinPictureSrv extends ServiceSrv {

	public WeixinPicture addWeixinMenuItem(WeixinPicture weixinPicture);
	
	public void deleWeixinPicture(WeixinPicture weixinPicture);
	
	public void deleWeixinPicture(Long id);
	
	public void updateWeixinPicture(WeixinPicture weixinPicture);
	
	public void saveBatchWeixinPicture(List<WeixinPicture> weixinPictureLs);
	
	public PageInfo<WeixinPicture> findWeixinPictureList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinPicture> findWeixinPictureList(Object[] params, int pageNo, int pageSize);
	
	public WeixinPicture getWeixinPicture(Long id);
}
