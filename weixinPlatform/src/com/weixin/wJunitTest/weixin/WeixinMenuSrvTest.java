package com.weixin.wJunitTest.weixin;

import static org.junit.Assert.*;
import java.util.List;
import javax.annotation.Resource;

import net.sf.json.JSONArray;
import org.junit.Test;
import com.weixin.datacore.domain.weixin.vo.WeixinMenuTreeNode;
import com.weixin.datacore.service.weixin.WeixinMenuSrv;
import com.weixin.wJunitTest.core.JunitBase;

public class WeixinMenuSrvTest extends JunitBase {
	
	@Resource(name="weixinMenuSrv")
	private WeixinMenuSrv weixinMenuSrv;
	
	@Test
	public void testweixinMenuTreeNodeList() {
		try{
			List<WeixinMenuTreeNode> list=weixinMenuSrv.weixinMenuTreeNodeList();
			JSONArray jsonObject=JSONArray.fromObject(list);
			System.out.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
}
