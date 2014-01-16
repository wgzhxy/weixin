/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.weixin.webui.core;  

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import cn.easytom.comm.logs.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * 公用控制层基类，用于封装控制层公共方法或类<br/>
 * 以便在派生类中可以使用，减少必要的定义，提供统一的方法或属性定义入口<br/>
 * </p>
 * 
 * @category 控制层公用基类
 * @author wang.g.z
 * @since 1.0
 * @time 2013.04.23
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;
	private static final String CharacterEncoding = "UTF-8";
	protected boolean zip = false;
	protected String basePath = getRequest().getContextPath();
	protected String tips = "";
	protected int pageNum = 1;
	protected int pageSize = 15;
	public HttpServletRequest request;
	public HttpServletResponse response;
	protected int page = 1;
	protected int rows = 10;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 【获得Request请求对象】
	 * 
	 * @return（HttpServletRequest对象）
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding(CharacterEncoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return request;
	}

	/**
	 * 【获得Response响应对象】
	 * 
	 * @return (HttpServletResponse对象)
	 */
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding(CharacterEncoding);
		response.setContentType("text/html;charset=" + CharacterEncoding);
		return response;
	}

	/**
	 * 【获得Response响应对象, 返回相关数据】
	 * 
	 * @return
	 */
	public void writeResult(String reuslt, String charSet) {

		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding(CharacterEncoding);
			response.setContentType("text/html;charset=" + CharacterEncoding);
			response.getOutputStream().write(reuslt.getBytes(charSet));
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.info(this, e);
		} finally {
			try {
				if (response.getOutputStream() != null) {
					response.getOutputStream().close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				LogUtil.info(this, e);
			}
		}
	}

	/**
	 * 【获得Response响应对象, 返回相关数据】
	 * 
	 * @return
	 */
	public void writeResult(String reuslt) {

		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding(CharacterEncoding);
			response.setContentType("text/html;charset=" + CharacterEncoding);
			response.getOutputStream().write(reuslt.getBytes(CharacterEncoding));
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.info(this, e);
		} finally {
			try {
				if (response.getOutputStream() != null) {
					response.getOutputStream().close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				LogUtil.info(this, e);
			}
		}
	}

	/**
	 * 【获得Session会话对象】
	 * 
	 * @return（HttpSession对象）
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 设置Request的Attribute函数
	 * 
	 * @param key
	 * @param value
	 */
	public void setRequestAttribute(String key, Object value) {
		this.getRequest().setAttribute(key, value);
	}

	/**
	 * 取得Request的Attribute存储值
	 * 
	 * @param key
	 * @return
	 */
	public Object getRequestAttribute(String key) {
		return this.getRequest().getAttribute(key);
	}

	/**
	 * 取得Request的Parameter存储值
	 * 
	 * @param key
	 * @return
	 */
	public String getRequestParameter(String key) {
		return this.getRequest().getParameter(key);
	}

	/**
	 * 设置Session的Attribute函数
	 * 
	 * @param key
	 * @param value
	 */
	public void setSessionAttribute(String key, Object value) {
		this.getSession().setAttribute(key, value);
	}

	/**
	 * 取得Session的Attribute存储值
	 * 
	 * @param key
	 * @return
	 */
	public Object getSessionAttribute(String key) {
		return this.getSession().getAttribute(key);
	}

	/**
	 * 【取得ServletContext对象】
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getBasePath() {
		return request.getScheme() + "://" + request.getServerName()
				+ (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath();
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public boolean isZip() {
		return zip;
	}

	public void setZip(boolean zip) {
		this.zip = zip;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}