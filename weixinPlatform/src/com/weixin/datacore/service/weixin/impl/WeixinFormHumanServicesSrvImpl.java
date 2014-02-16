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
import com.weixin.datacore.domain.weixin.dao.WeixinFormHumanServicesDao;
import com.weixin.datacore.domain.weixin.model.WeixinFormHumanServices;
import com.weixin.datacore.service.weixin.WeixinFormHumanServicesSrv;

@Service("weixinFormHumanServicesSrv")
public class WeixinFormHumanServicesSrvImpl extends ServiceSrvImpl implements WeixinFormHumanServicesSrv {

	@Override
	public WeixinFormHumanServices addWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices) {
		// TODO Auto-generated method stub
		return (WeixinFormHumanServices)weixinFormHumanServicesDao.save(weixinFormHumanServices);
	}

	@Override
	public void deleWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices) {
		// TODO Auto-generated method stub
		weixinFormHumanServicesDao.delete(weixinFormHumanServices);
	}

	@Override
	public void deleWeixinFormHumanServices(Long id) {
		// TODO Auto-generated method stub
		weixinFormHumanServicesDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinFormHumanServices(WeixinFormHumanServices weixinFormHumanServices) {
		// TODO Auto-generated method stub
		weixinFormHumanServicesDao.saveOrUpdate(weixinFormHumanServices);
	}
	
	@Override
	public void saveBatchWeixinFormHumanServices(List<WeixinFormHumanServices> weixinFormHumanServicesLs) {
		// TODO Auto-generated method stub
		weixinFormHumanServicesDao.addBacth(weixinFormHumanServicesLs);
	}
	
	public PageInfo<WeixinFormHumanServices> findWeixinFormHumanServicesList(Map<String, Object> params, int pageNo, int pageSize) {
		
		String hql = "from WeixinFormHumanServices c where 1=1 ";
		String hqlCount = "select count(c.id) from WeixinFormHumanServices c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("userName".equals(enity.getKey())) {
				where.append(" and c.userName like ?");
				values.add("%" + enity.getValue() + "%");
			}
			
			if("state".equals(enity.getKey())) {
				where.append(" and c.state=?");
				values.add(Integer.parseInt(enity.getValue().toString()));
			}
		}
		return weixinFormHumanServicesDao.findPageInfoByQuery(pageNo, pageSize, hql + where.toString() + orderBy, hqlCount + where.toString(), values.toArray());
	}

	
	public PageInfo<WeixinFormHumanServices> findWeixinFormHumanServicesList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	@Override
	public WeixinFormHumanServices getWeixinFormHumanServices(Map<String, Object> params) {
		String hql = "from WeixinFormHumanServices c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("userName".equals(enity.getKey())) {
				where.append(" and c.userName=?");
				values.add(enity.getValue());
			}
		}
		List<WeixinFormHumanServices> list=weixinFormHumanServicesDao.loadByPagenation(hql+where.toString()+orderBy,1,1, values.toArray());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public WeixinFormHumanServices getWeixinFormHumanServices(Long id) {
		// TODO Auto-generated method stub
		return weixinFormHumanServicesDao.get(id);
	}
	
	@Resource(name="weixinFormHumanServicesDao")
	private WeixinFormHumanServicesDao weixinFormHumanServicesDao;
}