package com.weixin.component.webchat;

import net.sf.json.JSONObject;

/**
 * 菜单操作的调用方法
 * @author JINLONE
 *
 */
public interface MenuManagerComponent {
		/**
		 * 创建菜单
		 * @param accessToken
		 * @param jsonStr
		 * @return
		 */
		public boolean createMenu(final String accessToken,final String jsonStr);
		
		/**
		 * 删除菜单
		 * @param accessToken
		 * @return
		 */
		public boolean deleteMenu(final String accessToken);
		
		/**
		 * 取得线上菜单信息
		 * @param accessToken
		 * @return
		 */
		public JSONObject getMenu(final String accessToken);
}