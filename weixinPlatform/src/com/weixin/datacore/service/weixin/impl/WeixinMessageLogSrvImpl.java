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

import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.weixin.dao.WeixinMessageLogDao;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.datacore.service.weixin.WeixinMessageLogSrv;
import com.weixin.comm.PageInfo;
import com.weixin.comm.secutiry.MDCoder;

@Service("weixinMessageLogSrv")
public class WeixinMessageLogSrvImpl extends ServiceSrvImpl implements WeixinMessageLogSrv {

	@Override
	public WeixinMessageLog addWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		return (WeixinMessageLog)weixinMessageLogDao.save(weixinMessageLog);
	}

	@Override
	public void deleWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.delete(weixinMessageLog);
	}

	@Override
	public void deleWeixinMessageLog(Long id) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinMessageLog(WeixinMessageLog weixinMessageLog) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.saveOrUpdate(weixinMessageLog);
	}
	
	@Override
	public void saveBatchWeixinMessageLog(List<WeixinMessageLog> weixinMessageLogLs) {
		// TODO Auto-generated method stub
		weixinMessageLogDao.addBacth(weixinMessageLogLs);
	}
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Map<String, Object> params, int pageNo, int pageSize) {
		try{
			String hql = "from WeixinMessageLog c where 1=1 ";
			String hqlCount = "select count(c.msgId) from WeixinMessageLog c where 1=1 ";
			StringBuffer where = new StringBuffer();
			if(params != null) {
				for(Map.Entry<String, Object> entity : params.entrySet()) {
					if(StringUtils.equals("content", entity.getKey())) 
					{
						where.append(" and c.").append(entity.getKey()).append(" like :").append(entity.getKey());
						params.put(entity.getKey(), "%" + entity.getValue() + "%");
					} else if(StringUtils.isNotEmpty(entity.getKey())) 
					{
						where.append(" and c.").append(entity.getKey()).append("= :").append(entity.getKey());
					}
				}
			}
			String orderBy = " order by c.createTime desc"; 
			return weixinMessageLogDao.findPageInfoByQuery(pageNo, pageSize, 
														   hql + where.toString() + orderBy, 
														   hqlCount.toString() + where.toString(), 
														   params);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public PageInfo<WeixinMessageLog> findWeixinMessageLogList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinMessageLog getWeixinMessageLog(Long id) {
		return weixinMessageLogDao.get(id);
	}
	
	@Resource(name="weixinMessageLogDao")
	private WeixinMessageLogDao weixinMessageLogDao;
}
