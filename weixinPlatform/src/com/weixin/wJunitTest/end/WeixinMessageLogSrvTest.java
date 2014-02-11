package com.weixin.wJunitTest.end;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.weixin.comm.Uuid;
import com.weixin.comm.date.DateUtil;
import com.weixin.datacore.domain.weixin.model.WeixinMessageLog;
import com.weixin.datacore.service.sys.SysUserSrv;
import com.weixin.datacore.service.weixin.WeixinMessageLogSrv;
import com.weixin.wJunitTest.core.JunitBase;

public class WeixinMessageLogSrvTest extends JunitBase {

	@Test
	public void testAddWeixinMessageLog() {
		try{
			int i = 10;
			while(i > 0) {
				WeixinMessageLog weixinMessageLog = new WeixinMessageLog();
				weixinMessageLog.setMsgId(DateUtil.getNow().getTime());
				weixinMessageLog.setContent("");
				weixinMessageLog.setCreateTime(DateUtil.getNow());
				weixinMessageLog.setDescription("");
				weixinMessageLog.setFromUserName("wgzhxy");
				weixinMessageLog.setMsgClass(0);
				weixinMessageLog.setMsgType(1);
				weixinMessageLog.setToUserName("wgzhxy");
				weixinMessageLog.setTitle("");
				weixinMessageLog.setUrl("http://www.baidu.com");
				weixinMessageLogSrv.addWeixinMessageLog(weixinMessageLog);
				i--;
			}
			
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testDeleWeixinMessageLogWeixinMessageLog() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleWeixinMessageLogLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateWeixinMessageLog() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveBatchWeixinMessageLog() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWeixinMessageLogListMapOfStringObjectIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWeixinMessageLogListObjectArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWeixinMessageLog() {
		fail("Not yet implemented");
	}
	
	@Resource(name="weixinMessageLogSrv")
	private WeixinMessageLogSrv weixinMessageLogSrv;
}
