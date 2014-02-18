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
import com.weixin.datacore.domain.weixin.dao.WeixinFormReservationDao;
import com.weixin.datacore.domain.weixin.model.WeixinFormReservation;
import com.weixin.datacore.service.weixin.WeixinFormReservationSrv;

@Service("weixinFormReservationSrv")
public class WeixinFormReservationSrvImpl extends ServiceSrvImpl implements WeixinFormReservationSrv {

	@Override
	public WeixinFormReservation addWeixinFormReservation(WeixinFormReservation weixinFormReservation) {
		// TODO Auto-generated method stub
		return (WeixinFormReservation)weixinFormReservationDao.save(weixinFormReservation);
	}

	@Override
	public void deleWeixinFormReservation(WeixinFormReservation weixinFormReservation) {
		// TODO Auto-generated method stub
		weixinFormReservationDao.delete(weixinFormReservation);
	}

	@Override
	public void deleWeixinFormReservation(Long id) {
		// TODO Auto-generated method stub
		weixinFormReservationDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinFormReservation(WeixinFormReservation weixinFormReservation) {
		// TODO Auto-generated method stub
		weixinFormReservationDao.saveOrUpdate(weixinFormReservation);
	}
	
	@Override
	public void saveBatchWeixinFormReservation(List<WeixinFormReservation> weixinFormReservationLs) {
		// TODO Auto-generated method stub
		weixinFormReservationDao.addBacth(weixinFormReservationLs);
	}
	
	public PageInfo<WeixinFormReservation> findWeixinFormReservationList(Map<String, Object> params, int pageNo, int pageSize) {
		
		String hql = "from WeixinFormReservation c where 1=1 ";
		String hqlCount = "select count(c.id) from WeixinFormReservation c where 1=1 ";
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
		return weixinFormReservationDao.findPageInfoByQuery(pageNo, pageSize, hql + where.toString() + orderBy, hqlCount + where.toString(), values.toArray());
	}

	
	public PageInfo<WeixinFormReservation> findWeixinFormReservationList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	@Override
	public WeixinFormReservation getWeixinFormReservation(Map<String, Object> params) {
		String hql = "from WeixinFormReservation c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("userName".equals(enity.getKey())) {
				where.append(" and c.userName=?");
				values.add(enity.getValue());
			}
		}
		List<WeixinFormReservation> list=weixinFormReservationDao.loadByPagenation(hql+where.toString()+orderBy,1,1, values.toArray());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public WeixinFormReservation getWeixinFormReservation(Long id) {
		return weixinFormReservationDao.get(id);
	}
	
	@Resource(name="weixinFormReservationDao")
	private WeixinFormReservationDao weixinFormReservationDao;
}
