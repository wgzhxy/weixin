/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.secutiry;

import java.security.MessageDigest; 
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * SHA加密组件
 * 
 * @version 1.0
 * @since 1.0
 */
public abstract class SHACoder {

	/**
	 * SHA-1加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA(byte[] data) throws Exception {
		// 初始化MessageDigest
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(byte[] data) throws Exception {
		// 初始化MessageDigest
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(byte[] data) throws Exception {
		// 初始化MessageDigest
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA-384");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-512加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(byte[] data) throws Exception {
		// 初始化MessageDigest
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		// 执行消息摘要
		return md.digest(data);
	}
	
	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA224(byte[] data) throws Exception {
		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-224");
		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHA224Hex(byte[] data) throws Exception {
		// 执行消息摘要
		byte[] b = encodeSHA224(data);
		// 做十六进制编码处理
		return new String(Hex.encode(b));

	}
	
	public static void main(String args[]) throws Exception {
		byte[] str = SHACoder.encodeSHA("我是一个中国人，我的家在北京".getBytes());
		System.out.println(new String(Hex.encode(str)));
		
		byte[] str1 = SHACoder.encodeSHA224("我是一个中国人，我的家在北京".getBytes());
		System.out.println(new String(Hex.encode(str1)));
		
		byte[] str2 = SHACoder.encodeSHA256("我是一个中国人，我的家在北京".getBytes());
		System.out.println(new String(Hex.encode(str2)));
		
		byte[] str3 = SHACoder.encodeSHA384("我是一个中国人，我的家在北京".getBytes());
		System.out.println(new String(Hex.encode(str3)));
		
		byte[] str4 = SHACoder.encodeSHA512("我是一个中国人，我的家在北京".getBytes());
		System.out.println(new String(Hex.encode(str4)));
	}
}
