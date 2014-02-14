/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.ArrayList;
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
		
		String hql = "from WeixinArticles c where 1=1 ";
		String hqlCount = "select count(c.id) from WeixinArticles c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("title".equals(enity.getKey())) {
				where.append(" and c.title like ?");
				values.add("%" + enity.getValue() + "%");
			}
			
			if("picType".equals(enity.getKey())) {
				where.append(" and c.picType=?");
				values.add(Integer.parseInt(enity.getValue().toString()));
			}
		}
		return weixinArticlesDao.findPageInfoByQuery(pageNo, pageSize, hql + where.toString() + orderBy, hqlCount + where.toString(), values.toArray());
	}

	
	public PageInfo<WeixinArticles> findWeixinArticlesList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	@Override
	public WeixinArticles getWeixinArticles(Map<String, Object> params) {
		String hql = "from WeixinArticles c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("title".equals(enity.getKey())) {
				where.append(" and c.title=?");
				values.add(enity.getValue());
			}
		}
		List<WeixinArticles> list=weixinArticlesDao.loadByPagenation(hql+where.toString()+orderBy,1,1, values.toArray());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public WeixinArticles getWeixinArticles(Long id) {
		return weixinArticlesDao.get(id);
	}
	
	@Resource(name="weixinArticlesDao")
	private WeixinArticlesDao weixinArticlesDao;
}
