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
import com.weixin.datacore.domain.sys.dao.SysOrgDao;
import com.weixin.datacore.domain.sys.model.SysOrg;
import com.weixin.datacore.service.sys.SysOrgSrv;
import com.weixin.comm.PageInfo;

@Service("sysOrgSrv")
public class SysOrgSrvImpl extends ServiceSrvImpl implements SysOrgSrv {

	@Override
	public SysOrg addSysOrg(SysOrg sysOrg) {
		// TODO Auto-generated method stub
		return (SysOrg)sysOrgDao.save(sysOrg);
	}

	@Override
	public void deleSysOrg(SysOrg sysOrg) {
		// TODO Auto-generated method stub
		sysOrgDao.delete(sysOrg);
	}

	@Override
	public void deleSysOrg(Long id) {
		// TODO Auto-generated method stub
		sysOrgDao.deleteByKey(id);
	}

	@Override
	public void updateSysOrg(SysOrg sysOrg) {
		// TODO Auto-generated method stub
		sysOrgDao.saveOrUpdate(sysOrg);
	}
	
	@Override
	public void saveBatchSysOrg(List<SysOrg> sysOrgLs) {
		// TODO Auto-generated method stub
		sysOrgDao.addBacth(sysOrgLs);
	}
	
	public PageInfo<SysOrg> findSysOrgList(Map<String, Object> params, int pageNo, int pageSize) {
		 return null;
	}
	
	public PageInfo<SysOrg> findSysOrgList(Object[] params, int pageNo, int pageSize) {
		 return null;
	}
	
	public SysOrg getSysOrg(Long id) {
		return sysOrgDao.get(id);
	}
	
	@Resource(name="sysOrgDao")
	private SysOrgDao sysOrgDao;
}
