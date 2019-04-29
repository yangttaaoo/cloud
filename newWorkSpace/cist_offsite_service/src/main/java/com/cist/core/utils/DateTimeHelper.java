package com.cist.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateTimeHelper {
	public static final String FMT_yyyyMMddHHmmssSa_12 = "yyyy-MM-dd KK:mm:ss.S a";
	public static final String FMT_yyyyMMddHHmmssa_12 = "yyyy-MM-dd KK:mm:ss a";
	public static final String FMT_yyyyMMddHHmma_12 = "yyyy-MM-dd KK:mm a";
	public static final String FMT_yyyyMMddHHa_12 = "yyyy-MM-dd KK a";
	public static final String FMT_yyyyMMdda_12 = "yyyy-MM-dd a";
	public static final String FMT_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";
	public static final String FMT_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
	public static final String FMT_yyyyMMddHH = "yyyy-MM-dd HH";
	public static final String FMT_yyyyMMdd = "yyyy-MM-dd";
	public static final String FMT_HHmmA_12 = "KK:mm a";
	public static final String FMT_HHmmAz_12 = "KK:mm a,z";
	public static final String FMT_HHmmAzzzz_12 = "KK:mm a,zzzz";
	public static final String FMT_HHmmssA_12 = "KK:mm:ss a";
	public static final String FMT_HHmmssAz_12 = "KK:mm:ss a,z";
	public static final String FMT_HHmmssAzzzz_12 = "KK:mm:ss a,zzzz";
	public static final String FMT_HHmmss = "HH:mm:ss";
	public static final String FMT_HHmmssS = "HH:mm:ss.S";
	public static final String FMT_HHmm = "HH:mm";
	public static final String FMT_HHmmz = "HH:mm,z";
	public static final String FMT_HHmmzzzz = "HH:mm,zzzz";
	public static final String FMT_WWMMDDYY_EN = "EEE,MMM d,''yyyy";
	public static final String FMT_WWMMDDYY_CN = "EEE,yyyy年MMMd号";
	public static final String FMT_MMDDYY_EN = "MMM d,''yyyy";
	public static final String FMT_MMDDYY_CN = "yyyy年MMMd号";
	public static final String FMT_WW = "EEE";
	private static final String formatStr[] = { "yyyy-MM-dd HH:mm:ss.S",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH",
			"yyyy-MM-dd", "HH:mm:ss", "HH:mm:ss.S", "HH:mm", "HH:mm,z",
			"HH:mm,zzzz", "yyyy-MM-dd KK:mm:ss.S a", "yyyy-MM-dd KK:mm:ss a",
			"yyyy-MM-dd KK:mm a", "yyyy-MM-dd KK a", "yyyy-MM-dd a", "KK:mm a",
			"KK:mm a,z", "KK:mm a,zzzz", "KK:mm:ss a", "KK:mm:ss a,z",
			"KK:mm:ss a,zzzz" };

	private DateTimeHelper() {
	}

	public static String formatDateTimetoString(Date date, String formatStr) {
		String reStr = "";
		if (date == null || formatStr == null || formatStr.trim().length() < 1) {
			return reStr;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(formatStr);
			reStr = sdf.format(date);
			return reStr != null ? reStr : "";
		}
	}

	public static String formatDateTimetoString(Date date, String formatStr,
			Locale locale) {
		String reStr = "";
		if (date == null || formatStr == null || locale == null
				|| formatStr.trim().length() < 1) {
			return reStr;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
			reStr = sdf.format(date);
			return reStr != null ? reStr : "";
		}
	}

	public static String formatDateTimetoString(String dateStr, String formatStr)
			throws Throwable {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null
				&& formatStr.trim().length() > 0)
			dStr = formatDateTimetoString(parseToDate(dateStr), formatStr);
		return dStr;
	}

	public static String formatDateTimetoString(String dateStr,
			String formatStr, Locale locale) throws Throwable {
		String dStr = "";
		if (dateStr != null && dateStr.trim().length() > 0 && formatStr != null
				&& formatStr.trim().length() > 0 && locale != null)
			dStr = formatDateTimetoString(parseToDate(dateStr, locale),
					formatStr, locale);
		return dStr;
	}

	public static Date parseToDate(String dateTimeStr, String formatStr)
			throws Throwable {
		if (dateTimeStr == null || formatStr == null
				|| dateTimeStr.trim().length() < 1
				|| formatStr.trim().length() < 1)
			throw new IllegalArgumentException(
					"参数dateTimeStr、formatStr不能是null或空格串!");
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			return sdf.parse(dateTimeStr);
		} catch (ParseException e) {
			throw new Exception(e);
		}
	}

	public static Date parseToDate(String dateTimeStr, String formatStr,
			Locale locale) throws Throwable {
		if (dateTimeStr != null && formatStr != null && locale != null
				&& dateTimeStr.trim().length() > 0
				&& formatStr.trim().length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException e) {
				throw new Exception(e);
			}
		} else {
			throw new IllegalArgumentException(
					"参数dateTimeStr、formatStr、locale不能是null或空格串!");
		}
	}

	public static Date parseToDate(String dateTimeStr) throws Throwable {
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1)
			throw new IllegalArgumentException("参数dateTimeSt不能是null或空格串!");
		int formatStrLength = formatStr.length;
		int i = 0;
		for (i = 0; i < formatStrLength;) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i]);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException parseexception) {
				i++;
			}
		}

		throw new Exception("日期格式不正确!");
	}

	public static Date parseToDate(int year, int month, int day)
			throws Throwable {
		if (month < 1 || month > 12 || day < 1 || day > 31) {
			throw new IllegalArgumentException("参数不正确!");
		} else {
			String yearStr = String.valueOf(year);
			String monthStr = String.valueOf(month);
			String dayStr = String.valueOf(day);
			return parseToDate(yearStr + "-" + monthStr + "-" + dayStr);
		}
	}

	public static Date parseToDate(int year, int month, int day, int h, int m,
			int s) throws Throwable {
		if (month < 1 || month > 12 || day < 1 || day > 31 || h < 0 || h > 23
				|| m < 0 || m > 60 || s < 0 || s > 60) {
			throw new IllegalArgumentException("参数不正确!");
		} else {
			String yearStr = String.valueOf(year);
			String monthStr = String.valueOf(month);
			String dayStr = String.valueOf(day);
			String hStr = String.valueOf(h);
			String mStr = String.valueOf(m);
			String sStr = String.valueOf(s);
			return parseToDate(yearStr + "-" + monthStr + "-" + dayStr + " "
					+ hStr + ":" + mStr + ":" + sStr);
		}
	}

	public static Date parseToDate(String dateTimeStr, Locale locale)
			throws Throwable {
		if (dateTimeStr == null || dateTimeStr.trim().length() < 1
				|| locale == null)
			throw new IllegalArgumentException(
					"参数dateTimeSt\u3001locale不能是null或空格串!");
		int formatStrLength = formatStr.length;
		int i = 0;
		for (i = 0; i < formatStrLength;) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr[i], locale);
			try {
				return sdf.parse(dateTimeStr);
			} catch (ParseException parseexception) {
				i++;
			}
		}

		throw new Exception("日期格式不正确!");
	}

	public static String formatDateTimetoString(String dateTimeStr)
			throws Throwable {
		return formatDateTimetoString(dateTimeStr, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDateTimetoString(String dateTimeStr,
			Locale locale) throws Throwable {
		return formatDateTimetoString(dateTimeStr, "yyyy-MM-dd HH:mm:ss",
				locale);
	}

	public static String formatDateTimetoString(Date dateTime) {
		return formatDateTimetoString(dateTime, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDateTimetoString(Date dateTime, Locale locale) {
		return formatDateTimetoString(dateTime, "yyyy-MM-dd HH:mm:ss", locale);
	}

	public static String formatDatetoString(String dateStr) throws Throwable {
		return formatDateTimetoString(dateStr, "yyyy-MM-dd");
	}

	public static String formatDatetoString(String dateStr, Locale locale)
			throws Throwable {
		return formatDateTimetoString(dateStr, "yyyy-MM-dd", locale);
	}

	public static String formatDatetoString(Date d) {
		return formatDateTimetoString(d, "yyyy-MM-dd");
	}

	public static String formatDatetoString(Date d, Locale locale) {
		return formatDateTimetoString(d, "yyyy-MM-dd", locale);
	}

	public static String formatTimetoString(String dateTimeStr)
			throws Throwable {
		return formatDateTimetoString(dateTimeStr, "HH:mm:ss");
	}

	public static String formatTimetoString(String dateTimeStr, Locale locale)
			throws Throwable {
		return formatDateTimetoString(dateTimeStr, "HH:mm:ss", locale);
	}

	public static String formatTimetoString(Date dateTimeStr) {
		return formatDateTimetoString(dateTimeStr, "HH:mm:ss");
	}

	public static String formatTimetoString(Date dateTimeStr, Locale locale) {
		return formatDateTimetoString(dateTimeStr, "HH:mm:ss", locale);
	}

	public static int getYearOfDate(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(1);
		}
	}

	public static int getMonthOfYear(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(2) + 1;
		}
	}

	public static int getDayOfMonth(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(5);
		}
	}

	public static int getDayOfYear(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(6);
		}
	}

	public static int getDayOfWeek(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(7) - 1;
		}
	}

	public static int getWeekOfMonth(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(4);
		}
	}

	public static int getWeekOfYear(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar.get(3);
		}
	}

	public static int getHoursOfDay(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int hours = calendar.get(11);
			return hours;
		}
	}

	public static int getHoursOfDay12(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int hours = calendar.get(10);
			return hours;
		}
	}

	public static int getMinutesOfHour(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int minutes = calendar.get(12);
			return minutes;
		}
	}

	public static int getSecondsOfMinute(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int seconds = calendar.get(13);
			return seconds;
		}
	}

	public static int getMillisecondsOfSecond(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int millisecond = calendar.get(14);
			return millisecond;
		}
	}

	public static long getTime(Date d) {
		if (d == null)
			throw new IllegalArgumentException("参数d不能是null对象!");
		else
			return d.getTime();
	}

	public static int compareTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null)
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		long dI1 = d1.getTime();
		long dI2 = d2.getTime();
		if (dI1 > dI2)
			return -1;
		return dI1 >= dI2 ? 0 : 1;
	}

	public static long getMillisecondsOfTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		} else {
			long dI1 = d1.getTime();
			long dI2 = d2.getTime();
			return dI1 - dI2;
		}
	}

	public static double getSecondsOfTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		} else {
			long i = getMillisecondsOfTwoDate(d1, d2);
			return (double) i / 1000D;
		}
	}

	public static double getMinutesOfTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		} else {
			long millions = getMillisecondsOfTwoDate(d1, d2);
			return (double) millions / 60D / 1000D;
		}
	}

	public static double getHoursOfTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		} else {
			long millions = getMillisecondsOfTwoDate(d1, d2);
			return (double) millions / 60D / 60D / 1000D;
		}
	}

	public static double getDaysOfTwoDate(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			throw new IllegalArgumentException("参数d1或d2不能是null对象!");
		} else {
			long millions = getMillisecondsOfTwoDate(d1, d2);
			return (double) millions / 24D / 60D / 60D / 1000D;
		}
	}

	public static Date addTime(Date d, double times, int type) {
		if (d == null)
			throw new IllegalArgumentException("参数d不能是null对象!");
		long qv = 1L;
		switch (type) {
		case 14: // '\016'
			qv = 1L;
			break;

		case 13: // '\r'
			qv = 1000L;
			break;

		case 12: // '\f'
			qv = 60000L;
			break;

		case 10: // '\n'
			qv = 0x36ee80L;
			break;

		case 5: // '\005'
			qv = 0x5265c00L;
			break;

		case 6: // '\006'
		case 7: // '\007'
		case 8: // '\b'
		case 9: // '\t'
		case 11: // '\013'
		default:
			throw new RuntimeException("时间类型不正确！type＝" + type);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		long milliseconds = Math.round(Math.abs(times) * (double) qv);
		if (times > 0.0D)
			for (; milliseconds > 0L; milliseconds -= 0x7fffffffL)
				if (milliseconds > 0x7fffffffL)
					calendar.add(14, 0x7fffffff);
				else
					calendar.add(14, (int) milliseconds);

		else
			for (; milliseconds > 0L; milliseconds -= 0x7fffffffL)
				if (milliseconds > 0x7fffffffL)
					calendar.add(14, 0x80000001);
				else
					calendar.add(14, -(int) milliseconds);

		return calendar.getTime();
	}

	public static Date addYears(Date d, int years) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(1, years);
			return calendar.getTime();
		}
	}

	public static Date addMonths(Date d, int months) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(2, months);
			return calendar.getTime();
		}
	}

	public static Date addDays(Date d, int days) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(10, days * 24);
			return calendar.getTime();
		}
	}

	public static Date addHours(Date d, int hours) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(10, hours);
			return calendar.getTime();
		}
	}

	public static Date addMinutes(Date d, int minutes) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(12, minutes);
			return calendar.getTime();
		}
	}

	public static Date addSeconds(Date d, int seconds) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(13, seconds);
			return calendar.getTime();
		}
	}

	public static Date addMilliseconds(Date d, int milliseconds) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.add(14, milliseconds);
			return calendar.getTime();
		}
	}

	public static Date setYearOfDate(Date d, int year) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(1, year);
			return calendar.getTime();
		}
	}

	public static Date setMonthOfDate(Date d, int month) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(2, month);
			return calendar.getTime();
		}
	}

	public static Date setDayOfDate(Date d, int day) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(5, day);
			return calendar.getTime();
		}
	}

	public static Date setHourOfDate(Date d, int hour) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(11, hour);
			return calendar.getTime();
		}
	}

	public static Date setMinuteOfDate(Date d, int minute) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(12, minute);
			return calendar.getTime();
		}
	}

	public static Date setSecondOfDate(Date d, int second) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(13, second);
			return calendar.getTime();
		}
	}

	public static Date setMillisecondOfDate(Date d, int millisecond) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(14, millisecond);
			return calendar.getTime();
		}
	}

	public static String formateDateToCNString(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			String re1 = formatDateTimetoString(d, "yyyy年MMMd号", Locale.CHINA);
			String year = re1.substring(0, 4);
			String day = re1.substring(re1.indexOf("月") + 1, re1.indexOf("号"));
			String re2 = StringHelper.replace(re1, year,
					NumberHelper.getCNStringOfNumber(year));
			String re3 = StringHelper.replace(re2, day,
					NumberHelper.getCNStringOfNumber(day));
			return re3;
		}
	}

	public static String formateDateToCNString(String d) throws Throwable {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			String re1 = formatDateTimetoString(d, "yyyy年MMMd号", Locale.CHINA);
			String year = re1.substring(0, 4);
			String day = re1.substring(re1.indexOf("月") + 1, re1.indexOf("号"));
			String re2 = StringHelper.replace(re1, year,
					NumberHelper.getCNStringOfNumber(year));
			String re3 = StringHelper.replace(re2, day,
					NumberHelper.getCNStringOfNumber(day));
			return re3;
		}
	}

	public static String formateDateTimeToCNString(Date d) {
		if (d == null) {
			throw new IllegalArgumentException("参数d不能是null对象!");
		} else {
			String re1 = formatDateTimetoString(d, "yyyy年MMMd号", Locale.CHINA);
			String year = re1.substring(0, 4);
			String day = re1.substring(re1.indexOf("月") + 1, re1.indexOf("号"));
			String re2 = StringHelper.replace(re1, year,
					NumberHelper.getCNStringOfNumber(year));
			String re3 = StringHelper.replace(re2, day,
					NumberHelper.getCNStringOfNumber(day));
			String re1time = formatDateTimetoString(d, "HH:mm:ss", Locale.CHINA);
			int pos = re1time.indexOf(":");
			String re2time = re1time.substring(0, pos) + "点"
					+ re1time.substring(pos + 1);
			String hour = re1time.substring(0, 2);
			String minute = re1time.substring(3, 5);
			String second = re1time.substring(6);
			String re3time = StringHelper.replace(re2time, ":", "分");
			re3time = re3time + "秒";
			re3time = StringHelper.replace(re3time, hour,
					NumberHelper.getReadCNStringOfNumber(hour));
			re3time = StringHelper.replace(re3time, minute,
					NumberHelper.getReadCNStringOfNumber(minute));
			re3time = StringHelper.replace(re3time, second,
					NumberHelper.getReadCNStringOfNumber(second));
			return re3 + re3time;
		}
	}

	public static String formateDateTimeToCNString(String d) throws Throwable {
		if (d == null) {
			throw new NullPointerException();
		} else {
			String re1 = formatDateTimetoString(d, "yyyy年MMMd号", Locale.CHINA);
			String year = re1.substring(0, 4);
			String day = re1.substring(re1.indexOf("月") + 1, re1.indexOf("号"));
			String re2 = StringHelper.replace(re1, year,
					NumberHelper.getCNStringOfNumber(year));
			String re3 = StringHelper.replace(re2, day,
					NumberHelper.getCNStringOfNumber(day));
			return re3;
		}
	}

	public static int getDaysOfMonth(Date d) {
		int year = getYearOfDate(d);
		int month = getMonthOfYear(d);
		return getDaysOfMonth(year, month);
	}

	public static int getDaysOfMonth(int year, int month) {
		int days = 0;
		if (month == 2)
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
				days = 29;
			else
				days = 28;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			days = 30;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
			days = 31;
		return days;
	}

	public static Date getSystemDate() {
		return new Date(System.currentTimeMillis());
	}

	public static long getSystemTime() {
		return System.currentTimeMillis();
	}
}