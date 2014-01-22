/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.secutiry;

import org.apache.commons.codec.binary.Hex;

import com.weixin.comm.logs.LogUtil;
import com.weixin.comm.text.TextUtil;

/**
 * 加解密工具类
 * @author Wang.g.z
 *
 */
public class PBEUtils {
	
	final static String PBE_SALT = TextUtil.getText("pbe_salt");
	final static String PBE_PASSWORD = TextUtil.getText("pbe_password");
	
	/**
	 * 加密 
	 * @param data
	 * @return
	 */
	public static byte[] encrypt(byte[] data) {
		try{
			return PBECoder.encrypt(data, PBE_PASSWORD, Hex.decodeHex(PBE_SALT.toCharArray())); 
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		return null;
	}
	
	/**
	 * 解密
	 * @param data
	 * @return
	 */
	public static byte[] decrypt(byte[] data) {
		try{
			return PBECoder.decrypt(data, PBE_PASSWORD, Hex.decodeHex(PBE_SALT.toCharArray())); 
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		return null;
	}
	
	/**
	 * 加密 
	 * @param data
	 * @return
	 */
	public static String encrypt(String data) {
		try{
			return Hex.encodeHexString(PBECoder.encrypt(data.getBytes(), PBE_PASSWORD, Hex.decodeHex(PBE_SALT.toCharArray()))); 
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		return null;
	}
	
	/**
	 * 解密
	 * @param data
	 * @return
	 */
	public static String decrypt(String data) {
		try{
			return new String(PBECoder.decrypt(Hex.decodeHex(data.toCharArray()), PBE_PASSWORD, Hex.decodeHex(PBE_SALT.toCharArray()))); 
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
		}
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "我是一个中国人，我的家乡在北京，你好！";
		System.out.println(str);
		byte[] endata = PBEUtils.encrypt(str.getBytes());
		System.out.println(new String(endata));
		byte[] dedata = PBEUtils.decrypt(endata);
		System.out.println(new String(dedata));
		
		System.out.println(str);
		String endata1 = PBEUtils.encrypt(str);
		System.out.println(endata1);
		String dedata2 = PBEUtils.decrypt(endata1);
		System.out.println(new String(dedata2));
	}

}
