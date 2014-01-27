package com.weixin.component.weixin;

import com.weixin.datacore.domain.weixin.vo.SubscribeUserInfoVo;

/**
 * 公共的组件调用方法
 * @author JINLONE
 *
 */
public interface CommonComponent {
	/**
	 * 取访问的token
	 * @param appid 第三方用户唯一凭证
	 * @param secret 第三方用户唯一凭证密钥,即appsecret
	 * @return
	 */
	public String getAccessToken(final String appid,final String secret);
	/**
	 * 通过openid获取订阅用户的详细信息
	 * @param openid
	 * @return
	 */
	public SubscribeUserInfoVo getSubscribeUserInfoByOpenId(final String openid);
	/**
	 * 验证消息的来源合法性 
	 * @param token
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param signature
	 * @return
	 * 加密/校验流程如下：
		1. 将token、timestamp、nonce三个参数进行字典序排序
		2. 将三个参数字符串拼接成一个字符串进行sha1加密
		3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 */
	public boolean checkSignature(final String token,final String timestamp,final String nonce,final String signature,final String echostr);
}