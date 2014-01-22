/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
*****************************************************************************/

package com.weixin.comm.secutiry;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import com.weixin.comm.exception.TokenInvalidateException;
import com.weixin.comm.exception.TokenOvertimeException;
import com.weixin.comm.text.TextUtil;
/**
 * token工具类
 * @author Wang.g.z
 *
 */
public class TokenUtils {
	
	final static long expireDate = 1000 * 60 * 2; //两分钟的token超时
	
	/**
	 * 根据主机ip, 用户帐号，密码生成token值
	 * @param ip
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String createToken(String ip, String userName, String password) throws Exception {
		if(StringUtils.isEmpty(ip)) {
			throw new Exception("ip地址不能为空!");
		}
		if(StringUtils.isEmpty(userName)) {
			throw new Exception("用户帐号地址不能为空!");
		}
		if(StringUtils.isEmpty(password)) {
			throw new Exception("用户密码地址不能为空!");
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(ip).append("$").append(userName).append("$").append(password);
		return SHACoder.encodeSHA224Hex(buffer.toString().getBytes());
	}
	
	/**
	 * 生成客户端验证token值
	 * @param token 为服务端生成的token值(根据ip,userName, password生成的token值)
	 * @return
	 * @throws Exception
	 */
	public static String createClientToken(String serverToken) throws TokenInvalidateException {
		if(StringUtils.isEmpty(serverToken)) {
			throw new TokenInvalidateException("服务端token不能为空!");
		}
		long timestamp = System.currentTimeMillis() + expireDate;
		StringBuffer buffer = new StringBuffer();
		buffer.append(Math.random() * 10000).append("|||").append(serverToken).append("|||").append(timestamp);
		return Hex.encodeHexString(PBEUtils.encrypt(buffer.toString().getBytes()));
	}
	
	/**
	 * 验证客户端token值是否有效
	 * @param token 为客户端生成token值
	 * @return
	 * @throws DecoderException 
	 * @throws Exception
	 */
	public static boolean isToken(String clientToken) throws TokenInvalidateException, TokenOvertimeException {
		if(StringUtils.isEmpty(clientToken)) {
			throw new TokenInvalidateException("客户端token不能为空!");
		}
		String[] str = null;
		try{
			String token = new String(PBEUtils.decrypt(Hex.decodeHex(clientToken.toCharArray())));
			str = token.split("\\|\\|\\|");
		} catch (Exception e) {
			throw new TokenInvalidateException("客户端token信息错误!");
		}
		if(str != null && str.length == 3) {
			if(str[1].length() == 56 && StringUtils.contains(TextUtil.getText("server_token"), str[1])) {
				long timestamp = Long.parseLong(str[2]);
				if(timestamp >= System.currentTimeMillis()) {
					return true;
				} else {
					throw new TokenOvertimeException("客户端时间缀超时!");
				}
			} else {
				throw new TokenInvalidateException("客户端token不存在!");
			}
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			// TODO Auto-generated method stub
			while(true) {
				long begin = System.currentTimeMillis();
				System.out.println(begin);
				String clientToken = TokenUtils.createClientToken("2fdfa0c62db55b4970eccfbca033eb021305acf85f50ae801c4a2571");
				System.out.println(clientToken);
				System.out.println(TokenUtils.isToken(clientToken));
				System.out.println(System.currentTimeMillis() - begin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
