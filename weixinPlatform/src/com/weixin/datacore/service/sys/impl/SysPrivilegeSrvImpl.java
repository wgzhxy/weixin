/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
 
package com.weixin.datacore.service.sys.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.weixin.datacore.core.impl.ServiceSrvImpl;
import com.weixin.datacore.domain.sys.dao.SysPrivilegeDao;
import com.weixin.datacore.domain.sys.model.SysPrivilege;
import com.weixin.datacore.service.sys.SysPrivilegeSrv;
import com.weixin.comm.PageInfo;

@Service("sysPrivilegeSrv")
public class SysPrivilegeSrvImpl extends ServiceSrvImpl implements SysPrivilegeSrv {

	@Override
	public SysPrivilege addSysPrivilege(SysPrivilege sysPrivilege) {
		// TODO Auto-generated method stub
		return (SysPrivilege)sysPrivilegeDao.save(sysPrivilege);
	}

	@Override
	public void deleSysPrivilege(SysPrivilege sysPrivilege) {
		// TODO Auto-generated method stub
		sysPrivilegeDao.delete(sysPrivilege);
	}

	@Override
	public void deleSysPrivilege(Long id) {
		// TODO Auto-generated method stub
		sysPrivilegeDao.deleteByKey(id);
	}

	@Override
	public void updateSysPrivilege(SysPrivilege sysPrivilege) {
		// TODO Auto-generated method stub
		sysPrivilegeDao.saveOrUpdate(sysPrivilege);
	}
	
	@Override
	public void saveBatchSysPrivilege(List<SysPrivilege> sysPrivilegeLs) {
		// TODO Auto-generated method stub
		sysPrivilegeDao.addBacth(sysPrivilegeLs);
	}
	
	public PageInfo<SysPrivilege> findSysPrivilegeList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysPrivilege> findSysPrivilegeList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysPrivilege getSysPrivilege(Long id) {
		return sysPrivilegeDao.get(id);
	}
	
	@Resource(name="sysPrivilegeDao")
	private SysPrivilegeDao sysPrivilegeDao;
}
