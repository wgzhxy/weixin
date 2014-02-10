package com.weixin.webui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.weixin.comm.ConvertJson;
import com.weixin.comm.PageInfo;
import com.weixin.datacore.domain.weixin.model.WeixinMenuItem;
import com.weixin.datacore.service.weixin.WeixinMenuItemSrv;
import com.weixin.webui.core.BaseAction;

/**
 * 菜单管理action
 * 
 * @author JINLONE
 * 
 */
public class WeixinMenuItemAction extends BaseAction {

	public String jump;

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4949448238447282481L;

	/**
	 * 取得菜单的列表数据进行展示使用
	 * 
	 * @return
	 */
	public String menuItemList(){
//		Map<String, Object> params=new HashMap<String,Object>();
//		List<TestEntitys> list_tmp=new ArrayList<TestEntitys>();
//		PageInfo<WeixinMenuItem> list=weixinMenuItemSrv.findWeixinMenuItemList(params, 1, pageSize);
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("sEcho",0);
//		map.put("iTotalRecords",list.getResultlistsize()+"");
//		map.put("iTotalDisplayRecords",list.getResultlistsize()+"");
//		List<WeixinMenuItem> list_item=list.getResultlist();
//		for(WeixinMenuItem tmp:list_item){
//			TestEntitys entitys=new TestEntitys();
//			entitys.setId(tmp.getId());
//			entitys.setName(tmp.getName());
//			entitys.setTypeAA(tmp.getType()+"");
//			list_tmp.add(entitys);
//		}
//		map.put("aaData",list_tmp);
//		String jsonStr =ConvertJson.map2json(map);
//		System.out.println(jsonStr);
		return null;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String menuItemEdit() {
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String menuItemRemove() {
		return SUCCESS;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	public String menuItemAdd() {
		return SUCCESS;
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String menuItemBase() {
		if (jump.equals("add")) {
			return "add";
		}
		if (jump.equals("edit")) {
			return "edit";
		}
		return SUCCESS;
	}

	@Resource(name = "weixinMenuItemSrv")
	private WeixinMenuItemSrv weixinMenuItemSrv;

}