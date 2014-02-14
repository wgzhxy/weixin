package com.weixin.webui.end;

import com.weixin.comm.logs.LogUtil;
import com.weixin.webui.core.BaseAction;

/**
 * 会员申请管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class ApplyMemberAction extends BaseAction {
		
	public String MemberList() {
		LogUtil.info("我是一个中国人!");
		return "index";
	}
	
	public String Reject() {
		
		return "reject";
	}
	
	public String AddStar() {
		
		return "star";
	}
	
	public String Addremark() {
		
		return "remark";
	}
}
