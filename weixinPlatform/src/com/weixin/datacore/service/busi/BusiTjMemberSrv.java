/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiTjMember;

public interface BusiTjMemberSrv extends ServiceSrv {

	public BusiTjMember addBusiTjMember(BusiTjMember busiTjMember);
	
	public void deleBusiTjMember(BusiTjMember busiTjMember);
	
	public void deleBusiTjMember(Long id);
	
	public void updateBusiTjMember(BusiTjMember busiTjMember);
	
	public void saveBatchBusiTjMember(List<BusiTjMember> busiTjMemberLs);
	
	public PageInfo<BusiTjMember> findBusiTjMemberList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiTjMember> findBusiTjMemberList(Object[] params, int pageNo, int pageSize);
	
	public BusiTjMember getBusiTjMember(Long id);
}
