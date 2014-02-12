/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinPageClassDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageClass;
import com.weixin.datacore.service.weixin.WeixinPageClassSrv;

@Service("weixinPageClassSrv")
public class WeixinPageClassSrvImpl extends ServiceSrvImpl implements WeixinPageClassSrv {

	@Override
	public WeixinPageClass addWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		return (WeixinPageClass)weixinPageClassDao.save(weixinPageClass);
	}

	@Override
	public void deleWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		weixinPageClassDao.delete(weixinPageClass);
	}

	@Override
	public void deleWeixinPageClass(Long id) {
		// TODO Auto-generated method stub
		weixinPageClassDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinPageClass(WeixinPageClass weixinPageClass) {
		// TODO Auto-generated method stub
		weixinPageClassDao.update(weixinPageClass);
	}
	
	@Override
	public void saveBatchWeixinPageClass(List<WeixinPageClass> weixinPageClassLs) {
		// TODO Auto-generated method stub
		weixinPageClassDao.addBacth(weixinPageClassLs);
	}
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Map<String, Object> params, int pageNo, int pageSize) {
		try{
			String hql = "from WeixinPageClass c where 1=1 ";
			String hqlCount = "select count(c.id) from WeixinPageClass c where 1=1 ";
			StringBuffer where = new StringBuffer();
			if(params != null) {
				for(Map.Entry<String, Object> entity : params.entrySet()) {
					if(StringUtils.equals("className", entity.getKey())) 
					{
						where.append(" and c.").append(entity.getKey()).append(" like :").append(entity.getKey());
						params.put(entity.getKey(), "%" + entity.getValue() + "%");
					} else if(StringUtils.isNotEmpty(entity.getKey())) 
					{
						where.append(" and c.").append(entity.getKey()).append("= :").append(entity.getKey());
					}
				}
			}
			String orderBy = " order by c.updateTime desc"; 
			return weixinPageClassDao.findPageInfoByQuery(pageNo, pageSize, 
														  hql + where.toString() + orderBy, 
														  hqlCount.toString() + where.toString(), 
														  params);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PageInfo<WeixinPageClass> findWeixinPageClassList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	@SuppressWarnings("rawtypes")
	public WeixinPageClass getWeixinPageClass(String id) {
		String hql = "from WeixinPageClass c where 1=1 and c.id = :id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List ls = weixinPageClassDao.findPageByQuery(1, 1, hql, map);
		if(ls != null && ls.size() > 0) {
			return (WeixinPageClass)ls.get(0);
		}
		return null;
	}
	
	@Resource(name="weixinPageClassDao")
	private WeixinPageClassDao weixinPageClassDao;

	@Override
	public WeixinPageClass getWeixinPageClass(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleWeixinPageClass(String id) {
		// TODO Auto-generated method stub
		weixinPageClassDao.delete(this.getWeixinPageClass(id));
	}
}
