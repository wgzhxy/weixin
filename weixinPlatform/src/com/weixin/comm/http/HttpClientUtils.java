/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.comm.http;

import java.io.IOException;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

/**
 * Httpclient 获取client连接对象
 * @author wang.g.z
 *
 */
public class HttpClientUtils {

	public static HttpClient getHttpClient() {
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
		return PoolConnectionManager.getHttpClient(params);
	}
	
	public static HttpClient getHttpClientRetry() {
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
		DefaultHttpClient client = PoolConnectionManager.getHttpClient(params);
		client.setHttpRequestRetryHandler(HttpRequestRetryHandlerUtils.retryHandlerTow);
		return client;
	}

	public static void release() {
		if (PoolConnectionManager.getConnectionManager() != null) {
			PoolConnectionManager.getConnectionManager().shutdown();
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		Random r = new Random();
		for (int i = 0; i < 1; i++) {
			long l1 = System.currentTimeMillis();
			HttpClient client = getHttpClient();
			HttpGet get = new HttpGet("http://www.baidu.com/s?wd=" + r.nextInt(5000));
			
			HttpResponse response = client.execute(get);
			System.out.println(HttpResponseParser.ResponseParserToString(response));
			System.out.println("查询耗时" + (System.currentTimeMillis() - l1));
		}
	}
}