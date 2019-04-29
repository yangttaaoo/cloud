package com.cist.personalstats.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.personalstats.model.DeptInfo;
import com.cist.personalstats.model.PersonalStats;
import com.cist.personalstats.model.Progress;
import com.cist.personalstats.model.Series;
import com.cist.personalstats.service.PersonalStatsService;
import com.cist.personalstats.util.ExportExcel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("personalstats")
public class PersonalStatsController {

	@Autowired
	PersonalStatsService service;

	
	/**
	 * 数据分页条件查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/list")
	public PageInfo<PersonalStats> list(@RequestBody HashMap<String, Object> map) {
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<PersonalStats> pageinfo = (PageInfo<PersonalStats>)service.selectPersonalStatspageList(map,pinfo);
		return  pageinfo;
	}
	/**
	 * 查询采集单位信息
	 * 
	 * @return List<VwDevInfo>
	 */
	@RequestMapping(value = "selectbysysdepartinfo")
	public List<SysDepartInfo> selectBySysDepartInfo() {
		return service.selectBySysDepartInfo();
	}

	/**
	 * 个人工作统计
	 * 
	 * @return PageInfo<PersonalStats>
	 */
	@RequestMapping(value = "selectPersonalStats")
	public PageInfo<PersonalStats> selectPersonalStats(@RequestParam HashMap<String, Object> map) {
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("pageNum").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<PersonalStats> pageinfo = (PageInfo<PersonalStats>)service.selectPersonalStatspageList(map,pinfo);
		return  pageinfo;
	}
	/**
	 * 个人工作统计不分页
	 * 
	 * @return PageInfo<PersonalStats>
	 */
	@RequestMapping(value = "selectStats")
	public List<PersonalStats> selectStats(@RequestParam HashMap<String, Object> map) {
		List<PersonalStats> list = service.selectPersonalStats(map);
		return  list;
	}
	
	/**
	 * 个人工作统计根据违法行为统计
	 * 
	 * @return List<PersonalStats>
	 */
	@RequestMapping(value = "statsListByWfxw")
	public List<PersonalStats> statsListByWfxw(HashMap<String, Object> map) {
		return service.statsListByWfxw(map);
	}
	@RequestMapping(value = "statsListByCs")
	public List<PersonalStats> statsListByCs(HashMap<String, Object> map) {
		return service.statsListByFs(map);
	}
	@RequestMapping(value = "statsListByFs")
	public List<PersonalStats> statsListByFs(HashMap<String, Object> map) {
		return service.statsListByFs(map);
	}
	
	@RequestMapping(value = "progress")
	public Integer progress(@RequestBody HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
	return ExportExcel.index;
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
		
		List<PersonalStats> list = service.selectPersonalStats(map);
		PersonalStats personalStats = list.get(0);
		for(int i=0;i<4000;i++)
		{
			list.add(personalStats);
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
		ExportExcel<PersonalStats> ex = new ExportExcel<PersonalStats>();
		String[] headers = { "时间", "审核总数", "初审通过", "初审作废", "复审通过", "复审作废", "有效比例" };
		OutputStream out;
		try {
			out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 统计个人工作信息报表
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value = "/statsList")
	@ResponseBody
	public Map<String,Object> statsList(@RequestParam HashMap<String, Object> map) {
		HashMap<String,Object> hashmap=new HashMap<String,Object>();
		List<PersonalStats> list = selectStats(map);
        //1.分类赋值(横坐标)  
        List<String> category=new ArrayList<String>();  
            for(int i=0;i<list.size();i++){  
                category.add(list.get(i).getFzsj());  
            }  
            hashmap.put("category", category); 
        String[]  legend =new String[3];
        legend[0]="审核总数";
        legend[1]="初审通过";
        legend[2]="复审通过";
        hashmap.put("legend", legend);  
        //3.主要数据获取  
        List<Series> series = new ArrayList<Series>(); 
        List<Long> serisData1=new ArrayList<Long>();  
        List<Long> serisData2=new ArrayList<Long>();  
        List<Long> serisData3=new ArrayList<Long>();
        for (PersonalStats ps : list) {
        	serisData1.add((long)ps.getShzs());
        	serisData2.add((long)ps.getCstg());
        	serisData3.add((long)ps.getFstg());
		}
        series.add(new Series("审核总数", "line", serisData1));
        series.add(new Series("初审通过", "line", serisData2));
        series.add(new Series("复审通过", "line", serisData3));
        hashmap.put("series", series);
        return hashmap;
	}
	
	/**
	 * 管理部门树
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
}
