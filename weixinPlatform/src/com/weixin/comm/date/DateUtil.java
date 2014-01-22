package com.weixin.comm.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

import com.weixin.comm.text.TextUtil;
/**
 * 日期处理工具类
 * 
 * @author JINLONG
 */

public class DateUtil {
	public static final String patternDate = "yyyy-MM-dd";
	public static final String patternDateEN = "MM/dd/yyyy";
	public static final String patternDateTime = "yyyy-MM-dd HH:mm:ss";
	public static final String patternDateTimeCompact = "yyyyMMddHHmmss";
	public static final String patternDateTimeCompactMilli= "yyyyMMddHHmmssSS";	
	public static final String patternMonthday = "MM-dd";
	public static final String lucenedate = "yyyyMMdd";
	private static final DateFormat PSUEDO_ISO8601_DATETIME_FORMAT_TZ = new SimpleDateFormat(
			"yyyy-MM-dd'T'HHmmssZ");
	public final static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy/MM/dd");
	public static Date BEGIN = null;
	public static Date END = null;
	/**
	 * 计算总月数
	 * 
	 * @param startYear
	 *            开始年份
	 * @param startMonth
	 *            开始月份
	 * @param endYear
	 *            接收年份
	 * @param endMonth
	 *            结束月份
	 * @return 从开始年份的开始月份到接收年份的结束月份的总月数
	 */
	public static int findTotalMonth(Integer startYear, Short startMonth,
			Integer endYear, Short endMonth) {
		if (endYear == null || endYear == 9999) {
			Calendar c = Calendar.getInstance();
			endYear = c.get(Calendar.YEAR);
			endMonth = (short) c.get(Calendar.MONTH);
		}
		int yearSpan = endYear - startYear;
		int monthSpan = endMonth - startMonth;
		if (yearSpan < 0) {
			return 0;
		}
		int months = yearSpan * 12 + monthSpan;
		return months;
	}

	/**
	 * 取本周的最后一天的字符串
	 * 
	 * @return
	 */
	public static String getLastDayOfWeek() {
		Calendar sunday = Calendar.getInstance();
		String endTime = toDate(getDayOfWeek(sunday, Calendar.SUNDAY))
				.toString() + " 23:59:59";
		return endTime;
	}

	/**
	 * 取本周的第一天的字符串
	 * 
	 * @return
	 */
	public static String getFirstDayOfWeek() {
		Calendar monday = Calendar.getInstance();
		String startTime = toDate(getDayOfWeek(monday, Calendar.MONDAY))
				.toString() + " 00:00:00";
		return startTime;
	}

	public static java.sql.Date toDate(Calendar c) {
		return new java.sql.Date(c.getTimeInMillis());
	}

	private static Calendar getDayOfWeek(Calendar day, int dayOfWeek) {
		int week = day.get(Calendar.DAY_OF_WEEK);
		if (week == dayOfWeek)
			return day;
		int diffDay = dayOfWeek - week;
		if (week == Calendar.SUNDAY) {
			diffDay -= 7;
		} else if (dayOfWeek == Calendar.SUNDAY) {
			diffDay += 7;
		}
		day.add(Calendar.DATE, diffDay);
		return day;
	}

	/**
	 * 取当前月份的第一天的日志格式字符串
	 * 
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(now) + "-01 00:00:00";
	}

	/**
	 * 取当前月份的最后一天的日志格式字符串
	 * 
	 * @return
	 */
	public static String getLastDayOfMonth() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String lastDay = df.format(cal.getTime());
		return lastDay + " 23:59:59";
	}

	/**
	 * 取当前小时数，格式为：HH(24小时制度)
	 * 
	 * @return
	 */
	public static String getCurrTimeHour() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("HH");
		return df.format(now);
	}

	/**
	 * 获取今天的日志字符传格式为：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getToday() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(now);
		return today;
	}

	/**
	 * 获取昨天的日志字符传格式为：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYesterday() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, -1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String yesterday = df.format(cal.getTime());
		return yesterday;
	}

	/**
	 * 当前时间加N个月
	 * 
	 * @param months
	 *            需要加的小时数，可以是负数，相应的减少
	 * @return
	 */
	public static Timestamp getNowAddNMonths(int months) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MONTH, months);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		return ts;
	}

	/**
	 * 当前时间加N天
	 * 
	 * @param days
	 *            需要加的小时数，可以是负数，相应的减少
	 * @return
	 */
	public static Timestamp getNowAddNDays(int days) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, days);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = null;
		ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		return ts;
	}

	/**
	 * 当前时间加N小时
	 * 
	 * @param hours
	 *            需要加的小时数，可以是负数，相应的减少
	 * @return
	 */
	public static Timestamp getNowAddNHours(int hours) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.HOUR_OF_DAY, hours);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		System.out.println(lastDay);
		return ts;
	}

	/**
	 * 当前时间加N分钟
	 * 
	 * @param minutes
	 *            需要加的分钟值，可以是负数，相应的减少
	 * @return
	 */
	public static Timestamp getNowAddNMinute(int minutes) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, minutes);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		return ts;
	}

	/**
	 * 时间比较大小
	 * 
	 * @param begintTime
	 *            时间1
	 * @param endTime
	 *            时间2
	 * @return 0:两个时间相等；1:时间2大于时间1；2:时间1大于时间2
	 */
	public static int timesContrast(Timestamp begintTime, Timestamp endTime) {
		long begin = begintTime.getTime();
		long end = endTime.getTime();
		int result = 0;
		if (end == begin) {
			result = 0;
		} else if (begin < end) {
			result = 1;
		} else if (begin > end) {
			result = 2;
		}
		return result;
	}

	/**
	 * 从long转换到时间格式字符串
	 * 
	 * @param times
	 * @return
	 */
	public static String getLongToDateStr(long times) {
		Date now = new Date(times);
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		return lastDay;
	}

	/**
	 * 取当前时间
	 * 
	 * @return
	 */
	public static Timestamp getNow() {
		return new Timestamp(new Date().getTime());
	}

	public static String getYear() {
		SimpleDateFormat sy = new SimpleDateFormat("yyyy");
		return sy.format(new Date());

	}

	public static Date getDateTimeByString(String dtstring) {
		return getDate(dtstring, patternDateTime);
	}

	public static Date getDateByString(String dtstring) {
		return getDate(dtstring, patternDate);
	}

	public static Date getDate(String dtstring, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = df.parse(dtstring);
		} catch (Exception e) {
		}
		return d;
	}

	public static Date getDate(String dtstring) {
		DateFormat df = new SimpleDateFormat(patternDateTime);
		Date d = null;
		try {
			d = df.parse(dtstring);
		} catch (Exception e) {
		}
		return d;
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}

	public static String formatDate(Date date) {
		return format.format(date);
	}

	public static Timestamp getTimestamp(String date, String pattern) {

		Date dd = getDate(date, pattern);
		return new Timestamp(dd.getTime());
	}

	/**
	 * 
	 * 2011-1-11
	 * 
	 * @param date
	 * @param reg
	 *            #精确到时�?
	 * @return
	 */
	public static String getPrettyDate(Date date, String reg) {
		// return new PrettyDateFormat("#h�?, "hh:mm").format(date);
		long curTime = System.currentTimeMillis();

		long diffDay = 0L;
		long diffSecond = 0L;
		String replacement = "";
		diffSecond = (curTime - date.getTime()) / 1000L;
		Calendar curDate = new GregorianCalendar();
		curDate.setTime(new Date(curTime));
		curDate.set(Calendar.HOUR_OF_DAY, 23);
		curDate.set(Calendar.MINUTE, 59);
		curDate.set(Calendar.SECOND, 59);
		curDate.set(Calendar.MILLISECOND, 999);
		diffDay = (curDate.getTimeInMillis() - date.getTime()) / 86400000L;
		String beforesecond = getText("common.beforesecond");
		String beforeminute = getText("common.beforeminute");
		String beforehour = getText("common.beforehour");
		String beforeday = getText("common.beforeday");

		SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
		if (diffDay == 0) {
			if (diffSecond < 60) {
				if (diffSecond >= 2) {
					beforesecond = getText("common.beforeseconds");
				}
				replacement = diffSecond == 0 ? "1" + beforesecond : diffSecond
						+ beforesecond;
			} else if (diffSecond < 3600) {
				if ((diffSecond / 60) >= 2) {
					beforeminute = getText("common.beforeminutes");
				}
				replacement = diffSecond / 60 + beforeminute;
			} else if (diffSecond < 86400) {
				if ((diffSecond / 3600) >= 2) {
					beforehour = getText("common.beforehours");
				}
				replacement = diffSecond / 3600 + beforehour;
			}
		} else if (diffDay <= 7) {
			if (diffDay >= 2) {
				beforeday = getText("common.beforedays");
			}
			if ("#".equals(reg)) {
				replacement = diffDay + beforeday + sf.format(date);
			} else {
				replacement = diffDay + beforeday;
			}
		} else {
			replacement = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
		}

		return replacement;
	}

	/**
	 * Bing "#aH�? 省略今天 "##aH�? 包含今天 �?��钟内：xxx秒前 �?��时内：xxx分钟�? 24小时内：xxx小时�?
	 * 7天以内：x天前 HH:ii 7天以外：YYYY-mm-dd HH:ii return
	 * 
	 * @param date
	 * @return
	 */
	public static String getPrettyDate(Date date) {
		return getPrettyDate(date, "#");
	}

	/**
	 * Bing 2009-11-16 calculate the begin date and end date of last week
	 * example: <code>
	 *      String date="2009-10-23 14:33:00";
	 *      Calendar c1 = Calendar.getInstance();
			c1.setTime(sf.parse(date));
			DateUtil.calcLastWeek(c1);
			System.out.println(DateUtil.BEGIN);
			System.out.println(DateUtil.END);
			</code>
	 * 
	 * @see DateUtil.Begin ,DateUtil.END
	 * @param calendar
	 */
	public static void calcLastWeek(Calendar calendar) {
		int minus = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DATE, -minus);
		END = new Date(calendar.getTime().getTime());
		calendar.add(Calendar.DATE, -6);
		BEGIN = new Date(calendar.getTime().getTime());
	}

	/**
	 * 2009-11-27 calculate the begin date and end date of current week which
	 * come from the param date example: <code>
	 *      SimpleDateFormat  sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 *      long curTime = System.currentTimeMillis();   
		    Date date2 = new Date(curTime - 3600 * 1000L * 24 * 10);
			DateUtil.calcCurrentWeek(date2);
			System.out.println(sf.format(DateUtil.BEGIN)+"   "+sf.format(DateUtil.END));
			</code>
	 * 
	 * @param date
	 * @see DateUtil.Begin ,DateUtil.END
	 */
	public static void calcCurrentWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int weekday = c.get(7) - 1;
		c.add(5, -weekday);
		Date beginday = date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fristDateOfMonth = getFristDateOfMonth(date);
		if (beginday.before(fristDateOfMonth)) {
			beginday = fristDateOfMonth;
		}
		c.add(5, 6);
		Date endday = date;
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date lastDateOfMonth = getLastDateOfMonth(date);
		if (endday.after(lastDateOfMonth)) {
			endday = lastDateOfMonth;
		}
		DateUtil.BEGIN = beginday;
		DateUtil.END = endday;
	}

	/**
	 * 下一�? 返回下周的开始日期和结束日期 2010-12-29
	 * 
	 * @param date
	 * @see DateUtil.Begin ,DateUtil.END
	 */
	public static void calcNextWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		c.add(5, 7 - weekday);
		Date beginday = date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fristDateOfMonth = getFristDateOfMonth(date);
		if (beginday.before(fristDateOfMonth)) {
			beginday = fristDateOfMonth;
		}
		c.setTime(beginday);
		Date endday = date;
		c.add(5, 6);
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date lastDateOfMonth = getLastDateOfMonth(beginday);
		if (endday.after(lastDateOfMonth)) {
			endday = lastDateOfMonth;
		}
		DateUtil.BEGIN = beginday;
		DateUtil.END = endday;
	}

	/**
	 * 日期是否在本�? 2010-12-29
	 * 
	 * @param date
	 * @return
	 */
	public static boolean inCurrentWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int weekday = c.get(7) - 1;
		c.add(5, -weekday);
		Date beginday = date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fristDateOfMonth = getFristDateOfMonth(date);
		if (beginday.before(fristDateOfMonth)) {
			beginday = fristDateOfMonth;
		}
		c.add(5, 6);
		Date endday = date;
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date lastDateOfMonth = getLastDateOfMonth(date);
		if (endday.after(lastDateOfMonth)) {
			endday = lastDateOfMonth;
		}
		if ((beginday.compareTo(date) <= 0 && endday.after(date))
				|| (endday.compareTo(date) >= 0 && beginday.before(date))) {
			return true;
		}
		return false;
	}

	/**
	 * 得到本月�?���?��
	 * 
	 * @return
	 */
	public static Date getLastDateOfMonth(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (dt == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到本月第一�?
	 * 
	 * @return
	 */
	public static Date getFristDateOfMonth(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (dt == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int days = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String getText(String key) {
		// String language = System.getProperty("user.language");
		// String country = System.getProperty("user.country");
		// Locale locale=new Locale(language,country);
		// System.out.println(locale);
		// ResourceBundle
		// bundle=ResourceBundle.getBundle("messageResource",Locale.getDefault());
		// return bundle.getString(key);
		// if(LocaleUtil.getUserLocale().equalsIgnoreCase("en_US"))
		// {
		// return " "+TextUtil.getText(key);
		// }
		return TextUtil.getText(key);
	}

	/**
	 * recent days
	 * 
	 * @param days
	 * @return
	 */
	public static Date getRecentDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date date = cal.getTime();
		cal.add(Calendar.DATE, -days);
		date = cal.getTime();
		return date;
	}

	public static Timestamp addDate(Timestamp date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = null;
		ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		return ts;
	}

	public static List<String> getCurrentWeek() {
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		list.add(format.format(calendar.getTime()));
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		list.add(0, format.format(calendar.getTime()));

		return list;
	}

	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public static int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		return day;
	}

	public static int getDayOfWeek(String date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.getDateByString(date));
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		return day;
	}

	// ISO8601
	public static String toIso8601DateTime(Date dateTime) {
		if (dateTime == null)
			return null;
		StringBuilder psuedoIso8601DateTime = new StringBuilder(
				PSUEDO_ISO8601_DATETIME_FORMAT_TZ.format(dateTime));
		String iso8601DateTime = psuedoIso8601DateTime.insert(
				psuedoIso8601DateTime.length() - 2, ':').toString();
		return iso8601DateTime;
	}

	/*
	 * 时间比较大小
	 */
	public static int compareDateToDate(Timestamp datea, Timestamp dateab) {
		int temp = 1;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		try {
			a.setTime(df.parse(datea + ""));
			b.setTime(df.parse(dateab + ""));
		} catch (java.text.ParseException e) {
			System.err.println("格式不正确");
		}
		int result = a.compareTo(b);
		if (result == 0)
			temp = 1;// a=b等于
		else if (result < 0)
			temp = 2;// a小于b
		else
			temp = 3;// a大于b
		return temp;
	}

	/*
	 * 时间比较大小
	 */
	public static int compareDateToDate(Date datea, Date dateab) {
		int temp = 1;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		try {
			a.setTime(df.parse(datea + ""));
			b.setTime(df.parse(dateab + ""));
		} catch (java.text.ParseException e) {
			System.err.println("格式不正确");
		}
		int result = a.compareTo(b);
		if (result == 0)
			temp = 1;// a=b等于
		else if (result < 0)
			temp = 2;// a小于b
		else
			temp = 3;// a大于b
		return temp;
	}

	public static String lastDayOfWeek() {
		Calendar sunday = Calendar.getInstance();
		String endTime = toDate(getDayOfWeek(sunday, Calendar.SUNDAY))
				.toString() + " 23:59:59";
		return endTime;
	}

	public static String firstDayOfWeek() {
		Calendar monday = Calendar.getInstance();
		String startTime = toDate(getDayOfWeek(monday, Calendar.MONDAY))
				.toString() + " 23:59:59";
		return startTime;
	}

	// 当前日期减7天
	public static String getFormerlySevenDay() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, -7);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		return lastDay;
	}

	public static String firstDayOfMonth() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(now).substring(0, 7) + "-01 00:00:00";
	}

	public static String currentTimeString() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(now).substring(0, 10);
	}

	public static String lastDayOfMonth() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		return lastDay.substring(0, 10) + " 23:59:59";
	}
	
	/**
	 * 格式化返回日期+时间到毫秒
	 * @return
	 */
	public static String timeFilName() {
		SimpleDateFormat sdf = new SimpleDateFormat("",	Locale.SIMPLIFIED_CHINESE);	sdf.applyPattern(patternDateTimeCompactMilli);
		return sdf.format(System.currentTimeMillis());
	}

	// 当前日期加N天
	public static Timestamp getFormerlyNDay(int nDay) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, nDay);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastDay = df.format(cal.getTime());
		Timestamp ts = null;
		ts = new Timestamp(Timestamp.valueOf(lastDay).getTime());
		return ts;
	}

	public static int timeCompare(Timestamp begintTime, Timestamp endTime) {
		long begin = begintTime.getTime();
		long end = endTime.getTime();
		int result = 0;
		if (end == begin) {
			result = 0;
		} else if (begin < end) {
			result = 1;
		} else if (begin > end) {
			result = 2;
		}
		return result;
	}

	public static String getFormatStr(String formatStr,
			java.sql.Timestamp nowTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String ymd = sdf.format(nowTime);
		return ymd;
	}

	public static String getFormatStr(String formatStr, Date nowTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String ymd = sdf.format(nowTime);
		return ymd;
	}

	public static String gettimestamp() {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(now);
	}

	public static Date getStringToDate(String formatStr, String dateStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 重新调整日期工具类
	 */
	/**
	 * Adds	 a number of days to a date returning a new object.
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDays(Date date,	 int amount) {
		return DateUtils.addDays(date, amount);
	}
	          
	/**
	 * Adds	 a number of hours to a date returning a new object.
	 */
	public static Date addHours(Date date,int amount){
		return DateUtils.addHours(date, amount);
	}
	/**
	 * Adds	 a number of milliseconds to a date returning a new object.
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMilliseconds(Date date,int amount){
		return DateUtils.addMilliseconds(date, amount);
	}
	
	public static Date addMinutes(Date date,int amount){
		return DateUtils.addMinutes(date, amount);
	}
	
	public static Date addMonths(Date date,int amount){
		return DateUtils.addMonths(date, amount);
	}
	
	public static Date addSeconds(Date date,int amount){
		return DateUtils.addSeconds(date, amount);
	}
	/**
	 * Adds	 a number of weeks to a date returning a new object.
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addWeeks(Date date,	 int amount){
		return DateUtils.addWeeks(date, amount);
	}
	          
	/**
	 * Adds	 a number of years to a date returning a new object.
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addYears(Date date,int amount){
		return DateUtils.addYears(date, amount);
	}
	 /**
	  *   Checks if two date objects are on the same day ignoring time.
	  * @param date1
	  * @param date2
	  * @return
	  */
	public static boolean isSameDay(Date date1,Date date2){
		return DateUtils.isSameDay(date1, date2);
	}
	/**
	 *  Checks	if two date objects represent the same instant in time.
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameInstant(Date date1,Date date2){
		return DateUtils.isSameInstant(date1, date2);
	}

	public static void main(String[] args) {
		Date date= new Date();
		System.out.println(DateUtils.addHours(date,1));
        System.out.println(DateUtils.ceiling(date, Calendar.MINUTE));
        System.out.println(DateUtils.RANGE_MONTH_MONDAY);
        System.out.println(DateUtils.RANGE_WEEK_SUNDAY);
        System.out.println(DateUtils.truncate(date, DateUtils.RANGE_WEEK_SUNDAY));
    	Date date1= new Date();
    	System.out.println(DateUtils.truncatedCompareTo(date, date1, Calendar.MILLISECOND));
	}
}