package com.weixin.webui.end;

import com.weixin.webui.core.BaseAction;

/**
 * 工单管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class WorkOrderAction extends BaseAction {
	
	/**
	 * 人工客户处理
	 * @return
	 */
	public String ArtificialService() {
		
		return "service";
	}
	
	/**
	 * 预约看房
	 * @return
	 */
	public String ViewHourse() {
		
		return "hourse";
	}
	
	/**
	 * 推荐入会
	 * @return
	 */
	public String TuiJianMember() {
		
		return "tuijian";
	}
	
	/**
	 * 推荐关注
	 * @return
	 */
	public String TuiJianFocus() {
		
		return "focus";
	}
}
