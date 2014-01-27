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
import com.weixin.datacore.domain.weixin.dao.WeixinUserDao;
import com.weixin.datacore.domain.weixin.model.WeixinUser;
import com.weixin.datacore.service.weixin.WeixinUserSrv;
import com.weixin.comm.PageInfo;

@Service("weixinUserSrv")
public class WeixinUserSrvImpl extends ServiceSrvImpl implements WeixinUserSrv {

	@Override
	public WeixinUser addWeixinUser(WeixinUser weixinUser) {
		// TODO Auto-generated method stub
		return (WeixinUser)weixinUserDao.save(weixinUser);
	}

	@Override
	public void deleWeixinUser(WeixinUser weixinUser) {
		// TODO Auto-generated method stub
		weixinUserDao.delete(weixinUser);
	}

	@Override
	public void deleWeixinUser(Long id) {
		// TODO Auto-generated method stub
		weixinUserDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinUser(WeixinUser weixinUser) {
		// TODO Auto-generated method stub
		weixinUserDao.saveOrUpdate(weixinUser);
	}
	
	@Override
	public void saveBatchWeixinUser(List<WeixinUser> weixinUserLs) {
		// TODO Auto-generated method stub
		weixinUserDao.addBacth(weixinUserLs);
	}
	
	public PageInfo<WeixinUser> findWeixinUserList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinUser> findWeixinUserList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinUser getWeixinUser(Long id) {
		return weixinUserDao.get(id);
	}
	
	@Resource(name="weixinUserDao")
	private WeixinUserDao weixinUserDao;
}
