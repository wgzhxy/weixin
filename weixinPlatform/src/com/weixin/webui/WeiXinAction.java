package com.weixin.webui;

import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.bouncycastle.util.encoders.Hex;
import com.weixin.datacore.domain.weixin.model.WeChatReqBean;
import com.weixin.webui.core.BaseAction;
import cn.easytom.comm.logs.LogUtil;
import cn.easytom.comm.security.SHACoder;
import cn.easytom.comm.text.TextUtil;

@SuppressWarnings("serial")
public class WeiXinAction extends BaseAction {
	
	/**
	 * 认证处理，判断消息来源是否来至微信公众平台
	 * 
	 * @return
	 */
	public boolean security() {
		LogUtil.info("[" + timestamp + "," + nonce + "," + echostr + "," + signature + "]");
		ArrayList<String> list = new ArrayList<String>();
		list.add(timestamp);
		list.add(nonce);
		list.add(TextUtil.getText("weixin.token"));
		Collections.sort(list);
		String secutiry_str = "";
		for (String tmp : list) {
			secutiry_str += tmp;
		}
		byte[] buffer = null;
		try {
			buffer = SHACoder.encodeSHA(secutiry_str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (buffer != null) {
			String hex_str = new String(Hex.encode(buffer));
			LogUtil.info("[" + timestamp + "," + nonce + "," + echostr + "]," + hex_str + "," + signature);
			if (hex_str.equals(signature)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	public String RecvWeiXinMsg() {
		if (security() && echostr != null && !echostr.equals("")) {
			this.msg = echostr;
			return INPUT;
		}
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		Scanner scanner = null;
		PrintWriter out = null;
		try {
			scanner = new Scanner(request.getInputStream(), "UTF-8");
			response.setContentType("application/xml");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();

			// 1、获取用户发送的信息
			StringBuffer sb = new StringBuffer(100);
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine());
			}

			// 2、解析用户的信息
			JAXBContext jc = JAXBContext.newInstance(WeChatReqBean.class);
			Unmarshaller u = jc.createUnmarshaller();
			WeChatReqBean reqBean = (WeChatReqBean) u.unmarshal(new StringReader(sb.toString()));
			if (reqBean != null) {
				/**
				 * 暂时记录用户信息至日志，后续考虑存储
				 */
				StringBuffer logs = new StringBuffer();
				logs.append(reqBean.getFromUserName() + ",");
				logs.append(reqBean.getToUserName() + ",");
				logs.append(reqBean.getContent() + ",");
				logs.append(reqBean.getMsgType() + ",");
				logs.append(reqBean.getMsgId() + ",");
				logs.append(reqBean.getCreateTime());
				LogUtil.info(logs.toString());
			}

			// 3、获取用户的消息内容并返回相关信息
			//weiXinComponent.clientCommandOperation(reqBean, out);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
				scanner = null;
			}

		}
		return null;
	}
	
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	private String msg;
}
