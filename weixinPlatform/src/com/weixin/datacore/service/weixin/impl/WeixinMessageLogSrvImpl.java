/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinMessageLogDao;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.datacore.service.weixin.WeixinMessageLogSrv;
import com.weixin.comm.PageInfo;

@Service("weixinMessageLogSrv")
public class WeixinMessageLogSrvImpl extends ServiceSrvImpl implements WeixinMessageLogSrv {

	@Override
	public WeixinMessageLog addWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		return (WeixinMessageLog)weixinMessageLogDao.save(weixinMessageLog);
	}

	@Override
	public void deleWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.delete(weixinMessageLog);
	}

	@Override
	public void deleWeixinMessageLog(Long id) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.saveOrUpdate(weixinMessageLog);
	}
	
	@Override
	public void saveBatchWeixinMessageLog(List<WeixinMessageLog> weixinMessageLogLs) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.addBacth(weixinMessageLogLs);
	}
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinMessageLog getWeixinMessageLog(Long id) {
		return weixinMessageLogDao.get(id);
	}
	
	@Resource(name="weixinMessageLogDao")
	private WeixinMessageLogDao weixinMessageLogDao;
}
