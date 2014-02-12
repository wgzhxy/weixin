/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.weixin.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.weixin.comm.PageInfo;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinPageInfoDao;
import com.weixin.datacore.domain.weixin.model.WeixinPageInfo;
import com.weixin.datacore.service.weixin.WeixinPageInfoSrv;

@Service("weixinPageInfoSrv")
public class WeixinPageInfoSrvImpl extends ServiceSrvImpl implements WeixinPageInfoSrv {

	@Override
	public WeixinPageInfo addWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		return (WeixinPageInfo)weixinPageInfoDao.save(weixinPageInfo);
	}

	@Override
	public void deleWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.delete(weixinPageInfo);
	}

	@Override
	public void deleWeixinPageInfo(Long id) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinPageInfo(WeixinPageInfo weixinPageInfo) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.saveOrUpdate(weixinPageInfo);
	}
	
	@Override
	public void saveBatchWeixinPageInfo(List<WeixinPageInfo> weixinPageInfoLs) {
		// TODO Auto-generated method stub
		weixinPageInfoDao.addBacth(weixinPageInfoLs);
	}
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Map<String, Object> params, int pageNo, int pageSize) {
		try{
			String hql = "from WeixinPageInfo c where 1=1 ";
			String hqlCount = "select count(c.id) from WeixinPageInfo c where 1=1 ";
			StringBuffer where = new StringBuffer();
			if(params != null) {
				for(Map.Entry<String, Object> entity : params.entrySet()) {
					if(StringUtils.equals("pageTitle", entity.getKey())) 
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
			return weixinPageInfoDao.findPageInfoByQuery(pageNo, pageSize, 
														  hql + where.toString() + orderBy, 
														  hqlCount.toString() + where.toString(), 
														  params);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PageInfo<WeixinPageInfo> findWeixinPageInfoList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinPageInfo getWeixinPageInfo(Long id) {
		return weixinPageInfoDao.get(id);
	}
	
	@Resource(name="weixinPageInfoDao")
	private WeixinPageInfoDao weixinPageInfoDao;
}
