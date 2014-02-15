package com.weixin.webui.end;

import com.weixin.webui.core.BaseAction;

/**
 * 微信粉丝管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class WeinXinFansAction extends BaseAction {
	
	public String Index() {
		return "index";
	}
	
	public String SetLevl() {
		return "level";
	}
	
	public String addScore() {
		return "score";
	}
	
	public String addTag() {
		return "tag";
	}
}
