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
import com.weixin.datacore.domain.weixin.dao.WeixinFocusUserDao;
import com.weixin.datacore.domain.weixin.model.WeixinFocusUser;
import com.weixin.datacore.service.weixin.WeixinFocusUserSrv;
import com.weixin.comm.PageInfo;

@Service("weixinFocusUserSrv")
public class WeixinFocusUserSrvImpl extends ServiceSrvImpl implements WeixinFocusUserSrv {

	@Override
	public WeixinFocusUser addWeixinFocusUser(WeixinFocusUser weixinFocusUser) {
		// TODO Auto-generated method stub
		return (WeixinFocusUser)weixinFocusUserDao.save(weixinFocusUser);
	}

	@Override
	public void deleWeixinFocusUser(WeixinFocusUser weixinFocusUser) {
		// TODO Auto-generated method stub
		weixinFocusUserDao.delete(weixinFocusUser);
	}

	@Override
	public void deleWeixinFocusUser(Long id) {
		// TODO Auto-generated method stub
		weixinFocusUserDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinFocusUser(WeixinFocusUser weixinFocusUser) {
		// TODO Auto-generated method stub
		weixinFocusUserDao.saveOrUpdate(weixinFocusUser);
	}
	
	@Override
	public void saveBatchWeixinFocusUser(List<WeixinFocusUser> weixinFocusUserLs) {
		// TODO Auto-generated method stub
		weixinFocusUserDao.addBacth(weixinFocusUserLs);
	}
	
	public PageInfo<WeixinFocusUser> findWeixinFocusUserList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinFocusUser> findWeixinFocusUserList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinFocusUser getWeixinFocusUser(Long id) {
		return weixinFocusUserDao.get(id);
	}
	
	@Resource(name="weixinFocusUserDao")
	private WeixinFocusUserDao weixinFocusUserDao;
}
