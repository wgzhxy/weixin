/******************************************************************************
 * Copyright (C) 2013 SiFangDingLi Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.weixin.comm.logs;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.weixin.comm.date.DateUtil;

/**
 * 用于记录日志
 * 
 * @author JINLONG
 */
public class LogUtil {

	private static final String LINE_SEP = System.getProperty("line.separator");
	private static final int LINE_SEP_LEN = LINE_SEP.length();
	private static final String str = LogUtil.class.getName();

	@SuppressWarnings("unused")
	private static String getLocationInfo(Throwable t, String fqnOfCallingClass) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		if (t == null) {
			return null;
		}
		String s;
		synchronized (sw) {
			t.printStackTrace(pw);
			s = sw.toString();
			sw.getBuffer().setLength(0);
		}

		int ibegin;
		int iend;

		ibegin = s.lastIndexOf(fqnOfCallingClass);
		if (ibegin == -1) {
			return null;
		}
		ibegin = s.indexOf(LINE_SEP, ibegin);
		if (ibegin == -1) {
			return null;
		}
		ibegin += LINE_SEP_LEN;
		iend = s.indexOf(LINE_SEP, ibegin);
		if (iend == -1) {
			return null;
		}
		if (true) {
			ibegin = s.lastIndexOf("at ", iend);
			if (ibegin == -1) {
				return null;
			}
			ibegin += 3;
		}
		String str1 = s.substring(ibegin, iend);
		String tempStr = str1.substring(0, str1.lastIndexOf("."));
		String resultStr = tempStr.substring(0, tempStr.lastIndexOf("."));
		return resultStr;
	}

	private static Logger getLog() {
		return Logger.getLogger(LogUtil.class);
	}

	public static void debug(Object obj) {
		debug(obj, null);
	}

	public static void debug(Object obj, Throwable throwable) {
		getLog().log(str, Level.DEBUG, obj, throwable);
	}

	public static void info(Object obj) {
		info(obj, null);
	}

	public static void info(Object obj, Throwable throwable) {
		getLog().log(str, Level.INFO, obj, throwable);
	}

	public static void warn(Object obj) {
		warn(obj, null);
	}

	public static void warn(Object obj, Throwable throwable) {
		getLog().log(str, Level.WARN, obj, throwable);
	}

	public static void error(Object obj) {
		error(obj, null);
	}

	public static void error(Object obj, Throwable throwable) {
		getLog().log(str, Level.ERROR, obj, throwable);
	}

	public static void fatal(Object obj) {
		fatal(obj, null);
	}

	public static void fatal(Object obj, Throwable throwable) {
		getLog().log(str, Level.FATAL, obj, throwable);
	}

	public static boolean isDebugEnabled() {
		return getLog().isEnabledFor(Level.DEBUG);
	}

	public static boolean isErrorEnabled() {
		return getLog().isEnabledFor(Level.ERROR);
	}

	public static boolean isFatalEnabled() {
		return getLog().isEnabledFor(Level.FATAL);
	}

	public static boolean isInfoEnabled() {
		return getLog().isEnabledFor(Level.INFO);
	}

	public static boolean isTraceEnabled() {
		return getLog().isEnabledFor(Level.DEBUG);
	}

	public static boolean isWarnEnabled() {
		return getLog().isEnabledFor(Level.WARN);
	}

	public static void trace(Object obj) {
		trace(obj, null);
	}

	public static void trace(Object obj, Throwable throwable) {
		getLog().log(str, Level.DEBUG, obj, throwable);
	}

	/**
	 * 格式化日志记录
	 * <P>
	 * ****注意:****<br/>
	 * codeName及remark中，不允计使用连接的四个空格，这应响日志信息的解析<br/>
	 * </p>
	 * 
	 * @param beginTime
	 *            代码块执行开始时间<br/>
	 *            取值 long beginTime = System.currentTimeMillis()<br/>
	 * @param endTime
	 *            代码块执行结束时间 long endTime = System.currentTimeMillis()
	 * @param codeName
	 *            代码块名称<br/>
	 *            或其它相关信息，用于识别不同代码块的执行时间<br/>
	 * @param remark
	 *            备注信息或关键信息
	 * @return 格式化日志信息
	 */
	public static String toStdLogString(long beginTime, long endTime, String codeName, String remark) 
	{
		return codeName 
				+ "    " + DateUtil.getLongToDateStr(beginTime)
				+ "    " + DateUtil.getLongToDateStr(endTime) + "    "
				+ (endTime - beginTime) + "ms" + "    " + remark;
	}

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		LogUtil.info(LogUtil.toStdLogString(beginTime, endTime, "LogUtil.main", "测试一下"));
	}
}