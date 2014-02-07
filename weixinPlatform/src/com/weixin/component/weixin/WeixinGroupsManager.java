package com.weixin.component.weixin;

import net.sf.json.JSONObject;

public interface WeixinGroupsManager {
	/**
	 *  创建分组
	 * @param groups_name 分组名称
	 * @return
	 */
	public int create(final String groups_name);
	/**
	 * 取所有分组信息
	 * @return
	 */
	public JSONObject get();
	
	/**
	 * 修改分组名称
	 * @param id 分组ID
	 * @param groups_new_name 新分组名称
	 * @return
	 */
	public int update(final int id,final String groups_new_name);

	/**
	 * 移动用户到所属的分组
	 * @param openid 用户id
	 * @param groups_id 分组id
	 * @return
	 */
	public int memeberUpdate(final String openid,final int groups_id);
}