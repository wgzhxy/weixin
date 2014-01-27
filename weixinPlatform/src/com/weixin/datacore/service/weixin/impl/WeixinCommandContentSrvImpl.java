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
import com.weixin.datacore.domain.weixin.dao.WeixinCommandContentDao;
import com.weixin.datacore.domain.weixin.model.WeixinCommandContent;
import com.weixin.datacore.service.weixin.WeixinCommandContentSrv;
import com.weixin.comm.PageInfo;

@Service("weixinCommandContentSrv")
public class WeixinCommandContentSrvImpl extends ServiceSrvImpl implements WeixinCommandContentSrv {

	@Override
	public WeixinCommandContent addWeixinCommandContent(WeixinCommandContent weixinCommandContent) {
		// TODO Auto-generated method stub
		return (WeixinCommandContent)weixinCommandContentDao.save(weixinCommandContent);
	}

	@Override
	public void deleWeixinCommandContent(WeixinCommandContent weixinCommandContent) {
		// TODO Auto-generated method stub
		weixinCommandContentDao.delete(weixinCommandContent);
	}

	@Override
	public void deleWeixinCommandContent(Long id) {
		// TODO Auto-generated method stub
		weixinCommandContentDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinCommandContent(WeixinCommandContent weixinCommandContent) {
		// TODO Auto-generated method stub
		weixinCommandContentDao.saveOrUpdate(weixinCommandContent);
	}
	
	@Override
	public void saveBatchWeixinCommandContent(List<WeixinCommandContent> weixinCommandContentLs) {
		// TODO Auto-generated method stub
		weixinCommandContentDao.addBacth(weixinCommandContentLs);
	}
	
	public PageInfo<WeixinCommandContent> findWeixinCommandContentList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinCommandContent> findWeixinCommandContentList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinCommandContent getWeixinCommandContent(Long id) {
		return weixinCommandContentDao.get(id);
	}
	
	@Resource(name="weixinCommandContentDao")
	private WeixinCommandContentDao weixinCommandContentDao;
}
