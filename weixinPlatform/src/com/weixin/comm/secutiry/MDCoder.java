/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.secutiry;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

import com.weixin.comm.logs.LogUtil;
/**
 * MD 消息摘要算法
 * 
 * @author wang.g.z
 * @since 1.0
 * @time 2013.5.16
 */
public abstract class MDCoder {

	/**
	 * MD2加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD2");
		return md.digest(data);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 执行消息摘要
		return md.digest(data);
	}
	
	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(InputStream in) throws Exception {
		// 初始化MessageDigest
		try{
			int len = 0;
			byte[] buffer = new byte[1024];
	 		MessageDigest md = MessageDigest.getInstance("MD5");
			while((len = in.read(buffer)) != -1) {
				md.update(buffer, 0, len);
			}
			// 执行消息摘要
			return md.digest();
		} finally {
			if(in != null) {
				in.close();
				in = null;
			}
		}
	}
	

	/**
	 * MD5摘要
	 * @param params 参数数组
	 * @param prefix 前缀信息
	 * @return
	 */
	public static String encodeMD5Hex(InputStream in) {
		try{
			return Hex.encodeHexString(encodeMD5(in));
		} catch (Exception e) 
		{
			e.printStackTrace();
			LogUtil.error(MDCoder.class, e);
		} finally {
			if(in != null) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}
	
	/**
	 * MD5摘要
	 * @param params 参数数组
	 * @param prefix 前缀信息
	 * @return
	 */
	public static String encodeMD5Hex(String[] params, String prefix) {
		try{
			StringBuffer buffer = new StringBuffer(prefix);
			for(String param : params) { 
				buffer.append("0").append(param);
			}
			return Hex.encodeHexString(encodeMD5(buffer.toString().getBytes()));
		} catch (Exception e) 
		{
			e.printStackTrace();
			LogUtil.error(MDCoder.class, e);
		}
		return "";
	}
	
	/**
	 * MD5摘要
	 * @param data 待加密数据
	 * @return
	 */
	public static String encodeMD5Hex(byte[] data) {
		try{
			return Hex.encodeHexString(encodeMD5(data));
		} catch (Exception e) 
		{
			e.printStackTrace();
			LogUtil.error(MDCoder.class, e);
		}
		return "";
	}
	
	/**
	 * MD5摘要
	 * @param strKey 待加密数据
	 * @return
	 */
	public static String encodeMD5Hex(String strKey) {
		try{
			return Hex.encodeHexString(encodeMD5(strKey.getBytes()));
		} catch (Exception e) 
		{
			e.printStackTrace();
			LogUtil.error(MDCoder.class, e);
		}
		return "";
	}
}
