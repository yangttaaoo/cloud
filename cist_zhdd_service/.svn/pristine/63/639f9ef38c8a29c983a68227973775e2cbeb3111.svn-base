package com.cist.dj.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dj.model.TblOffeEvdiInfo;
import com.cist.dj.service.DjService;

@RestController
@RequestMapping("dj")
public class DjController {
	@Autowired
	private DjService dService;
	
	@RequestMapping("index")
	public Map<String, Object> index(@RequestBody HashMap<String, Object> map) throws ParseException{
		int dateFlag = Integer.valueOf(map.get("dateFlag").toString());
		HashMap<String, Object> resultMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Calendar calendar1 = Calendar.getInstance();
		if (dateFlag == 0) {
			Date date1 = null;
			Date date2 = null;
			Date date3 = null;
			//获取当天的x数据
			calendar1.set(Calendar.MINUTE, 0);
			List<Date> list2 = dService.selectAll(map);
			int[] yDates = new int[24]; 
			int count;
			for (int i = 0; i < 24; i++) {
				count = 0;
				calendar1.set(Calendar.HOUR_OF_DAY, i);
				date1 = calendar1.getTime();
				String str = sdf.format(date1);
				list.add(str);
				calendar1.set(Calendar.HOUR_OF_DAY, i+1);
				date2 = calendar1.getTime();
				int size = list2.size();
				for (int j = 0; j < size; j++) {
					date3 = list2.get(j);
					if (date3.compareTo(date1)>=0&&date3.compareTo(date2)<0) {
						count ++;
					}
				}
				yDates[i] = count;
			}
			resultMap.put("rq", list);
			resultMap.put("ydate", yDates);
			
		}
		else if (dateFlag == 1) {
			//获取本周的数据
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			calendar1.set(Calendar.DAY_OF_WEEK, 2);
			String sunday = getSundayOfThisWeek();
			map.put("xqy", calendar1.getTime());
			map.put("xqt", sdf.parse(sunday));
			List<Date> list2 = dService.selectAll(map);
			int[] yDates = new int[7]; 
			int count;
			for (int i = 2; i <= 7; i++) {
				list.add("星期"+(i-1));
				count = 0;
				calendar1.set(Calendar.DAY_OF_WEEK, i);
				String str = sdf.format(calendar1.getTime());
				int size = list2.size();
				for (int j = 0; j < size; j++) {
					String str1 = sdf.format(list2.get(j));
					if (str.equals(str1)) {
						count ++;
					}
				}
				yDates[i-2] = count;
			} 
			list.add("星期7");
			int count1 = 0;
			for (int j = 0; j < list2.size(); j++) {
				String str1 = sdf.format(list2.get(j));
				if (sunday.equals(str1)) {
					count1 ++;
				}
			}
			yDates[6] = count1;
			resultMap.put("rq", list);
			resultMap.put("ydate", yDates);
			
		}
		else if (dateFlag == 2) {
			//获取月份的数据
			List<Date> list2 = dService.selectAll(map);
			int count;
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(Calendar.DATE, 1);//把日期设置为当月第一天
			calendar2.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
			int monthDay = calendar2.get(Calendar.DATE);
			int[] yDates = new int[monthDay];
			String str1;
			for (int i = 1; i <= monthDay; i++) {
				count = 0;
				calendar2.set(Calendar.DATE, i);
				str1 = sdf.format(calendar2.getTime());
				list.add(str1);
				for (Date date : list2) {
					if (sdf.format(date).equals(str1)) {
						count++;
					}
				}
				yDates[i-1] = count;
			}
			
			resultMap.put("ydate", yDates);
			resultMap.put("rq", list);
		}else {
			//获取当年的数据
			List<Date> list2 = dService.selectAll(map);
			int count;
			sdf = new SimpleDateFormat("MM");
			int[] yDates = new int[12];
			for (int i = 1; i <= 12; i++) {
				count = 0;
				list.add(i+"月");
				for (Date date : list2) {
					if (Integer.valueOf(sdf.format(date))==i) {
						count++;
					}
				}
				yDates[i-1] = count;
			}
			resultMap.put("ydate", yDates);
			resultMap.put("rq", list);
		}
		map.put("hour", 1);
		resultMap.put("onehour", dService.selectOneHourCount(map));
		return resultMap;
	}
	
	@RequestMapping("lastDate")
	public Map<String, Object> lastDate(@RequestBody HashMap<String, Object> map) throws ParseException {
		HashMap<String, Object> resultMap = new HashMap<>();
		TblOffeEvdiInfo tbl = dService.selectLastData(map);
		map.put("today", 1);
		map.put("hphm", 1);
		int todayCount = dService.selectOneHourCount(map);
		int hphmCount = dService.selectOneHourCount(map);
		double cgl = Double.valueOf(hphmCount)/Double.valueOf(todayCount);//识别成功率
		resultMap.put("cgl", cgl * 100);
		tbl.setJrll(todayCount);
		map.remove("today");
		map.remove("hphm");
		map.put("hour", 1);
		int hourCount = dService.selectOneHourCount(map);
		map.remove("hour");
		map.put("yesterday", 1);
		int yesterdayCount = dService.selectOneHourCount(map);
		map.remove("yesterday");
		double ribi = (Double.valueOf(todayCount) - Double.valueOf(yesterdayCount))
				/Double.valueOf(yesterdayCount);//日环比
		
		double rizhanbi = Double.valueOf(hourCount) / Double.valueOf(todayCount);//小时占比
		
		if (ribi>=0.0) {
			resultMap.put("ribiFlag", true);
		}else resultMap.put("ribiFlag", false);
		//同周比
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.DAY_OF_WEEK, 2);
		String sunday = getSundayOfThisWeek();
		map.put("thisweek", 1);
		map.put("monday", calendar1.getTime());
		map.put("sunday", sdf.parse(sunday));
		int thisWeekCount = dService.selectOneHourCount(map);
		map.remove("thisweek");
		map.put("lastweek", 1);
		calendar1.set(Calendar.DAY_OF_WEEK, 1);
		map.put("lastSunday", calendar1.getTime());
		calendar1.add(Calendar.DATE, -6);
		map.put("lastMonday", calendar1.getTime());
		int lastWeekCount = dService.selectOneHourCount(map);
		map.remove("lastweek");
		double huanbi = (Double.valueOf(thisWeekCount) - Double.valueOf(lastWeekCount))/
				Double.valueOf(lastWeekCount);//同周比
		if (huanbi>=0.0) {
			resultMap.put("huanbiFlag", true);
		}else resultMap.put("huanbiFlag", false);
		
		resultMap.put("huanbi", (int)(huanbi * 100)+""+"%");
		resultMap.put("carInfo", tbl);
		resultMap.put("ribi", (int)(ribi * 100)+""+"%");
		resultMap.put("rizhanbi", (int)(rizhanbi * 100)+""+"%");
		return resultMap;
	}
	
	public static String getSundayOfThisWeek() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 7);
		return sdf.format(c.getTime());
	}
}
