package com.weixin.component.weixin.impl;

import net.sf.json.JSONObject;

import com.weixin.comm.http.HttpsClientUtils;
import com.weixin.comm.text.TextUtil;
import com.weixin.component.weixin.WeixinGroupsManager;

public class WeixinGroupsManagerImpl implements WeixinGroupsManager {

	private static final String CREATE_URL="https://api.weixin.qq.com/cgi-bin/groups/create?access_token=";
	private static final String UPDATE_URL="https://api.weixin.qq.com/cgi-bin/groups/update?access_token=";
	private static final String GET_URL="https://api.weixin.qq.com/cgi-bin/groups/get?access_token=";
	private static final String MEMBER_UPDATE_URL="https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=";
	
	@Override
	public int create(String groups_name) {
		String jsonData="{\"group\":{\"name\":\""+groups_name+"\"}}";
		String url=CREATE_URL+TextUtil.getText("WEB_CHAT_ACCESS_TOKEN");
		System.out.println(url);
		System.out.println(HttpsClientUtils.post(url, jsonData));
		return 0;
	}

	@Override
	public JSONObject get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, String groups_new_name) {
		String jsonData="{\"group\":{\"id\":"+id+",\"name\":\""+groups_new_name+"\"}}";
		String url=UPDATE_URL+TextUtil.getText("WEB_CHAT_ACCESS_TOKEN");
		System.out.println(url);
		System.out.println(HttpsClientUtils.post(url, jsonData));
		return 0;
	}

	@Override
	public int memeberUpdate(String openid, int to_groupid) {
		String jsonData="{\"group\":{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}}";
		String url=MEMBER_UPDATE_URL+TextUtil.getText("WEB_CHAT_ACCESS_TOKEN");
		System.out.println(url);
		System.out.println(HttpsClientUtils.post(url, jsonData));
		return 0;
	}
	
	public static void main(String[] args){
		WeixinGroupsManagerImpl wexin=new WeixinGroupsManagerImpl();
		wexin.memeberUpdate("od8XIjsmk6QdVTETa9jLtGWA6KBc", 100);
	}
}