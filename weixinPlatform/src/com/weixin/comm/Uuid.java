package com.weixin.comm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.weixin.comm.logs.LogUtil;

public class Uuid {

	public static String getPrimaryKey() {
		UUID uuid = UUID.randomUUID(); 
		return uuid.toString().replaceAll("-","");    
	}
	
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<String, String>();
		while(true) {
			String uuid = getPrimaryKey();
			LogUtil.info(uuid);
			if(map.get(uuid) != null) {
				System.out.println("有相同的ID存在");
				break;
			}
			map.put(uuid, "0001");
		}
		System.out.println("a2e0e5ae5de040428d2785e68d54ee87".length());
	}
	
}
