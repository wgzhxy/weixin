/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.comm.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 * HttpRequest 工具类
 * @author wang.g.z
 *
 */
public class HttpRequestUtils {
	
	final static String CHARSET_INCODE = "UTF-8";
	
	/**
	 * httpGet 带参数生成
	 * @param host
	 * @param path
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 */
	public static HttpGet getHttpGetWithParams(String host, String path, Map<String, String> params) 
			throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost(host).setPath(path);
		for(Map.Entry<String, String> enity : params.entrySet())
		{
			builder.setParameter(enity.getKey(), enity.getValue());
		}
		URI uri = builder.build();
		return new HttpGet(uri);
	}
	
	/**
	 * HttpPost 带参数生成
	 * @param url
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpPost getHttpPostWithParams(String url, Map<String, String> params) 
			throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> enity : params.entrySet())
		{
			formparams.add(new BasicNameValuePair(enity.getKey(), enity.getValue()));
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, CHARSET_INCODE);
		httpPost.setEntity(entity);
		return httpPost;
	}
	
	/**
	 * HttpPost 带参数生成
	 * @param url
	 * @param params
	 * @param charset 参数编码方式
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpPost getHttpPostWithParams(String url, Map<String, String> params, String charset) 
			throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> enity : params.entrySet())
		{
			formparams.add(new BasicNameValuePair(enity.getKey(), enity.getValue()));
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, charset);
		httpPost.setEntity(entity);
		return httpPost;
	}
}
