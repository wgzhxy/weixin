package com.weixin.webui.end;

import com.weixin.webui.core.BaseAction;

/**
 * 优惠管理
 * @author wang.g.z
 *
 */
@SuppressWarnings("serial")
public class CouponMngAction extends BaseAction {

	/**
	 * 优惠主面
	 * @return
	 */
	public String MangerIndex() {
		return "index";
	}
	
	/**
	 * 优惠新增
	 * @return
	 */
	public String AddCoupon() {
		
		return "add";
	}
	
	/**
	 * 优惠删除
	 * @return
	 */
	public String DeleteCoupon() {
		
		return "delete";
	}

	/**
	 * 优惠编辑
	 * @return
	 */
	public String EditCoupon() {
		
		return "edit";
	}
	
	/**
	 * 优惠保存
	 * @return
	 */
	public String SaveCoupon() {
		
		return "save";
	}
}
