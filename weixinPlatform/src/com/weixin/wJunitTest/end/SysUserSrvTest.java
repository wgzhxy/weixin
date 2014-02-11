package com.weixin.wJunitTest.end;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.weixin.comm.Uuid;
import com.weixin.comm.secutiry.MDCoder;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.wJunitTest.core.JunitBase;

public class SysUserSrvTest extends JunitBase {
	
	@Resource(name="sysUserSrv")
	private SysUserSrv sysUserSrv;
	
	@Test
	public void testAddSysUser() {
		try{
			SysUser sysUser = new SysUser();
			sysUser.setId(Uuid.getPrimaryKey());
			sysUser.setCreateTime(new Date());
			sysUser.setEmail("wgzhxy@163.com");
			sysUser.setMobile("13329605248");
			sysUser.setPlatformTag("001");
			sysUser.setUpdateTime(new Date());
			sysUser.setUserName("admin");
			sysUser.setPassword(MDCoder.encodeMD5Hex("admin".getBytes()));
			sysUserSrv.addSysUser(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
}
