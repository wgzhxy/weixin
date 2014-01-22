package com.weixin.comm.secutiry;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;


/**
 * DES 加密算法
 * @author JINLONG
 *
 */
public class DesCoder {
	
	public static final String KEY = "yztctc12";
	/*
	 * 定义加密偏移常量
	 */
	private static byte[] iv1 = { (byte) 0x12, (byte) 0x34, (byte) 0x56,
			(byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
	/*
	 * 加密算法
	 */
	private static byte[] desEncrypt(byte[] plainText, String keys) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(iv1);
		DESKeySpec dks = new DESKeySpec(keys.getBytes("ASCII"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte data[] = plainText;
		byte encryptedData[] = cipher.doFinal(data);
		return encryptedData;
	}

	/*
	 * 解密算法
	 */
	private static byte[] desDecrypt(String plainText, String keys) throws Exception {
		byte[] decryptedData = null;
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(keys.getBytes("ASCII"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(iv1);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte data[] = base64Decoder(plainText);
		decryptedData = cipher.doFinal(data);
		return decryptedData;
	}

	/*
	 * 加密算法，传人需要加密的字符串和KEY进行加密，返回加密后的字符串
	 */
	public static String encrypt(String input, String keys) {
		if (keys.length() > 8) {
			keys = keys.substring(0, 8);
		}
		String result = "input";
		try {
			result = base64Encode(desEncrypt(input.getBytes(), keys));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 解密算法，传人需要解密的字符串和KEY进行解密，返回解密后的字符串
	 */
	public static String decrypt(String output, String keys) {
		if (keys.length() > 8) {
			keys = keys.substring(0, 8);
		}
		String decryptstr = null;
		try {
			decryptstr = new String(desDecrypt(output, keys));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return decryptstr;
	}

	// 对base64编码的string加密成字符串
	private static String base64Encode(byte[] outputBytes) {
		if (outputBytes == null)
			return null;
		String base64 = Base64.encode(outputBytes);
		return base64;
	}

	// 对base64编码的string解码成byte数组
	private static byte[] base64Decoder(String str) {
		if (str == null)
			return null;
		try {
			byte[] b = Base64.decode(str);
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStr2ByteArr(String strIn) 互为可逆的转换过程
	 */
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/*
	 * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 */
	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}
	
	/*
	 * 将工行卡号转换成10位的字符串
	 */
	public static String toHexString(String str){
		try{
			StringBuffer s=new StringBuffer();
			StringBuffer s1=new StringBuffer();
			if(null ==str||str.length()<16){
				return "";
			}
			s.append(Integer.toHexString(Integer.parseInt(str.substring(4, 10))).toUpperCase());
			s1.append(Integer.toHexString(Integer.parseInt(str.substring(10, 16))).toUpperCase());
			int j=s.length();
			if(j<5){
				for(int i=0;i<5-j;i++){
					s.insert(i, "0");
				}
			}
			j=s1.length();
			if(j<5){
				for(int i=0;i<5-j;i++){
					s1.insert(i, "0");
				}
			}
			return s.insert(0, "D").append(s1).toString();
					
					
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * ECB解密,不要IV
	 * 
	 * @param key
	 *            密钥
	 * @param data
	 *            Base64编码的密文
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] ees3DecodeECB(byte[] key, byte[] data)
			throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, deskey);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}
	
	/**
	 * ECB解密,不要IV
	 * 
	 * @param key
	 *            密钥
	 * @param data
	 *            Base64编码的密文
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] ees3EncodeECB(byte[] key, byte[] data)
			throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, deskey);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}
	
	/**
	 * ECB解密,不要IV,用于资源管理系统，RFID卡管理解密
	 * 	 
	 * @param data
	 *            
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] ees3DecodeECB(String str)
			throws Exception {
		byte[] key = org.apache.commons.codec.binary.Base64.decodeBase64("WWJjZGVmZ8hpamtsbW5vcHFyc3R1dnd8");
		byte[] data =org.apache.commons.codec.binary.Base64.decodeBase64(str);
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, deskey);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}
}
