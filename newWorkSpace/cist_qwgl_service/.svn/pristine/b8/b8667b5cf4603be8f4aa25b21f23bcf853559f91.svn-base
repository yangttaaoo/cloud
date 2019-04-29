package com.cist.qwgl.qwgzt.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		String string = "2017-6";
		String[] strings = string.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cale = null;
		String firstday, lastday;
		int year = Integer.valueOf(strings[0]);
		int month = Integer.valueOf(strings[1]);
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, year);
		cale.set(Calendar.MONTH, month-1);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		firstday = sdf.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.set(Calendar.YEAR, year);
		cale.set(Calendar.MONTH, month);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		lastday = sdf.format(cale.getTime());
		System.out.println(firstday+"   "+lastday);
	}

}
