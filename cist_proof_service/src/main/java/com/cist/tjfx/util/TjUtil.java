package com.cist.tjfx.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 统计工具类
 * @author Hy
 *
 */
public class TjUtil {

	/**
	 * 获取上周开始时间
	 * @return
	 */
	@SuppressWarnings("unused")
	public static Date getBeginDayOfLastWeek() {
		Date date = new Date();
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek - 7);
		return cal.getTime();
	}
	/**
	 * 获取上周结束时间
	 * @return
	 */
	public static Date getEndDayOfLastWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getBeginDayOfLastWeek());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return weekEndSta;
	}
	
		/**
		 * 获取本月的开始时间
		 * @return
		 */
		public static Date getBeginDayOfMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 1, 1);
			return calendar.getTime();
		}

		/**
		 * 获取本月的结束时间
		 * @return
		 */
		public static Date getEndDayOfMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 1, 1);
			int day = calendar.getActualMaximum(5);
			calendar.set(getNowYear(), getNowMonth() - 1, day);
			return calendar.getTime();
		}

		/**
		 * 获取上月的开始时间
		 * @return
		 */
		public static Date getBeginDayOfLastMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 2, 1);
			return calendar.getTime();
		}

		/**
		 * 获取上月的结束时间
		 * @return
		 */
		public static Date getEndDayOfLastMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 2, 1);
			int day = calendar.getActualMaximum(5);
			calendar.set(getNowYear(), getNowMonth() - 2, day);
			return calendar.getTime();
		}

		/**
		 * 获取今年是哪一年
		 * @return
		 */
		public static Integer getNowYear() {
			Date date = new Date();
			GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
			gc.setTime(date);
			return Integer.valueOf(gc.get(1));
		}

		/**
		 * 获取本月是哪一月
		 * @return
		 */
		public static int getNowMonth() {
			Date date = new Date();
			GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
			gc.setTime(date);
			return gc.get(2) + 1;
		}
}
