/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin;

import java.util.List;
import java.util.Map;
import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.weixin.model.WeixinFormReservation;

public interface WeixinFormReservationSrv extends ServiceSrv {

	public WeixinFormReservation addWeixinFormReservation(WeixinFormReservation weixinFormReservation);
	
	public void deleWeixinFormReservation(WeixinFormReservation weixinFormReservation);
	
	public void deleWeixinFormReservation(Long id);
	
	public void updateWeixinFormReservation(WeixinFormReservation weixinFormReservation);
	
	public void saveBatchWeixinFormReservation(List<WeixinFormReservation> weixinFormReservationLs);
	
	public PageInfo<WeixinFormReservation> findWeixinFormReservationList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<WeixinFormReservation> findWeixinFormReservationList(Object[] params, int pageNo, int pageSize);
	
	public WeixinFormReservation getWeixinFormReservation(Long id);
	
	public WeixinFormReservation getWeixinFormReservation(Map<String,Object> params);
}
