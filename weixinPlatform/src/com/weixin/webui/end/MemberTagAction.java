package com.weixin.webui.end;

import com.weixin.webui.core.BaseAction;

/**
 * 会员标签管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class MemberTagAction extends BaseAction {
	
	/**
	 * 会员标签主页面
	 * @return
	 */
	public String Index() {
		return "index";
	}
	
	/**
	 * 会员标签主页面
	 * @return
	 */
	public String Add() {
		return "add";
	}
	
	/**
	 * 会员标签主页面
	 * @return
	 */
	public String Edit() {
		return "edit";
	}
	
	/**
	 * 会员标签主页面
	 * @return
	 */
	public String delete() {
		return "delete";
	}
	
}
