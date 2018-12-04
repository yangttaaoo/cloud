package com.cist.illegalbehavior.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.Illegalbusiness.model.Series;
import com.cist.Illegalbusiness.model.TblOffeVioWorkStat;
import com.cist.Illegalbusiness.util.DateUtils;
import com.cist.Illegalbusiness.util.Export;
import com.cist.illegalbehavior.model.Sys_frm_code;
import com.cist.illegalbehavior.model.TblOffeVioWfxwStat;
import com.cist.illegalbehavior.model.TblWfxwClflStat;
import com.cist.illegalbehavior.model.TblWfxwWfddStat;
import com.cist.illegalbehavior.model.TblWfxwXwStat;
import com.cist.illegalbehavior.model.TblWfxwZdcllStat;
import com.cist.illegalbehavior.service.IllegalBehaviorService;
import com.cist.illegalbehavior.util.ExcleExport;
import com.cist.illegalbehavior.util.MapUtil;
import com.cist.personalstats.util.ExportExcel;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("illegalBehavior")
public class IllegalBehaviorController {

	@Autowired
	IllegalBehaviorService service;

	/***
	 * 违法行为分了违法数据统计
	 * 
	 * @return
	 */
	@RequestMapping("selectWfxw")
	public HashMap<String, Object> selectWfxw(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		map.put("kssj", DateUtils.getBeginDayOfYear());
		map.put("jssj", DateUtils.getEndDayOfYear());
		List<TblWfxwXwStat> list = service.selectWfxw(map);
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getWfxwmc());
		}
		hashmap.put("category", category);
		int count=0;
		// 2.主要数据获取
		List<Series> series = new ArrayList<Series>();
		for (TblWfxwXwStat ps : list) {
			count+=ps.getWfxwzs();
			series.add(new Series(ps.getWfxwzs(),ps.getWfxwmc()));
			
		}
		hashmap.put("series", series);
		hashmap.put("count", count);
		return hashmap;

	}
	
	/***
	 * 车辆分类违法数据统计
	 * 
	 * @return
	 */
	@RequestMapping("selectCar")
	public HashMap<String, Object> selectCar(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		map.put("kssj", DateUtils.getBeginDayOfYear());
		map.put("jssj", DateUtils.getEndDayOfYear());
		List<TblWfxwClflStat> list = service.selectCar(map);
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getCllxmc());
		}
		hashmap.put("category", category);
		int count=0;//统计违法总量
		// 2.主要数据获取
		List<Series> series = new ArrayList<Series>();
		for (TblWfxwClflStat ps : list) {
			count+=ps.getWfxwzs();
			series.add(new Series(ps.getWfxwzs(),ps.getCllxmc()));
			
		}
		hashmap.put("series", series);
		hashmap.put("count", count);
		return hashmap;

	}
	
	/***
	 * 重点车辆违法数据统计
	 * 
	 * @return
	 */
	@RequestMapping("selectKeyVehicles")
	public HashMap<String, Object> selectKeyVehicles(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		map.put("kssj", DateUtils.getBeginDayOfYear());
		map.put("jssj", DateUtils.getEndDayOfYear());
		List<TblWfxwZdcllStat> list = service.selectKeyVehicles(map);
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getWfxwmc());
		}
		hashmap.put("category", category);
		// 2.主要数据获取
		List<Integer> series = new ArrayList<Integer>();
		for (TblWfxwZdcllStat ps : list) {
			series.add(ps.getWfxwzs());
			
		}
		hashmap.put("series", series);
		return hashmap;

	}
	
	/***
	 * 违法行为柱状图统计
	 * 
	 * @return
	 */
	@RequestMapping("selectByWfxw")
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> selectByWfxw(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<Sys_frm_code> wfList = service.selectSysfrmCode("T002");//违法行为横坐标查询
		//页面点击今日 本周 本月 本年 时间
		if(map.get("kssj")!=null&&map.get("jssj")!=null){
			try {
				map.put("kssj", DateUtils.strConvertToDate(map.get("kssj").toString(),"yyyy-MM-dd HH:mm:ss"));
				map.put("jssj", DateUtils.strConvertToDate(map.get("jssj").toString(),"yyyy-MM-dd HH:mm:ss"));	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("0".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getDayBegin());
			map.put("jssj", DateUtils.getDayEnd());
		} else if ("1".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfWeek());
			map.put("jssj", DateUtils.getEndDayOfWeek());
		} else if ("2".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfMonth());
			map.put("jssj", DateUtils.getEndDayOfMonth());
		} else if ("3".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfYear());
			map.put("jssj", DateUtils.getEndDayOfYear());
		}
		List<TblOffeVioWfxwStat> list = service.selectByWfxw(map);//查询违法行为分组统计
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < wfList.size(); i++) {
			category.add(wfList.get(i).getFc_name());
		}
		hashmap.put("category", category);
		// 2.主要数据获取
		List<Integer> series = new ArrayList<Integer>();//页面柱状图数据
		HashMap<String, Object> modelMap = new HashMap<String, Object>();//统计各个违法行为的数量
		for (TblOffeVioWfxwStat ps : list) {
			
			if(ps.getWfxwtj()!=null)
			{
				JSONObject jsStr = JSONObject.fromObject(ps.getWfxwtj());//将JSON字符串转换成对象
				Iterator<String> iterator1 = jsStr.keys();
				while (iterator1.hasNext()) {
					String key1 = iterator1.next();
					String value1 = jsStr.getString(key1);
						if (modelMap.get(key1) == null) {
							modelMap.put(key1, value1);
						} else {
							modelMap.put(key1, Integer.valueOf(modelMap.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
				}
			}
		}
		List<Series> listSer=new ArrayList<Series>();
		//循环取出统计的数据加入集合用于页面显示
		for (Sys_frm_code string : wfList) {
			if(modelMap.get(string.getFc_code())!=null)
			{
				series.add(Integer.valueOf(modelMap.get(string.getFc_code()).toString()).intValue());
					listSer.add(new Series(Integer.valueOf(modelMap.get(string.getFc_code()).toString()).intValue(), string.getFc_name()));
			}
			else
			{
				series.add(0);
				listSer.add(new Series(0, string.getFc_name()));
			}
			
			
		}
		hashmap.put("series", series);
		Collections.sort(listSer);//排序用于页面显示
		hashmap.put("topList", listSer);
		hashmap.put("list", service.selectList(map));
		
		return hashmap;

	}

	/***
	 * 违法行为柱状图统计
	 * 
	 * @return
	 */
	@RequestMapping("selectByWfdd")
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> selectByWfdd(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if(map.get("kssj")!=null&&map.get("jssj")!=null){
			try {
				map.put("kssj", DateUtils.strConvertToDate(map.get("kssj").toString(),"yyyy-MM-dd HH:mm:ss"));
				map.put("jssj", DateUtils.strConvertToDate(map.get("jssj").toString(),"yyyy-MM-dd HH:mm:ss"));	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("0".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getDayBegin());
			map.put("jssj", DateUtils.getDayEnd());
		} else if ("1".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfWeek());
			map.put("jssj", DateUtils.getEndDayOfWeek());
		} else if ("2".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfMonth());
			map.put("jssj", DateUtils.getEndDayOfMonth());
		} else if ("3".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfYear());
			map.put("jssj", DateUtils.getEndDayOfYear());
		}
		
		List<TblWfxwWfddStat> list = service.selectByWfdd(map);
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
//		for (int i = 0; i < list.size(); i++) {
//			category.add(list.get(i).getWfxwmc());
//		}
		hashmap.put("category", category);
		
		// 2.主要数据获取
		List<Integer> series = new ArrayList<Integer>();//页面柱状图数据
		HashMap<String, Object> modelMap1 = new HashMap<String, Object>();
		List<HashMap<String, Object>> lMap = new ArrayList<HashMap<String, Object>>();
		modelMap1.put("wfddmc", "合计");
		for (TblWfxwWfddStat ps : list) {
			//累加合计行
			if (modelMap1.get("cjzs") != null) {
				modelMap1.put("cjzs",
						Integer.parseInt(modelMap1.get("cjzs").toString()) + ps.getCjzs());

			} else {
				modelMap1.put("cjzs", ps.getCjzs());
			}
			if (modelMap1.get("yxs") != null) {
				modelMap1.put("yxs",
						Integer.parseInt(modelMap1.get("yxs").toString()) +ps.getYxs());

			} else {
				modelMap1.put("yxs", ps.getYxs());
			}
			if (modelMap1.get("wxs") != null) {
				modelMap1.put("wxs",
						Integer.parseInt(modelMap1.get("wxs").toString()) +ps.getWxs());

			} else {
				modelMap1.put("wxs", ps.getWxs());
			}
			HashMap<String, Object> convertToMap = MapUtil.convertToMap(ps);// 对象转map
			category.add(ps.getWfddmc());
			series.add(ps.getCjzs());
			if(ps.getWfxwtj()!=null)
			{			
				String[] split = ps.getWfxwtj().split("@");
			for (String string : split) {
				JSONObject jsStr = JSONObject.fromObject(string);//将JSON字符串转换成对象
				Iterator<String> iterator1 = jsStr.keys();
				while (iterator1.hasNext()) {
					String key1 = iterator1.next();
					String value1 = jsStr.getString(key1);
						if (convertToMap.get(key1) == null) {
							convertToMap.put(key1, value1);
						} else {
							convertToMap.put(key1, Integer.valueOf(convertToMap.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
						if (modelMap1.get(key1) == null) {
							modelMap1.put(key1, value1);
						} else {
							modelMap1.put(key1, Integer.valueOf(modelMap1.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
					
				}
			}
			}
			if (convertToMap != null && convertToMap.get("yxs") != null) {
				if (Integer.valueOf(convertToMap.get("yxs").toString()).intValue() != 0) {
					int efficiency = (int) (Math
							.ceil((float) Integer.valueOf(convertToMap.get("yxs").toString()).intValue()
									/ (float) Integer.valueOf(convertToMap.get("cjzs").toString()).intValue() * 100));
					convertToMap.put("yxl", efficiency + "%");
				} else {
					convertToMap.put("yxl", "0%");
				}
			} else {
				convertToMap.put("yxl", "0%");
			}
			lMap.add(convertToMap);
		}
		if (modelMap1 != null && modelMap1.get("yxs") != null) {
			if (Integer.valueOf(modelMap1.get("yxs").toString()).intValue() != 0) {
				int efficiency = (int) (Math.ceil((float) Integer.valueOf(modelMap1.get("yxs").toString()).intValue()
						/ (float) Integer.valueOf(modelMap1.get("cjzs").toString()).intValue() * 100));
				modelMap1.put("yxl", efficiency + "%");
			} else {
				modelMap1.put("yxl", "0%");
			}
		} else {
			modelMap1.put("yxl", "0%");
		}
		lMap.add(0,modelMap1);//将合计行加入集合的第一行
		List<TblWfxwWfddStat> listSer=new ArrayList<TblWfxwWfddStat>();
		hashmap.put("list", lMap);
		listSer.addAll(list);
		hashmap.put("series", series);
		Collections.sort(listSer);//排序用于页面显示
		hashmap.put("topList", listSer);
		return hashmap;

	}
	/***
	 * 违法行为柱状图统计
	 * 
	 * @return
	 */
	@RequestMapping("selectWfList")
	public HashMap<String, Object> selectWfList(@RequestBody HashMap<String, Object> map) {
		map.put("wfList", service.selectSysfrmCode("T002"));
		return map;

	}
	
	/**
	 * POI导出个人工作统计Excle表
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/downloadExcle")
	public String downloadExcle(@RequestBody HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
	
		String[] headers1=null;
		List<Sys_frm_code> selectSysfrmCode = service.selectSysfrmCode("T002");//违法行为合并单元格数据
		List<HashMap<String, Object>> selectList=null;
		
		if ("0".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getDayBegin());
			map.put("jssj", DateUtils.getDayEnd());
		} else if ("1".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfWeek());
			map.put("jssj", DateUtils.getEndDayOfWeek());
		} else if ("2".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfMonth());
			map.put("jssj", DateUtils.getEndDayOfMonth());
		} else if ("3".equals(map.get("dateFlag"))) {
			map.put("kssj", DateUtils.getBeginDayOfYear());
			map.put("jssj", DateUtils.getEndDayOfYear());
		}
		if ("0".equals(map.get("flag"))) {
			String[] headers ={"部门","违法行为"};
			headers1=headers;
			selectList = service.selectList(map);
		} else{
			String[] headers ={"违法地点","采集总数","有效数","无效数","有效率","违法行为"};
			headers1=headers;
			selectList = service.selectWfddList(map);
		}
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 解决不同浏览器excle包名字含有中文时乱码的问题
		String downloadName = "个人工作统计.xls";
		String agent = request.getHeader("USER-AGENT");
		try {
			if (agent.contains("MSIE") || agent.contains("Trident")) {
				downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
			} else {
				downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
		ExportExcel<TblOffeVioWorkStat> ex = new ExportExcel<TblOffeVioWorkStat>();

		OutputStream out;
		try {
			out = response.getOutputStream();
			ExcleExport.reportMergeXls(selectList, "sheet1", headers1,selectSysfrmCode, out,map.get("flag").toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public HashMap<String, Object> convertToMap(Object obj) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0, len = fields.length; i < len; i++) {
				String varName = fields[i].getName();
				boolean accessFlag = fields[i].isAccessible();
				fields[i].setAccessible(true);
				Object o = fields[i].get(obj);
				if (o != null)
					map.put(varName, o.toString());

				fields[i].setAccessible(accessFlag);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return map;
	}


}
