package com.weixin.component.weixin.impl;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.bouncycastle.util.encoders.Hex;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.weixin.comm.http.HttpClientUtils;
import com.weixin.comm.http.HttpResponseParser;
import com.weixin.comm.logs.LogUtil;
import com.weixin.comm.secutiry.SHACoder;
import com.weixin.component.weixin.CommonComponent;
import com.weixin.datacore.domain.weixin.vo.SubscribeUserInfoVo;
/**
 * @author JINLONG
 * 
 */
@Service("commonComponentImpl")
public class CommComponentImpl implements CommonComponent {

	private static final String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	
	private static final String GET_SUBSCRIBE_USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN";
	@Override
	public String getAccessToken(String appid, String secret) {
		String result="";
		StringBuffer sb=new StringBuffer();
		sb.append(GET_ACCESS_TOKEN_URL);
		sb.append("&appid="+appid);
		sb.append("&secret="+secret);
		HttpClient client = HttpClientUtils.getHttpClient();
		HttpGet httpGet = new HttpGet(sb.toString());
		HttpResponse response;
		try {
			response = client.execute(httpGet);
			result=HttpResponseParser.ResponseParserToString(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public SubscribeUserInfoVo getSubscribeUserInfoByOpenId(String openid) {
		String result="";
		StringBuffer sb=new StringBuffer();
		sb.append(GET_SUBSCRIBE_USER_INFO_URL);
		sb.append("&openid="+openid);
		sb.append("&access_token="+"access_token");
		HttpClient client = HttpClientUtils.getHttpClient();
		HttpGet httpGet = new HttpGet(sb.toString());
		HttpResponse response;
		try {
			response = client.execute(httpGet);
			result=HttpResponseParser.ResponseParserToString(response);
			ObjectMapper objectMapper=new ObjectMapper();
			SubscribeUserInfoVo subscribeUserInfo =objectMapper.readValue(result,SubscribeUserInfoVo.class);
			return subscribeUserInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkSignature(String token, String timestamp, String nonce,
			String signature,String echostr) {
		LogUtil.info("[" + timestamp + "," + nonce + "," + echostr + ","
				+ signature + "]");
		ArrayList<String> list = new ArrayList<String>();
		list.add(timestamp);
		list.add(nonce);
		list.add(token);
		Collections.sort(list);
		String secutiry= "";
		for (String tmp : list) {
			secutiry += tmp;
		}
		byte[] buffer = null;
		try {
			buffer = SHACoder.encodeSHA(secutiry.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (buffer != null) {
			String hex_str = new String(Hex.encode(buffer));
			LogUtil.info("[" + timestamp + "," + nonce + "," + echostr + "],"
					+ hex_str + "," + signature);
			if (hex_str.equals(signature)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}