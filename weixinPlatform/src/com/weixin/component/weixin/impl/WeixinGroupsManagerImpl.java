package com.weixin.component.weixin.impl;

import net.sf.json.JSONObject;

import com.weixin.component.weixin.WeixinGroupsManager;

public class WeixinGroupsManagerImpl implements WeixinGroupsManager {

	private static final String CREATE_URL="https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	private static final String UPDATE_URL="https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	private static final String GET_URL="https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	private static final String MEMBER_UPDATE_URL="https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	
	@Override
	public int create(String groups_name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JSONObject get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, String groups_new_name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memeberUpdate(String openid, int groups_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}