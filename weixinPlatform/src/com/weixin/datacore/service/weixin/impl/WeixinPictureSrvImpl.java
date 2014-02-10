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
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinPictureDao;
import com.weixin.datacore.domain.weixin.model.WeixinPicture;
import com.weixin.datacore.service.weixin.WeixinPictureSrv;
import com.weixin.comm.PageInfo;

@Service("weixinPictureSrv")
public class WeixinPictureSrvImpl extends ServiceSrvImpl implements WeixinPictureSrv {

	@Override
	public WeixinPicture addWeixinMenuItem(WeixinPicture weixinPicture) {
		// TODO Auto-generated method stub
		return (WeixinPicture) weixinPictureDao.save(weixinPicture);
	}

	@Override
	public void deleWeixinPicture(WeixinPicture weixinPicture) {
		// TODO Auto-generated method stub
		weixinPictureDao.delete(weixinPicture);
	}

	@Override
	public void deleWeixinPicture(Long id) {
		// TODO Auto-generated method stub
		weixinPictureDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinPicture(WeixinPicture weixinPicture) {
		// TODO Auto-generated method stub
		weixinPictureDao.update(weixinPicture);
	}

	@Override
	public void saveBatchWeixinPicture(List<WeixinPicture> weixinPictureLs) {
		// TODO Auto-generated method stub
		weixinPictureDao.addBacth(weixinPictureLs);
	}

	@Override
	public PageInfo<WeixinPicture> findWeixinPictureList(
			Map<String, Object> params, int pageNo, int pageSize) {
		String hql = "from WeixinPicture c where 1=1 ";
		String hqlCount = "select count(c.id) from WeixinPicture c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
		}
		return weixinPictureDao.findPageInfoByQuery(pageNo, pageSize, hql + where.toString() + orderBy, hqlCount + where.toString(), values.toArray());
	}

	@Override
	public PageInfo<WeixinPicture> findWeixinPictureList(Object[] params,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeixinPicture getWeixinPicture(Long id) {
		// TODO Auto-generated method stub
		return weixinPictureDao.get(id);
	}

	@Resource(name="weixinPictureDao")
	private WeixinPictureDao weixinPictureDao;
}
