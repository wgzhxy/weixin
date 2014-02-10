/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinArticlesDao;
import com.weixin.datacore.domain.weixin.model.WeixinArticles;
import com.weixin.datacore.service.weixin.WeixinArticlesSrv;

@Service("weixinArticlesSrv")
public class WeixinArticlesSrvImpl extends ServiceSrvImpl implements WeixinArticlesSrv {

	@Override
	public WeixinArticles addWeixinArticles(WeixinArticles weixinArticles) {
		// TODO Auto-generated method stub
		return (WeixinArticles)weixinArticlesDao.save(weixinArticles);
	}

	@Override
	public void deleWeixinArticles(WeixinArticles weixinArticles) {
		// TODO Auto-generated method stub
		weixinArticlesDao.delete(weixinArticles);
	}

	@Override
	public void deleWeixinArticles(Long id) {
		// TODO Auto-generated method stub
		weixinArticlesDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinArticles(WeixinArticles weixinArticles) {
		// TODO Auto-generated method stub
		weixinArticlesDao.saveOrUpdate(weixinArticles);
	}
	
	@Override
	public void saveBatchWeixinArticles(List<WeixinArticles> weixinArticlesLs) {
		// TODO Auto-generated method stub
		weixinArticlesDao.addBacth(weixinArticlesLs);
	}
	
	public PageInfo<WeixinArticles> findWeixinArticlesList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinArticles> findWeixinArticlesList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinArticles getWeixinArticles(Long id) {
		return weixinArticlesDao.get(id);
	}
	
	@Resource(name="weixinArticlesDao")
	private WeixinArticlesDao weixinArticlesDao;
}
