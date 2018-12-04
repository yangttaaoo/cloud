package com.cist.Illegalbusiness.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cist.Illegalbusiness.model.DeptInfo;
import com.cist.Illegalbusiness.model.Series;
import com.cist.Illegalbusiness.model.TblOffeVioWorkStat;
import com.cist.Illegalbusiness.model.TblWorkCardStatInfo;
import com.cist.Illegalbusiness.service.IllegalBusinessService;
import com.cist.Illegalbusiness.util.DateUtils;
import com.cist.Illegalbusiness.util.Export;
import com.cist.illegalbehavior.model.Sys_frm_code;
import com.cist.illegalbehavior.service.IllegalBehaviorService;
import com.cist.personalstats.model.PersonalStats;
import com.cist.personalstats.util.ExportExcel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("illegalBusiness")
public class IllegalBusinessController {

	@Autowired
	IllegalBusinessService service;
	
	@Autowired
	IllegalBehaviorService service1;
	

	/***
	 * 违法业务工作量统计数据查询
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public HashMap<String, Object> index(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		TblWorkCardStatInfo list2 = service.list(map);//总违法量查询

		TblOffeVioWorkStat selectIllegal = service.selectIllegal(map);//总违法量查询
		List<TblOffeVioWorkStat> list = service.selectWsh(map);//未审核部门分组统计
		 List<PersonalStats> list1 = service.selectAllCount(map);//审核总数时间分组
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getCjdw());
		}
		hashmap.put("category", category);
		String[] legend = new String[1];
		legend[0] = "视频";
		hashmap.put("legend", legend);
		// 3.主要数据获取
		List<Series> series = new ArrayList<Series>();
		List<Integer> serisData1 = new ArrayList<Integer>();
		for (TblOffeVioWorkStat ps : list) {
			serisData1.add(ps.getWsh());
		}
		series.add(new Series("视频", "bar", 30, serisData1));
		hashmap.put("series", series);
		modelMap.put("wshList", hashmap);
		HashMap<String, Object> hashmap1 = new HashMap<String, Object>();
		// 1.分类赋值(横坐标)
		List<String> category1 = new ArrayList<String>();
		for (int i = 0; i < list1.size(); i++) {

			category1.add(list1.get(i).getFzsj());
		}
		hashmap1.put("category", category1);
		// 3.主要数据获取
		List<Series> series1 = new ArrayList<Series>();
		List<Integer> serisData2 = new ArrayList<Integer>();
		for (PersonalStats ps : list1) {
//			selectIllegal.setShzl(selectIllegal.getShzl() + ps.getShsl());
//			selectIllegal.setYxsl(selectIllegal.getYxsl() + ps.getYxsl());
//			selectIllegal.setLastWeek(selectIllegal.getLastWeek() + ps.getLastWeek());
//			selectIllegal.setWeek(selectIllegal.getWeek() + ps.getWeek());
//			selectIllegal.setYestoday(selectIllegal.getYestoday() + ps.getYestoday());
//			selectIllegal.setToday(selectIllegal.getToday() + ps.getToday());
			serisData2.add(ps.getShzs());
		}
		series1.add(new Series("审核", "line", serisData2));
		hashmap1.put("series", series1);
		modelMap.put("shslList", hashmap1);
		modelMap.put("allCount", list2);
		return modelMap;

	}

	/**
	 * 统计个人工作信息报表
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/statsList")
	@SuppressWarnings("unchecked")
	public Map<String, Object> statsList(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		String[] headers = {};

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
		}else
		{
			if(map.get("kssj")!=null&&map.get("jssj")!=null){
				try {
					map.put("kssj", DateUtils.strConvertToDate(map.get("kssj").toString(),"yyyy-MM-dd HH:mm:ss"));
					map.put("jssj", DateUtils.strConvertToDate(map.get("jssj").toString(),"yyyy-MM-dd HH:mm:ss"));	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		List<TblOffeVioWorkStat> list = null;
		HttpSession session = request.getSession();
		Map<String, Object> userMap = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
		String userName = userMap.get("sypi_name") == null ? null : userMap.get("sypi_name").toString();
		map.put("shr", userName);
		if ("2".equals(map.get("flag")) && "0".equals(map.get("dateFlag"))) {
			list = service.selectDay(map);
		} else if ("2".equals(map.get("flag")) && "1".equals(map.get("dateFlag"))) {
			list = service.selectWeek(map);
		} else if ("2".equals(map.get("flag")) && "2".equals(map.get("dateFlag"))) {

			list = service.selectMonth(map);
		} else if ("2".equals(map.get("flag")) && "3".equals(map.get("dateFlag"))) {

			list = service.selectYear(map);
		}

		else {
			list = service.selectByPolice(map);
		}

		// Collections.sort(list);
		// 1.分类赋值(横坐标)
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getShr());
		}
		hashmap.put("category", category);
		String[] legend = new String[1];
		legend[0] = "工作量";
		hashmap.put("legend", legend);
		// 3.主要数据获取
		List<Series> series = new ArrayList<Series>();
		List<Integer> serisData1 = new ArrayList<Integer>();
		for (TblOffeVioWorkStat ps : list) {
			serisData1.add(ps.getShsl());
		}

		series.add(new Series("工作量", "bar", 30, serisData1));
		hashmap.put("series", series);
		hashmap.put("list", list);
		List<TblOffeVioWorkStat> list1=new ArrayList<TblOffeVioWorkStat>();
		list1.addAll(list);
		Collections.sort(list1);
		hashmap.put("topList", list1);
		
		
		
		modelMap.put("police", hashmap);
		return modelMap;

	}

	/**
	 * 管理部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级
				map.put("expanded", true);
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
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
		String[] headers = { "时间", "审核总数", "有效数", "有效率", "违法行为" };
		List<Sys_frm_code> selectSysfrmCode = service1.selectSysfrmCode("T002");//违法行为合并单元格数据
		if ("0".equals(map.get("flag"))) {
			headers[0] = "审核员";
		} else if ("1".equals(map.get("flag"))) {
			headers[0] = "部门";
		} else {
			headers[0] = "时间";
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
		List<TblOffeVioWorkStat> list = null;
		if ("2".equals(map.get("flag")) && "0".equals(map.get("dateFlag"))) {
			list = service.selectDay(map);
		} else if ("2".equals(map.get("flag")) && "1".equals(map.get("dateFlag"))) {
			list = service.selectWeek(map);
		} else if ("2".equals(map.get("flag")) && "2".equals(map.get("dateFlag"))) {

			list = service.selectMonth(map);
		} else if ("2".equals(map.get("flag")) && "3".equals(map.get("dateFlag"))) {

			list = service.selectYear(map);
		} else {
			list = service.selectByPolice(map);
		}
		List<HashMap<String, Object>> lMap = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> modelMap1 = new HashMap<String, Object>();
		modelMap1.put("shr", "合计");
		for (TblOffeVioWorkStat tblOffeVioWorkStat : list) {
			HashMap<String, Object> convertToMap = convertToMap(tblOffeVioWorkStat);// 对象转map
			if (modelMap1.get("shsl") != null) {
				modelMap1.put("shsl",
						Integer.parseInt(modelMap1.get("shsl").toString()) + tblOffeVioWorkStat.getShsl());

			} else {
				modelMap1.put("shsl", tblOffeVioWorkStat.getShsl());
			}
			if (modelMap1.get("yxsl") != null) {
				modelMap1.put("yxsl",
						Integer.parseInt(modelMap1.get("yxsl").toString()) + tblOffeVioWorkStat.getYxsl());

			} else {
				modelMap1.put("yxsl", tblOffeVioWorkStat.getYxsl());
			}
			if (tblOffeVioWorkStat.getWfxwtj() != null) {
				String[] split = tblOffeVioWorkStat.getWfxwtj().split("@");
				for (String string : split) {
					JSONObject jsStr = JSONObject.fromObject(string);
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
			if (convertToMap != null && convertToMap.get("yxsl") != null) {
				if (Integer.valueOf(convertToMap.get("yxsl").toString()).intValue() != 0) {
					int efficiency = (int) (Math
							.ceil((float) Integer.valueOf(convertToMap.get("yxsl").toString()).intValue()
									/ (float) Integer.valueOf(convertToMap.get("shsl").toString()).intValue() * 100));
					convertToMap.put("yxl", efficiency + "%");
				} else {
					convertToMap.put("yxl", "0%");
				}
			} else {
				convertToMap.put("yxl", "0%");
			}
			lMap.add(convertToMap);
		}
		if (modelMap1 != null && modelMap1.get("yxsl") != null) {
			if (Integer.valueOf(modelMap1.get("yxsl").toString()).intValue() != 0) {
				int efficiency = (int) (Math.ceil((float) Integer.valueOf(modelMap1.get("yxsl").toString()).intValue()
						/ (float) Integer.valueOf(modelMap1.get("shsl").toString()).intValue() * 100));
				modelMap1.put("yxl", efficiency + "%");
			} else {
				modelMap1.put("yxl", "0%");
			}
		} else {
			modelMap1.put("yxl", "0%");
		}
		lMap.add(0, modelMap1);

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
			Export.reportMergeXls(lMap, "sheet1", headers,selectSysfrmCode, out);
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

	/**
	 * 统计个人工作信息报表
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/selectList")
	@ResponseBody
	public Map<String, Object> selectList(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

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
		List<TblOffeVioWorkStat> list = null;
		HttpSession session = request.getSession();
		Map<String, Object> userMap = (Map<String, Object>) session.getAttribute("userInfo" + session.getId());
		String userName = userMap.get("sypi_name") == null ? null : userMap.get("sypi_name").toString();
		map.put("shr", userName);
		if ("2".equals(map.get("flag")) && "0".equals(map.get("dateFlag"))) {
			list = service.selectDay(map);
		} else if ("2".equals(map.get("flag")) && "1".equals(map.get("dateFlag"))) {
			list = service.selectWeek(map);
		} else if ("2".equals(map.get("flag")) && "2".equals(map.get("dateFlag"))) {

			list = service.selectMonth(map);
		} else if ("2".equals(map.get("flag")) && "3".equals(map.get("dateFlag"))) {

			list = service.selectYear(map);
		}

		else {
			list = service.selectByPolice(map);
		}

		modelMap.put("list", list);
		return modelMap;

	}
}
