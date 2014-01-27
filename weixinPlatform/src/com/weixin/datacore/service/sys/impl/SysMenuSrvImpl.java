/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.sys.dao.SysMenuDao;
import com.weixin.datacore.domain.sys.model.SysMenu;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.comm.PageInfo;

@Service("sysMenuSrv")
public class SysMenuSrvImpl extends ServiceSrvImpl implements SysMenuSrv {

	@Override
	public SysMenu addSysMenu(SysMenu sysMenu) {
		// TODO Auto-generated method stub
		return (SysMenu)sysMenuDao.save(sysMenu);
	}

	@Override
	public void deleSysMenu(SysMenu sysMenu) {
		// TODO Auto-generated method stub
		sysMenuDao.delete(sysMenu);
	}

	@Override
	public void deleSysMenu(Long id) {
		// TODO Auto-generated method stub
		sysMenuDao.deleteByKey(id);
	}

	@Override
	public void updateSysMenu(SysMenu sysMenu) {
		// TODO Auto-generated method stub
		sysMenuDao.saveOrUpdate(sysMenu);
	}
	
	@Override
	public void saveBatchSysMenu(List<SysMenu> sysMenuLs) {
		// TODO Auto-generated method stub
		sysMenuDao.addBacth(sysMenuLs);
	}
	
	public PageInfo<SysMenu> findSysMenuList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysMenu> findSysMenuList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysMenu getSysMenu(Long id) {
		return sysMenuDao.get(id);
	}
	
	@Override
	public List<SysMenu> getParentMenu() {
		// TODO Auto-generated method stub
		String hql = "from SysMenu c where 1=1 and c.status = 0 and c.menuParent is null";
		String orderBy = " order by c.menuOrder asc";
		List<Object> values = new ArrayList<Object>();
		return sysMenuDao.findByHql(hql + orderBy, values.toArray());
	}

	@Override
	public List<SysMenu> getChildMenu(String parentId) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(parentId)) {
			String hql = "from SysMenu c where 1=1 and c.status = 0 and c.menuParent = ?";
			String orderBy = " order by c.menuOrder asc";
			List<Object> values = new ArrayList<Object>();
			values.add(parentId);
			return sysMenuDao.findByHql(hql + orderBy, values.toArray());
		} else {
			return null;
		}
	}
	
	@Resource(name="sysMenuDao")
	private SysMenuDao sysMenuDao;
}
