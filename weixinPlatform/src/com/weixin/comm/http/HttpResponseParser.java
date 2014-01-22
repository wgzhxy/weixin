/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.comm.http;

import java.io.InputStreamReader;
import org.apache.commons.lang.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.weixin.comm.logs.LogUtil;

/**
 * HttpResponse 解析工具类
 * 
 * @author wang.g.z
 * 
 */
public class HttpResponseParser {

	/**
	 * 获取数据返回输出流，并转换为字符串
	 * 
	 * @param response
	 * @return
	 */
	public static String ResponseParserToString(HttpResponse response) {
		int count = 0;
		InputStreamReader reader = null;
		StringBuffer contentBody = new StringBuffer("");
		try {
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				
				HttpEntity entity = response.getEntity();
				if (entity != null && entity.isStreaming()) {
					if (entity.getContentEncoding() != null) {
						String enCode = entity.getContentEncoding().getName();
						reader = new InputStreamReader(entity.getContent(), enCode);
					} else {
						reader = new InputStreamReader(entity.getContent());
					}
					count = 0;
					char[] buffer = new char[2048];
					while ((count = reader.read(buffer)) != -1) {
						contentBody.append(ArrayUtils.subarray(buffer, 0, count));
					}
				}
			} else {
				contentBody.append("100");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(HttpResponseParser.class, e);
			contentBody.append("100");
		}
		return contentBody.toString();
	}
	
	/**
	 * 返回head数据对象
	 * @param response
	 * @return
	 */
	public static Header[] getHeads(HttpResponse response) {
		return response.getAllHeaders();
	}
	
	/**
	 * 返回head
	 * @param response
	 * @return
	 */
	public static String getFirstHeadValue(HttpResponse response, String headName) {
		Header header = response.getFirstHeader(headName);
		if(header != null) {
			return header.getValue();
		} else {
			return  "";
		}
	}
	
	/**
	 * 返回head
	 * @param response
	 * @return
	 */
	public static String getLastHeadValue(HttpResponse response, String headName) {
		Header header = response.getLastHeader(headName);
		if(header != null) {
			return header.getValue();
		} else {
			return  "";
		}
	}
}
