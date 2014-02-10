package com.weixin.wJunitTest.weixin;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.weixin.comm.Uuid;
import com.weixin.comm.date.DateUtil;
import com.weixin.comm.secutiry.MDCoder;
import com.weixin.datacore.domain.sys.model.SysUser;
import com.weixin.datacore.domain.weixin.model.WeixinPicture;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.datacore.service.weixin.WeixinPictureSrv;
import com.weixin.wJunitTest.core.JunitBase;

public class WeixinPictureSrvTest extends JunitBase {
	
	@Resource(name="weixinPictureSrv")
	private WeixinPictureSrv weixinPictureSrv;
	
	@Test
	public void testAddWeixinPicture() {
		try{
			WeixinPicture weixinPicture = new WeixinPicture();
			weixinPicture.setCreateTime(DateUtil.getNow());
			weixinPicture.setPictureName("ffff");
			weixinPicture.setStatus(1);
			weixinPicture.setPictureUrl("test");
			weixinPictureSrv.addWeixinPicture(weixinPicture);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
}
