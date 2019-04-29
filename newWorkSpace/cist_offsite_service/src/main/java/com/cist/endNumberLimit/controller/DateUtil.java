package com.cist.endNumberLimit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 日期的操作类,
 * 
 * @author xh
 *
 */
public class DateUtil {

	/**
	 * 缺省的时间格式
	 */
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String YMD_PATTERN = "yyyy-MM-dd ";
	private static final String US_PATTERN = "E MMM dd yyyy HH:mm:ss z";
	//
	// /**
	// * 采用格式yyyy-MM-dd对日期进行格式化
	// * @param date 格式:yyyy-MM-dd
	// * @return
	// * 格式:yyyy-MM-dd的日期字符串表示
	// */
	// public static String formatDate(Date date){
	// String pattern = "yyyy-MM-dd" ;
	// return formatDate(date , pattern) ;
	// }

	/**
	 * 对日期采用指定的格式进行格式化
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat df = null;
		if (pattern != null && !pattern.equals("")) {
			df = new SimpleDateFormat(pattern);
		} else {
			df = new SimpleDateFormat(DEFAULT_PATTERN);
		}
		return df.format(date);
	}

	/**
	 * 将字符串解析成日期对象
	 * 
	 * @param dateStr
	 *            日期的字符串表示形式
	 * @param pattern
	 *            日期的字符串表示形式的格式
	 * @return
	 */
	public static Date parse(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算两个时间间隔的天数, preDate是两个时间中靠前的时间, aftDate是两个时间中靠后的时间,
	 * 如果preDate在aftDate之后，则返回的天数为负数, 不满24小时按照一天的时间计算(忽略了时分秒), 例如：2010-03-01
	 * 23:59:59 和2010-03-02 00:00:00相隔的时间是1天
	 * 
	 * @param preDate
	 * @param aftDate
	 * @return
	 */
	public static int countDay2Date(Date preDate, Date aftDate) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(preDate);
		c2.setTime(aftDate);
		// 将时间c1和时间c2的时 分 秒 都去掉
		setTimeToMidnight(c1);
		setTimeToMidnight(c2);
		// 一天的时间的毫秒数 24*60*60*1000
		long minsPerDays = 86400000;
		int days = (int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / minsPerDays);
		return days;
	}

	/**
	 * 将时间的时分秒设置为00:00:00
	 * 
	 * @param c
	 */
	private static void setTimeToMidnight(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
	}

	/**
	 * 计算给定时间离当前时间的天数,date是定义为当前时间靠前的时间, 如果date在当前时间之后，则返回的天数为负数,
	 * 不满24小时按照一天的时间计算(忽略了时分秒), 例如：2010-03-01 23:59:59 和2010-03-02 00:00:00相隔的时间是1天
	 * 
	 * @param date
	 * @return 离当前时间的天数
	 */
	public static int countDay2Today(Date date) {
		return countDay2Date(date, new Date());
	}

	/**
	 * 将时间转化为Calendar形式
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar parseCalendar(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	/**
	 * 将日历转换为Date形式
	 * 
	 * @param c
	 * @return
	 */
	public static Date parseDate(Calendar c) {
		return c.getTime();
	}

	/**
	 * 得到一个时间的当天的开始时间 例如:2010-10-8 11:04:05则返回时间设置2010-10-8 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTheDateOfStartTime(Date date) {
		Calendar c = parseCalendar(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 得到一个时间的当天的最后时间 例如:2010-10-8 11:04:05则返回时间设置2010-10-8 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTheDateOfEndTime(Date date) {
		Calendar c = parseCalendar(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static HashMap<String, Object> getTimeInterval(Date date, HashMap<String, Object> timeMap) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(getTheDateOfStartTime(cal.getTime()));
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(getTheDateOfEndTime(cal.getTime()));
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(imptimeBegin);
		list.add(imptimeEnd);
		timeMap.put("start_end_date", list);
		return timeMap;
	}

	public static String formatUSTime(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(US_PATTERN, Locale.US);
		String formatDate = DateUtil.formatDate(sdf.parse(date), YMD_PATTERN);
		return formatDate;

	}

	public static String tlr_start_time_Util(HashMap<String, Object> paramMap) throws Exception {
		String tlr_start_time="00:00:00";
		try {
			Object start_h_time =paramMap.get("start_h_time");
			Object start_m_time =  paramMap.get("start_m_time");
			Object start_s_time = paramMap.get("start_s_time");
			 tlr_start_time = start_h_time + ":" + start_m_time + ":" + start_s_time;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tlr_start_time;

	}

	public static String tlr_end_time_Util(HashMap<String, Object> paramMap) throws Exception {
		String tlr_end_time="00:00:00";
		try {
			Object end_h_time =paramMap.get("end_h_time");
			Object end_m_time =paramMap.get("end_m_time");
			Object end_s_time =paramMap.get("end_s_time");
			tlr_end_time = end_h_time + ":" + end_m_time + ":" + end_s_time;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tlr_end_time;

	}

	public static HashMap<String, Object> getDefultSeachTime() throws Exception {
		  HashMap<String, Object> paramMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String imptimeEnd = sdf.format( getTheDateOfEndTime(date));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -12);
		date = calendar.getTime();
		String imptimeBegin = sdf.format(getTheDateOfStartTime(date));
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(imptimeBegin);
		list.add(imptimeEnd);
		paramMap.put("start_end_date", list);
		return paramMap;

	}
	
	
}
