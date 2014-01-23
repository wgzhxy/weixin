package com.weixin.component.webchat.impl;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import com.weixin.comm.http.HttpClientUtils;
import com.weixin.comm.http.HttpResponseParser;
import com.weixin.component.webchat.MenuManagerComponent;
import net.sf.json.JSONObject;
/**
 * 菜单操作的调用方法
 * @author JINLONE
 *
 */
public class MenuManagerComponentImpl implements MenuManagerComponent{
	
		private static final String CREATE_MENU_URL=" https://api.weixin.qq.com/cgi-bin/menu/create";
		private static final String DELETE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/delete";
		private static final String GET_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/get";
		/**
		 * 创建菜单
		 * @param accessToken
		 * @param jsonStr
		 * @return
		 */
		public boolean createMenu(final String accessToken,final String jsonStr){
			return Boolean.TRUE;
		}
		
		/**
		 * 删除菜单
		 * @param accessToken
		 * @return
		 */
		public boolean deleteMenu(final String accessToken){
			String result="";
			StringBuffer sb=new StringBuffer();
			sb.append(DELETE_MENU_URL);
			sb.append("access_token="+accessToken);
			HttpClient client = HttpClientUtils.getHttpClient();
			HttpGet httpGet = new HttpGet(sb.toString());
			HttpResponse response;
			try {
				response = client.execute(httpGet);
				result=HttpResponseParser.ResponseParserToString(response);
				JSONObject jsonObject=JSONObject.fromObject(result);
				String errcode=jsonObject.getString("errcode");
				String errmsg=jsonObject.getString("errmsg");
				if(errcode.equals("0")&&errmsg.equals("ok")){
					return Boolean.TRUE;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Boolean.FALSE;
		}
		
		/**
		 * 取得线上菜单信息
		 * @param accessToken
		 * @return
		 */
		public JSONObject getMenu(final String accessToken){
			String result="";
			StringBuffer sb=new StringBuffer();
			sb.append(GET_MENU_URL);
			sb.append("access_token="+accessToken);
			HttpClient client = HttpClientUtils.getHttpClient();
			HttpGet httpGet = new HttpGet(sb.toString());
			HttpResponse response;
			try {
				response = client.execute(httpGet);
				result=HttpResponseParser.ResponseParserToString(response);
				JSONObject jsonObject=JSONObject.fromObject(result);
				return jsonObject;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}