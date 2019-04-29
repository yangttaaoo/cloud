package com.cist.deptpublish.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.deptpublish.service.DeptPulishService;
import com.cist.frame.page.PageInfo;
import com.cist.qwkhgrfb.model.Publish;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;
import com.cist.utils.ExportExcel;

@RestController
@RequestMapping("deptpub")
public class DeptPulishController {
	@Autowired
	private DeptPulishService dService;
	
	@RequestMapping("index")
	public PageInfo<Qw_Check_Pub> index(@RequestBody HashMap<String, Object> map){
		PageInfo pInfo = new PageInfo();
		String sfhg = (String) map.get("sfhg");
		if (sfhg.equals("2")) {
			map.put("sfhg", "");
		}
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_Check_Pub> pageInfo = (PageInfo<Qw_Check_Pub>) dService.selectDeptPubpageList(map, pInfo);
		return pageInfo;
	}
	
	/** 导出
	 */
	@RequestMapping(value = "/downloadExcle")
	public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
		String sfhg = (String) map.get("sfhg");
		if (sfhg.equals("2")) {
			map.put("sfhg", "");
		}
		List<Publish> list =dService.downloadList(map);
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 解决不同浏览器excle包名字含有中文时乱码的问题
		String downloadName = "勤务考核单位发布.xls";
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
		ExportExcel<Publish> ex = new ExportExcel<Publish>();
		String[] headers = { "考核单位", "考核指标 ", "综合指标", "是否合格 ", "指标日期", "指标年份", "管理单位" };
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











