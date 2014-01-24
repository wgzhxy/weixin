package com.weixin.component.weixin;

import net.sf.json.JSONObject;

/**
 * 管理微信的菜单操作
 * @author JINLONE
 *
 */
public interface WeixinMenuManager {
	/**
	 * 创建菜单
	 * @param jsonStr
	 * @param accessToken
	 * @return
	 */
	public boolean createMenu(final String jsonStr,final String accessToken);
	/**
	 * 删除线上菜单
	 * @param accessToken
	 * @return
	 */
	public boolean deleteMenu(final String accessToken);
	/**
	 * 取得线上的菜单信息
	 * @param accessToken
	 * @return
	 */
	public JSONObject getMenu(final String accessToken);
}