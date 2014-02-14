/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.busi;

import java.util.List;
import java.util.Map;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.ServiceSrv;
import com.weixin.datacore.domain.busi.model.BusiArtificialService;

public interface BusiArtificialServiceSrv extends ServiceSrv {

	public BusiArtificialService addBusiArtificialService(BusiArtificialService busiArtificialService);
	
	public void deleBusiArtificialService(BusiArtificialService busiArtificialService);
	
	public void deleBusiArtificialService(Long id);
	
	public void updateBusiArtificialService(BusiArtificialService busiArtificialService);
	
	public void saveBatchBusiArtificialService(List<BusiArtificialService> busiArtificialServiceLs);
	
	public PageInfo<BusiArtificialService> findBusiArtificialServiceList(Map<String, Object> params, int pageNo, int pageSize);
	
	public PageInfo<BusiArtificialService> findBusiArtificialServiceList(Object[] params, int pageNo, int pageSize);
	
	public BusiArtificialService getBusiArtificialService(Long id);
}
