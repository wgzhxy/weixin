package com.weixin.webui.end;

import com.weixin.webui.core.BaseAction;

/**
 * 微信页面管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class WeinXinPageAction extends BaseAction {
	
	public String PageList() {
		return "index";
	}
	
	public String PageAdd() {
		return "add";
	}
	
	public String PageEdit() {
		return "edit";
	}
	
	public String PageSave() {
		return "save";
	}
	
	public String PageClassList() {
		return "list";
	}
	
	public String PageClassAdd() {
		return "classAdd";
	}
	
	public String PageClassEdit() {
		return "classEdit";
	}
	
	public String PageClassSave() {
		return "classSave";
	}
}
