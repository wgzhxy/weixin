package com.weixin.comm.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.weixin.comm.logs.LogUtil;
import com.weixin.comm.secutiry.PBEUtils;

public class HttpClientPost {
	
	public static String httpPost(String url, String encoding, List<NameValuePair> formparams) throws Exception {

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);// 目标地址
		UrlEncodedFormEntity encoded = new UrlEncodedFormEntity(formparams, encoding);
		httppost.setEntity(encoded);// 设置请求的数据

		HttpResponse response = httpclient.execute(httppost);// 执行,得到返回消息对象
		HttpEntity entity = response.getEntity();
		StatusLine status = response.getStatusLine();
		int status_codes = status.getStatusCode();// 得到请求的状态编码
		LogUtil.info("http status codes is :" + status_codes);
		StringBuffer lines = new StringBuffer();
		String line = null;
		if (entity != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "utf-8"));
			while ((line = reader.readLine()) != null) {
				lines.append(line);
			}
		}
		return lines.toString();
	}

	public static void main(String[] args) throws Exception {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		
		/*formparams.add(new BasicNameValuePair("mobile", "18658319742"));
		formparams.add(new BasicNameValuePair("contents", "dsfdsfdu?1323@#!dd中文测试短信内容"));
		formparams.add(new BasicNameValuePair("src_terminal_id", ""));*/
		
		formparams.add(new BasicNameValuePair("jsonOrder", PBEUtils.encrypt("{'commodityType':2,'businessmanName':'中国人','orderPrice':50,'orderDate':'2013-08-20 15:00:37','orderDescription':'中国人','accountId':4055348,'payType':4,'sourceFlag':2}")));
		String url = "http://192.168.5.224:8089/EasyTomBossUiV5.1.0/unionPay/pageaddOrder.do";
		String encoding = "utf-8";
		System.out.println(HttpClientPost.httpPost(url, encoding, formparams));
	}
}