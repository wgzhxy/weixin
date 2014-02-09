package com.weixin.wJunitTest.end;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.mapping.Array;
import org.junit.Test;

import com.weixin.comm.PageInfo;
import com.weixin.comm.Uuid;
import com.weixin.datacore.domain.sys.model.SysMenu;
import com.weixin.datacore.service.sys.SysMenuSrv;
import com.weixin.wJunitTest.core.JunitBase;

public class SysMenuSrvTest extends JunitBase {
	
	@Resource(name="sysMenuSrv")
	private SysMenuSrv sysMenuSrv;

	@Test
	public void testAddSysMenu() {
		try{
			List<String> menuStr = new ArrayList<String>();
			menuStr.add("index.jsp,icon-home,微信概况");
			menuStr.add("ui.jsp,icon-eye-open,微信实时消息");
			menuStr.add("form.jsp,icon-edit,微信群发");
			menuStr.add("chart.jsp,icon-list-alt,历史消息");
			menuStr.add("chart.jsp,icon-font,群发效果统计");
			menuStr.add("gallery.jsp,icon-picture,图文素材");
			menuStr.add("table.jsp,icon-align-justify,自动回复设置");
			menuStr.add("table.jsp,icon-calendar,自定义菜单");
			
			int i = 1;
			for(String str : menuStr) {
				String[] objs = str.split(",");
				SysMenu menu = new SysMenu();
				menu.setCreateTime(new Date());
				menu.setId(Uuid.getPrimaryKey());
				menu.setMenuDesc(objs[2]);
				menu.setMenuLevel(2);
				menu.setMenuName(objs[2]);
				menu.setMenuOrder(i);
				menu.setMenuParent("bc7f1c015f86430982efa65028d5eedc");
				menu.setMenuUrl(objs[0]);
				menu.setStatus(0);
				menu.setExtend1(objs[1]);
				menu.setUpdateTime(new Date());
				menu.setPlatformTag("001");
				sysMenuSrv.addSysMenu(menu);
				i ++;
			}
			 
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testDeleSysMenuSysMenu() {
	}

	@Test
	public void testDeleSysMenuLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSysMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveBatchSysMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSysMenuListMapOfStringObjectIntInt() {
		try{
			int pageNo = 1;
			int pageSize = 10;
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("status", new Integer(0));
			PageInfo<SysMenu> ls = sysMenuSrv.findSysMenuList(params, pageNo, pageSize);
			if(ls != null && ls.getTotalrecond() > 0) {
				for(SysMenu menu : ls.getResultlist()) {
					System.out.println(menu.getMenuName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	@Test
	public void testFindSysMenuListObjectArrayIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSysMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParentMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChildMenu() {
		fail("Not yet implemented");
	}

}
