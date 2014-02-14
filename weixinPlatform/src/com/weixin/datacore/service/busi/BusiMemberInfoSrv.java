/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiMemberInfo;

public interface BusiMemberInfoSrv extends ServiceSrv {

	public BusiMemberInfo addBusiMemberInfo(BusiMemberInfo busiMemberInfo);
	
	public void deleBusiMemberInfo(BusiMemberInfo busiMemberInfo);
	
	public void deleBusiMemberInfo(Long id);
	
	public void updateBusiMemberInfo(BusiMemberInfo busiMemberInfo);
	
	public void saveBatchBusiMemberInfo(List<BusiMemberInfo> busiMemberInfoLs);
	
	public PageInfo<BusiMemberInfo> findBusiMemberInfoList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiMemberInfo> findBusiMemberInfoList(Object[] params, int pageNo, int pageSize);
	
	public BusiMemberInfo getBusiMemberInfo(Long id);
}
