package com.cist.xxtj.sjwxyytj.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.illegal.model.SYS_FRM_CODE;
import com.cist.illegal.service.IllegalService;
import com.cist.xxtj.sbyjfztj.util.TjUtil;
import com.cist.xxtj.sjwxyytj.model.Ranking;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_FAIL_STAT;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_INVALID_STAT;
import com.cist.xxtj.sjwxyytj.model.WfxwtjByDept;
import com.cist.xxtj.sjwxyytj.model.Wfxwtjinfo;
import com.cist.xxtj.sjwxyytj.service.SjwxyytjService;

import net.sf.json.JSONObject;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/sjwxyytj")
public class SjwxyytjController {
	@Autowired
	private SjwxyytjService service;
	@Autowired
	private IllegalService illegalservice;
	
	/**
	 * 页面加载时数据的加载
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		
		HashMap<String,Integer> wxyymap = new HashMap<String,Integer>();//存放无效原因
		HashMap<String,Integer> jrwxyymap = new HashMap<String,Integer>();//今日存放无效原因
		HashMap<String,Integer> scsbyymap = new HashMap<String,Integer>();//存放上传失败原因
		HashMap<String,Integer> jrscsbyymap = new HashMap<String,Integer>();//存放今日上传失败原因
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
		map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		List<TBL_WFXW_INVALID_STAT>  wxsjlist = service.querywxyytj(map);//查询无效原因统计数据
		List<TBL_WFXW_FAIL_STAT> scsbsjlist = service.queryscsbyytj(map);//查询上传失败原因统计数据
		map.put("fct_code", "S001");
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询无效原因
		map.put("fct_code", "T001");
		List<SYS_FRM_CODE> scsbyylist = illegalservice.queryfrms(map);//动态查询上传失败原因
		int wxzs=0;//无效总数
		int scsbzs=0;//上传失败总数
		for (int i = 0; i < wxsjlist.size(); i++) {
			wxzs+=(wxsjlist.get(i).getWxzs()==null?0:wxsjlist.get(i).getWxzs());//无效原因总数
			JSONObject jsStr = JSONObject.fromObject(wxsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE sys_FRM_CODE : wxyylist) {
					if(sys_FRM_CODE.getFc_code().equals(key)) {
						if(wxyymap.get(sys_FRM_CODE.getFc_name())==null) {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value));
						}else {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value)+wxyymap.get(sys_FRM_CODE.getFc_name()));
						}
					}
				}
			}
		}
	
		
		for (int i = 0; i < scsbsjlist.size(); i++) {
			scsbzs+=(scsbsjlist.get(i).getWxzs()==null?0:scsbsjlist.get(i).getWxzs());//无效原因总数
			JSONObject jsStr = JSONObject.fromObject(scsbsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE scsbyy : scsbyylist) {
					if(scsbyy.getFc_code().equals(key)) {
						if(scsbyymap.get(scsbyy.getFc_name())==null) {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value));
						}else {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value)+scsbyymap.get(scsbyy.getFc_name()));
						}
					}
				}
			}
		}
		ModelMap.put("bzwxyytj", wxyymap);//查询本周无效数据统计
		ModelMap.put("bzscsbyytj", scsbyymap);//查询本周上传失败原因数据统计
		ModelMap.put("wxzs", wxzs);//无效总数
		ModelMap.put("scsbzs", scsbzs);//无效总数
		
		map.put("kssj", format.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
		map.put("jssj", format.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
		List<TBL_WFXW_INVALID_STAT> jrwxsjlist = service.querywxyytj(map);//查询今日无效数据详情
		List<TBL_WFXW_FAIL_STAT> jrscsbsjlist = service.queryscsbyytj(map);//查询今日上传失败原因统计数据
		for (int i = 0; i < jrwxsjlist.size(); i++) {
			JSONObject jsStr = JSONObject.fromObject(jrwxsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE sys_FRM_CODE : wxyylist) {
					if(sys_FRM_CODE.getFc_code().equals(key)) {
						if(jrwxyymap.get(sys_FRM_CODE.getFc_name())==null) {
							jrwxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value));
						}else {
							jrwxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value)+jrwxyymap.get(sys_FRM_CODE.getFc_name()));
						}
					}
				}
			}
		}
		
		for (int i = 0; i < jrscsbsjlist.size(); i++) {
			JSONObject jsStr = JSONObject.fromObject(jrscsbsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE scsbyy : scsbyylist) {
					if(scsbyy.getFc_code().equals(key)) {
						if(jrscsbyymap.get(scsbyy.getFc_name())==null) {
							jrscsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value));
						}else {
							jrscsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value)+jrscsbyymap.get(scsbyy.getFc_name()));
						}
					}
				}
			}
		}
		
		ModelMap.put("jrwxyytj", jrwxyymap);
		ModelMap.put("jrscsbyytj", jrscsbyymap);
		return ModelMap;
		}
	
	/**
	 * 按照时间查询无效原因统计
	 * rqlx 1:本周  2：本月  3：全年   4:今日
	 * @param map
	 * @return
	 */
	@RequestMapping("wfxwbydate")
	public HashMap<String,Object> wfxwbydate(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		HashMap<String,Integer> wxyymap = new HashMap<String,Integer>();//存放无效原因
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar calendar = Calendar.getInstance();
		if("1".equals(map.get("rqlx"))) {
			map.put("kssj", format.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
			map.put("jssj", format.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
		}else if("4".equals(map.get("rqlx"))) {//全年
			map.put("kssj", TjUtil.getNowYear()+"-01-01 00:00:00");//本年开始时间
			map.put("jssj", TjUtil.getNowYear()+"-12-31 23:59:59");//本年结束时间
		}else if("3".equals(map.get("rqlx"))) {//本月
			map.put("kssj", format.format(TjUtil.getBeginDayOfMonth())+" 00:00:00");//本月开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfMonth())+" 23:59:59");//当月结束时间
		}else {
			map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		}
		map.put("fct_code", "S001");
		List<TBL_WFXW_INVALID_STAT>  wxsjlist = service.querywxyytj(map);//查询无效原因统计数据
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询无效原因
		int wxzs=0;//无效总数
		for (int i = 0; i < wxsjlist.size(); i++) {
			wxzs+=(wxsjlist.get(i).getWxzs()==null?0:wxsjlist.get(i).getWxzs());//无效原因总数
			
			JSONObject jsStr = JSONObject.fromObject(wxsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE sys_FRM_CODE : wxyylist) {
					if(sys_FRM_CODE.getFc_code().equals(key)) {
						if(wxyymap.get(sys_FRM_CODE.getFc_name())==null) {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value));
						}else {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value)+wxyymap.get(sys_FRM_CODE.getFc_name()));
						}
					}
				}
			}
		}
	
		ModelMap.put("bzwxyytj", wxyymap);//查询本周无效数据统计
		ModelMap.put("wxzs", wxzs);//无效总数
		return ModelMap;
		}
	
	/**
	 * 按照时间查询无效原因统计
	 * rqlx 2:本周  3：本月  4：全年  1：今日
	 * @param map
	 * @return
	 */
	@RequestMapping("scsbyybydate")
	public HashMap<String,Object> scsbyybydate(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		HashMap<String,Integer> scsbyymap = new HashMap<String,Integer>();//存放无效原因
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar calendar = Calendar.getInstance();
		if("1".equals(map.get("rqlx"))) {
			map.put("kssj", format.format(TjUtil.getDayBegin())+" 00:00:00");//当天开始时间
			map.put("jssj", format.format(TjUtil.getDayEnd())+" 23:59:59");//当天结束时间
		}else if("4".equals(map.get("rqlx"))) {//全年
			map.put("kssj", TjUtil.getNowYear()+"-01-01 00:00:00");//本年开始时间
			map.put("jssj", TjUtil.getNowYear()+"-12-31 23:59:59");//本年结束时间
		}else if("3".equals(map.get("rqlx"))) {//本月
			map.put("kssj", format.format(TjUtil.getBeginDayOfMonth())+" 00:00:00");//本月开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfMonth())+" 23:59:59");//当月结束时间
		}else {
			map.put("kssj", format.format(TjUtil.getBeginDayOfWeek())+" 00:00:00");//当周开始时间
			map.put("jssj", format.format(TjUtil.getEndDayOfWeek())+" 23:59:59");//当周结束时间
		}
		List<TBL_WFXW_FAIL_STAT> scsbsjlist = service.queryscsbyytj(map);//查询上传失败原因统计数据
		map.put("fct_code", "T001");
		List<SYS_FRM_CODE> scsbyylist = illegalservice.queryfrms(map);//动态查询上传失败原因
		int scsbzs=0;//上传失败总数
		
		for (int i = 0; i < scsbsjlist.size(); i++) {
			scsbzs+=(scsbsjlist.get(i).getWxzs()==null?0:scsbsjlist.get(i).getWxzs());//无效原因总数
			JSONObject jsStr = JSONObject.fromObject(scsbsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE scsbyy : scsbyylist) {
					if(scsbyy.getFc_code().equals(key)) {
						if(scsbyymap.get(scsbyy.getFc_name())==null) {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value));
						}else {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value)+scsbyymap.get(scsbyy.getFc_name()));
						}
					}
				}
			}
		}
		ModelMap.put("bzscsbyytj", scsbyymap);//查询本周上传失败原因数据统计
		ModelMap.put("scsbzs", scsbzs);//无效总数
		return ModelMap;
	}
	
	@RequestMapping("pmbydate")
	public HashMap<String,Object> pmbydate(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String,Integer> scsbyymap = new HashMap<String,Integer>();//存放上传失败原因	
		HashMap<String,Integer> wxyymap = new HashMap<String,Integer>();//存放无效原因		
		List<TBL_WFXW_FAIL_STAT> scsbsjlist = service.queryscsbyytj(map);//查询上传失败原因统计数据
		map.put("fct_code", "T001");
		List<SYS_FRM_CODE> scsbyylist = illegalservice.queryfrms(map);//动态查询上传失败原因
		List<Ranking> scsbpplist = new ArrayList<Ranking>();
		List<Ranking> wxpplist = new ArrayList<Ranking>();
		Ranking pm = null;
		for (int i = 0; i < scsbsjlist.size(); i++) {
			JSONObject jsStr = JSONObject.fromObject(scsbsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE scsbyy : scsbyylist) {
					if(scsbyy.getFc_code().equals(key)) {
						if(scsbyymap.get(scsbyy.getFc_name())==null) {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value));
						}else {
							scsbyymap.put(scsbyy.getFc_name(),Integer.parseInt(value)+scsbyymap.get(scsbyy.getFc_name()));
						}
					}
				}
			}
		}
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(scsbyymap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		for(Entry<String, Integer> t:list){
			pm = new Ranking();
			pm.setName(t.getKey());
			pm.setNum(t.getValue());
			scsbpplist.add(pm);
		}
		
		
		
		//无效数据统计
		map.put("fct_code", "S001");
		List<TBL_WFXW_INVALID_STAT>  wxsjlist = service.querywxyytj(map);//查询无效原因统计数据
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询无效原因
		int wxzs=0;//无效总数
		for (int i = 0; i < wxsjlist.size(); i++) {
			wxzs+=(wxsjlist.get(i).getWxzs()==null?0:wxsjlist.get(i).getWxzs());//无效原因总数
			
			JSONObject jsStr = JSONObject.fromObject(wxsjlist.get(i).getWfxwtj());
			Iterator<String> iterator1 =jsStr.keys();
			while (iterator1.hasNext()) {
				String key = iterator1.next();//无效代码
				String value = jsStr.getString(key);//无效代码对应的数量
				for (SYS_FRM_CODE sys_FRM_CODE : wxyylist) {
					if(sys_FRM_CODE.getFc_code().equals(key)) {
						if(wxyymap.get(sys_FRM_CODE.getFc_name())==null) {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value));
						}else {
							wxyymap.put(sys_FRM_CODE.getFc_name(),Integer.parseInt(value)+wxyymap.get(sys_FRM_CODE.getFc_name()));
						}
					}
				}
			}
		}
		List<Entry<String, Integer>> wxlist = new ArrayList<Entry<String, Integer>>(wxyymap.entrySet());
		Collections.sort(wxlist, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		for(Entry<String, Integer> t:wxlist){
			pm = new Ranking();
			pm.setName(t.getKey());
			pm.setNum(t.getValue());
			wxpplist.add(pm);
		}
		ModelMap.put("scsbyypm", scsbpplist);
		ModelMap.put("wxyypm", wxpplist);
		return ModelMap;
		}
	/**
	 * 根据单位分组查询违法行为统计
	 * @param map
	 * @return
	 */
	@RequestMapping("wfxwttjbydept")
	public HashMap<String,Object> wfxwttjbydept(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		map.put("fct_code", "S001");
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询无效原因
		List<WfxwtjByDept> wfxwtjlist = service.wfxwttjbydept(map);//根据单位分组查询违法行为统计
		List<WfxwtjByDept> wxxwhj = service.wxxwhj(map);//违法行为合计
		for (int i = 0; i < wfxwtjlist.size(); i++) {
			wxxwhj.add(wfxwtjlist.get(i));
		}
		List<Wfxwtjinfo> wxlist=null;
		for (int i = 0; i < wxxwhj.size(); i++) {
			wxlist = new ArrayList<Wfxwtjinfo>();
			for (int j = 0; j < wxyylist.size(); j++) {
				Wfxwtjinfo wfxwinfo = new Wfxwtjinfo();
				wfxwinfo.setWfxwname(wxyylist.get(j).getFc_name());
				wfxwinfo.setWfxwcode(wxyylist.get(j).getFc_code());
				wxlist.add(wfxwinfo);
			}
			wxxwhj.get(i).setList(wxlist);
		}
		//统计
		for (int i = 0; i < wxxwhj.size(); i++) {
			String[] wftj = wxxwhj.get(i).getWfxwtj().split("-");
			for (int j = 0; j < wftj.length; j++) {
				JSONObject jsStr = JSONObject.fromObject(wftj[j]);
				Iterator<String> iterator1 =jsStr.keys();
				while (iterator1.hasNext()) {
					String key = iterator1.next();//无效代码
					String value = jsStr.getString(key);//无效代码对应的数量
					for (int k = 0; k < wxxwhj.get(i).getList().size(); k++) {
						if(wxxwhj.get(i).getList().get(k).getWfxwcode().equals(key)) {
							if(wxxwhj.get(i).getList().get(k).getNum()==null) {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value));
							}else {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value)+wxxwhj.get(i).getList().get(k).getNum());
							}
						}
					}
				}
			}
			for (int j = 0; j < wxxwhj.get(i).getList().size(); j++) {
				if(wxxwhj.get(i).getList().get(j).getNum()==null) {
					wxxwhj.get(i).getList().get(j).setWfzb("0%");
				}else {
					wxxwhj.get(i).getList().get(j).setWfzb(df.format(((double)wxxwhj.get(i).getList().get(j).getNum()/wxxwhj.get(i).getWxzs())*100)+"%");
				}
			}
		}
		
		ModelMap.put("wfxwtj", wxxwhj);
		ModelMap.put("wfxwyy", wxyylist);
		return ModelMap;
	}
	
	
	/**
	 * 根据单位分组查询上传失败原因统计
	 * @param map
	 * @return
	 */
	@RequestMapping("scsbyytjbydept")
	public HashMap<String,Object> scsbyytjbydept(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		map.put("fct_code", "T001");
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询无效原因
		List<WfxwtjByDept> wfxwtjlist = service.scsbyytjbydept(map);//根据单位分组查询上传失败原因统计
		List<WfxwtjByDept> wxxwhj = service.scsbhj(map);//上传失败合计
		for (int i = 0; i < wfxwtjlist.size(); i++) {
			wxxwhj.add(wfxwtjlist.get(i));
		}
		List<Wfxwtjinfo> wxlist=null;
		for (int i = 0; i < wxxwhj.size(); i++) {
			wxlist = new ArrayList<Wfxwtjinfo>();
			for (int j = 0; j < wxyylist.size(); j++) {
				Wfxwtjinfo wfxwinfo = new Wfxwtjinfo();
				wfxwinfo.setWfxwname(wxyylist.get(j).getFc_name());
				wfxwinfo.setWfxwcode(wxyylist.get(j).getFc_code());
				wxlist.add(wfxwinfo);
			}
			wxxwhj.get(i).setList(wxlist);
		}
		//统计
		for (int i = 0; i < wxxwhj.size(); i++) {
			String[] wftj = wxxwhj.get(i).getWfxwtj().split("-");
			for (int j = 0; j < wftj.length; j++) {
				JSONObject jsStr = JSONObject.fromObject(wftj[j]);
				Iterator<String> iterator1 =jsStr.keys();
				while (iterator1.hasNext()) {
					String key = iterator1.next();//无效代码
					String value = jsStr.getString(key);//无效代码对应的数量
					for (int k = 0; k < wxxwhj.get(i).getList().size(); k++) {
						if(wxxwhj.get(i).getList().get(k).getWfxwcode().equals(key)) {
							if(wxxwhj.get(i).getList().get(k).getNum()==null) {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value));
							}else {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value)+wxxwhj.get(i).getList().get(k).getNum());
							}
						}
					}
				}
			}
			for (int j = 0; j < wxxwhj.get(i).getList().size(); j++) {
				if(wxxwhj.get(i).getList().get(j).getNum()==null) {
					wxxwhj.get(i).getList().get(j).setWfzb("0%");
				}else {
					wxxwhj.get(i).getList().get(j).setWfzb(df.format(((double)wxxwhj.get(i).getList().get(j).getNum()/wxxwhj.get(i).getWxzs())*100)+"%");
				}
			}
		}
		
		ModelMap.put("wfxwtj", wxxwhj);
		ModelMap.put("wfxwyy", wxyylist);
		return ModelMap;
	}
	/**
	 * dclx:导出类型
	 * 1：无效原因  2：上传失败原因
	 * @param map
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("excel")
	public void export(@RequestBody HashMap<String,Object> map,
			HttpServletResponse response) throws IOException, ParseException {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
		List<WfxwtjByDept> wfxwtjlist = null;
		List<WfxwtjByDept> wxxwhj;
		String tablename="";
		String str="";
		if("1".equals(map.get("dclx"))) {
			map.put("fct_code", "S001");
			wfxwtjlist = service.wfxwttjbydept(map);//根据单位分组查询无效原因统计
			wxxwhj = service.wxxwhj(map);//违法行为合计
			tablename="无效原因列表";
			str="无效总数";
		}else {
			map.put("fct_code", "T001");
			wfxwtjlist = service.scsbyytjbydept(map);//根据单位分组查询上传失败原因统计
			wxxwhj = service.scsbhj(map);//违法行为合计
			tablename="上传失败原因列表";
			str="上传失败总数";
		}
		List<SYS_FRM_CODE> wxyylist = illegalservice.queryfrms(map);//动态查询基础数据表
		for (int i = 0; i < wfxwtjlist.size(); i++) {
			wxxwhj.add(wfxwtjlist.get(i));
		}
		List<Wfxwtjinfo> wxlist=null;
		for (int i = 0; i < wxxwhj.size(); i++) {
			wxlist = new ArrayList<Wfxwtjinfo>();
			for (int j = 0; j < wxyylist.size(); j++) {
				Wfxwtjinfo wfxwinfo = new Wfxwtjinfo();
				wfxwinfo.setWfxwname(wxyylist.get(j).getFc_name());
				wfxwinfo.setWfxwcode(wxyylist.get(j).getFc_code());
				wxlist.add(wfxwinfo);
			}
			wxxwhj.get(i).setList(wxlist);
		}
		//统计
		for (int i = 0; i < wxxwhj.size(); i++) {
			String[] wftj = wxxwhj.get(i).getWfxwtj().split("-");
			for (int j = 0; j < wftj.length; j++) {
				JSONObject jsStr = JSONObject.fromObject(wftj[j]);
				Iterator<String> iterator1 =jsStr.keys();
				while (iterator1.hasNext()) {
					String key = iterator1.next();//无效代码
					String value = jsStr.getString(key);//无效代码对应的数量
					for (int k = 0; k < wxxwhj.get(i).getList().size(); k++) {
						if(wxxwhj.get(i).getList().get(k).getWfxwcode().equals(key)) {
							if(wxxwhj.get(i).getList().get(k).getNum()==null) {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value));
							}else {
								wxxwhj.get(i).getList().get(k).setNum(Integer.parseInt(value)+wxxwhj.get(i).getList().get(k).getNum());
							}
						}
					}
				}
			}
			for (int j = 0; j < wxxwhj.get(i).getList().size(); j++) {
				if(wxxwhj.get(i).getList().get(j).getNum()==null) {
					wxxwhj.get(i).getList().get(j).setWfzb("0%");
				}else {
					wxxwhj.get(i).getList().get(j).setWfzb(df.format(((double)wxxwhj.get(i).getList().get(j).getNum()/wxxwhj.get(i).getWxzs())*100)+"%");
				}
			}
		}
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet(tablename);
        // 生成一种样式
        HSSFCellStyle style = wb.createCellStyle();
        
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        
     // 生成一种字体
        HSSFFont font = wb.createFont();
        // 设置字体
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 字体加粗
        font.setBold(true);
        // 在样式中引用这种字体
        style.setFont(font);
        
        HSSFCellStyle style2 = wb.createCellStyle();
        HSSFFont font2 = wb.createFont();
        // 设置字体
        font2.setFontName("微软雅黑");
        // 设置字体大小
        font2.setFontHeightInPoints((short) 12);
        style2.setAlignment(HorizontalAlignment.CENTER);//居中
        style2.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        style2.setWrapText(true); 
        
        // 在样式2中引用这种字体
        style2.setFont(font2);
     
        //表头第一行数据
        String[] headers1=new String[wxyylist.size()*2+2];
        for (int j = 0; j < headers1.length/2; j++) {
        	if(j==0) {
        		headers1[j*2]="部门";
        		headers1[j*2+1]=str;
        	}else {
        		headers1[j*2]=wxyylist.get(j-1).getFc_name();
        		headers1[j*2+1]=wxyylist.get(j-1).getFc_name();
        	}
		}

        //表头第二行数据
        String[] headers2=new String[wxyylist.size()*2];
        for (int i = 0; i < headers2.length/2; i++) {
        	headers2[i*2]="总数";
        	headers2[i*2+1]="占比(%)";
		}
       //表头第一行合并位置
        String[] headnum1=new String[wxyylist.size()+2];
        for (int i = 0; i < headnum1.length; i++) {
        	if(i==0) {
        		headnum1[i]="0,1,0,0";
        	}else if(i==1) {
        		headnum1[i]="0,1,1,1";
        	}else {
        		headnum1[i]="0,0,"+(2*i-2)+","+(2*i-1);
        	}
		}
        
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers1.length; i++) {

            sheet.autoSizeColumn(i, true);// 根据字段长度自动调整列的宽度
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers1[i]);
            cell.setCellStyle(style);
//            if (i >= 0 && i <= 18) {
                for (int j = 0; j < headers1.length; j++) {
                    // 从第j列开始填充
                    cell = row.createCell(j);
                    // 填充headers1[j]第j个元素
                    cell.setCellValue(headers1[j]);
                    cell.setCellStyle(style);
                }
//
//            }

        }
        // 动态合并单元格
        for (int i = 0; i < headnum1.length; i++) {

            sheet.autoSizeColumn(i, true);
            String[] temp = headnum1[i].split(",");
            Integer startrow = Integer.parseInt(temp[0]);
            Integer overrow = Integer.parseInt(temp[1]);
            Integer startcol = Integer.parseInt(temp[2]);
            Integer overcol = Integer.parseInt(temp[3]);
            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
        }
        
        //表头第二行数据填充
        HSSFRow headerrow = sheet.createRow(1);
        for (int i = 0; i < headers2.length; i++) {
        	sheet.autoSizeColumn(i+2);// 根据字段长度自动调整列的宽度
            HSSFCell cell = headerrow.createCell(i+2);
            cell.setCellValue(headers2[i]);
            cell.setCellStyle(style);
		}
        
        
        //表中数据
        for (int i = 0; i < wxxwhj.size(); i++) {
			HSSFRow datarow = sheet.createRow(i+2);
			for (int j = 0; j < wxxwhj.get(i).getList().size()*2+2; j++) {
				String value="";//值
				if(j==0) {
					value=wxxwhj.get(i).getGlbm();
				}else if(j==1) {
					value=wxxwhj.get(i).getWxzs()+"";
				}else {
					
					if((j-2)%2==0) {
						value=(wxxwhj.get(i).getList().get((j-2)/2).getNum()==null?"0":wxxwhj.get(i).getList().get((j-2)/2).getNum())+"";	
					}else {
						value=wxxwhj.get(i).getList().get((j-2)/2).getWfzb()+"";
					}
				}
				sheet.autoSizeColumn(j);// 根据字段长度自动调整列的宽度
                HSSFCell cell = datarow.createCell(j);
                cell.setCellValue(value);
                cell.setCellStyle(style);
			}
		}
        
        
        
        
        
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode(tablename, "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        
	}
}
