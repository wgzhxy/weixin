/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.comm.http;

import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

import com.weixin.comm.logs.LogUtil;


/**
 * Httpclient 连接池管理
 * @author wang.g.z
 *
 */
public class PoolConnectionManager {

	private static final int TIMEOUT = 20000;// 连接超时时间
	private static final int SO_TIMEOUT = 60000;// 数据传输超时
	private static PoolingClientConnectionManager cm = null;
	private static HttpParams params = new BasicHttpParams();

	public static DefaultHttpClient getHttpClient() {
		DefaultHttpClient client = null;
		try{
			if(cm == null) {
				synchronized (PoolConnectionManager.class) {
					if(cm == null) {
						//初始化scheme
						SchemeRegistry schemeRegistry = new SchemeRegistry();
						schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
						schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
						cm = new PoolingClientConnectionManager(schemeRegistry);
						//设置最大连接数
						cm.setMaxTotal(500);
						//设置最大每路同连接数
						cm.setDefaultMaxPerRoute(50);
						//设置连接超时和socket连接超时
						params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
						params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIMEOUT);
						params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
					}
				}
			}
			client = new DefaultHttpClient(cm, params);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.info(PoolConnectionManager.class, e);
		}
		return client;
	}
	
	public static DefaultHttpClient getHttpClient(HttpParams httpParams) {
		DefaultHttpClient client = getHttpClient();
		if(client != null && httpParams != null) {
			client.setParams(httpParams);
		}
		return client;
	}
	
	public static PoolingClientConnectionManager getConnectionManager() {
		return cm;
	}
}
