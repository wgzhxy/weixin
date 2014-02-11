/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.sys.dao.SysUserDao;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.comm.PageInfo;
import com.weixin.comm.secutiry.MDCoder;

@Service("sysUserSrv")
public class SysUserSrvImpl extends ServiceSrvImpl implements SysUserSrv {

	@Override
	public SysUser addSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		return (SysUser)sysUserDao.save(sysUser);
	}

	@Override
	public void deleSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.delete(sysUser);
	}

	@Override
	public void deleSysUser(Long id) {
		// TODO Auto-generated method stub
		sysUserDao.deleteByKey(id);
	}

	@Override
	public void updateSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.saveOrUpdate(sysUser);
	}
	
	@Override
	public void saveBatchSysUser(List<SysUser> sysUserLs) {
		// TODO Auto-generated method stub
		sysUserDao.addBacth(sysUserLs);
	}
	
	public PageInfo<SysUser> findSysUserList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysUser> findSysUserList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysUser getSysUser(Long id) {
		return sysUserDao.get(id);
	}
	
	@Override
	public String checkSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		String tips = "ok";
		StringBuffer hql = new StringBuffer("from SysUser c where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if(sysUser != null) {
			if(StringUtils.isNotEmpty(sysUser.getUserName())) {
				hql.append(" and c.userName = :userName");
				params.put("userName", sysUser.getUserName());
			}
			if(StringUtils.isNotEmpty(sysUser.getPassword())) {
				hql.append(" and c.password = :password");
				params.put("password", MDCoder.encodeMD5Hex(sysUser.getPassword().getBytes()));
			}
			List ls = sysUserDao.findPageByQuery(1, 1, hql.toString(), params);
			if(ls != null && ls.size() > 0) {
				
			} else {
				tips = "用户帐户不存在或密码错误!";
			}
		} else {
			tips = "请输入用户帐户或密码!";
		}
		
		return tips;
	}
	
	@Resource(name="sysUserDao")
	private SysUserDao sysUserDao;
}
