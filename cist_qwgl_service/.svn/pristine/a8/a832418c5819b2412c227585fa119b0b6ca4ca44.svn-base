package com.cist.qwgrfx.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.rules.model.ExportExcel;
import com.cist.khpdgl.model.Qw_Appraise_Reculations;
import com.cist.personageassess.model.Qw_individual_assessment;
import com.cist.qwgrfx.model.Excels;
import com.cist.qwgrfx.model.IndividualInfo;
import com.cist.qwgrfx.model.NumList;
import com.cist.qwgrfx.model.SysPoliceInfo;
import com.cist.qwgrfx.service.QwgefxService;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;

@RestController
@RequestMapping("grfx")
public class QwgefxController {

	@Autowired
	private QwgefxService service;
	
	@RequestMapping("index")
	public PageInfo<Qw_Check_Pub> selectPersonAll(@RequestBody Map<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_Check_Pub> pageInfo = (PageInfo<Qw_Check_Pub>)service.selectAllpageList(map, pInfo);
		//Qw_Check_Pub checkName = new Qw_Check_Pub();
		//checkName.setUserName(map.get("fk_user_id"));
			
		
		
		
		
	    return pageInfo;
	}
	
	@RequestMapping("list")
	public PageInfo<IndividualInfo> selectPersonAllList(@RequestBody Map<String, Object> map){
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<IndividualInfo> pageInfo = (PageInfo<IndividualInfo>)service.selectAllListpageList(map, pInfo);
		
		
	    return pageInfo;
	}
	
	@RequestMapping("police")
	public List<SysPoliceInfo> selectPolice(){
		List<SysPoliceInfo> isPolice = service.selectPolice();
		return isPolice;
	}
	/**
	 * 基础数据
	 * @param map
	 * @return
	 */
	@RequestMapping("selectlist")
	public Map<String,Object> selectList() {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
	
		return modelMap;
	}
	
	@RequestMapping("personlist")
	public Qw_individual_assessment  selectPersonlist(@RequestBody Integer pk_id){
		return service.querypersonageassessinfo(pk_id);
	}
	
	@RequestMapping("selectrecula")
	public List<Qw_Appraise_Reculations> selectRecula(@RequestBody Integer pk_id){
		return service.selectReculations(pk_id);
	}
	
	@RequestMapping("selectCar")
	public HashMap<String, Object> selectCar(@RequestBody HashMap<String, Object> map) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<NumList> list = service.selectAll(map);
		
		List<String> category = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			category.add(list.get(i).getTopic_name());
		}
		hashmap.put("category", category);
		
		List<Integer> series = new ArrayList<Integer>();
		
		List<Integer> series1 = new ArrayList<Integer>();
		for (NumList integer : list) {
			series.add(integer.getNum());
			series1.add(integer.getNum1());
		}
		
		
		hashmap.put("series1", series1);
		hashmap.put("series", series);
		return hashmap;
	}
	
	@RequestMapping("selectdesc")
	public HashMap<String, Object> selectDesc(@RequestBody HashMap<String, Object> map){
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("desclist", service.selectDesc(map));
		return hashmap;
	}
	
	@RequestMapping(value = "/downloadlist")
	public List<Excels> downloadList(@RequestParam HashMap<String, Object> map){
		try {
			List<Excels> list = service.selectAllList(map);
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/** 导出
	 */
	@RequestMapping(value = "/downloadExcle")
	public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
		List<Excels> list = downloadList(map);

		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 解决不同浏览器excle包名字含有中文时乱码的问题
		String downloadName = "违法数据查询数据.xls";
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
		ExportExcel<Excels> ex = new ExportExcel<Excels>();
		String[] headers = { "考核条例", "考核评分 ", "评定指标", "指标合格 "};
		OutputStream out;
		try {
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out,"yyyy-MM-dd HH:mm:ss");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
}
