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
import com.weixin.datacore.domain.weixin.dao.WeixinCommandDao;
import com.weixin.datacore.domain.weixin.model.WeixinArticles;
import com.weixin.datacore.domain.weixin.model.WeixinCommand;
import com.weixin.datacore.service.weixin.WeixinCommandSrv;
import com.weixin.comm.PageInfo;

@Service("weixinCommandSrv")
public class WeixinCommandSrvImpl extends ServiceSrvImpl implements WeixinCommandSrv {

	@Override
	public WeixinCommand addWeixinCommand(WeixinCommand weixinCommand) {
		// TODO Auto-generated method stub
		return (WeixinCommand)weixinCommandDao.save(weixinCommand);
	}

	@Override
	public void deleWeixinCommand(WeixinCommand weixinCommand) {
		// TODO Auto-generated method stub
		weixinCommandDao.delete(weixinCommand);
	}

	@Override
	public void deleWeixinCommand(Long id) {
		// TODO Auto-generated method stub
		weixinCommandDao.deleteByKey(id);
	}

	@Override
	public void updateWeixinCommand(WeixinCommand weixinCommand) {
		// TODO Auto-generated method stub
		weixinCommandDao.saveOrUpdate(weixinCommand);
	}
	
	@Override
	public void saveBatchWeixinCommand(List<WeixinCommand> weixinCommandLs) {
		// TODO Auto-generated method stub
		weixinCommandDao.addBacth(weixinCommandLs);
	}
	
	public PageInfo<WeixinCommand> findWeixinCommandList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<WeixinCommand> findWeixinCommandList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public WeixinCommand getWeixinCommand(Long id) {
		return weixinCommandDao.get(id);
	}
	
	public WeixinCommand getWeixinCommand(Map<String, Object> params){
		String hql = "from WeixinCommand c where 1=1 ";
		StringBuffer where = new StringBuffer();
		String orderBy = " order by c.id desc ";
		List<Object> values = new ArrayList<Object>();
		for(Map.Entry<String, Object> enity : params.entrySet()) {
			if("cmd".equals(enity.getKey())) {
				where.append(" and c.cmd=?");
				values.add(enity.getValue());
			}
		}
		List<WeixinCommand> list=weixinCommandDao.loadByPagenation(hql+where.toString()+orderBy,1,1, values.toArray());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Resource(name="weixinCommandDao")
	private WeixinCommandDao weixinCommandDao;
}