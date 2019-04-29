package com.cist.qwkhgrfb.controller;

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
import com.cist.frame.page.PageInfo;
import com.cist.qwkhgrfb.model.Publish;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;
import com.cist.qwkhgrfb.service.PublishService;
import com.cist.utils.ExportExcel;

@RestController
@RequestMapping("publish")
public class PublishController {
	 @Autowired
	  private PublishService service;
	  /**
	   * 查询所有
	   * @param map
	   * @return
	   */
	  @RequestMapping("all")
	  public PageInfo<Qw_Check_Pub> selectData(@RequestBody HashMap<String, Object> map){
			try {
				PageInfo page = new PageInfo();
				page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
				page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
				PageInfo<Qw_Check_Pub> info = (PageInfo<Qw_Check_Pub>) service.selectDatapageList(map, page);
				return info;
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
			List<Publish> list =service.downloadList(map);

			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			// 解决不同浏览器excle包名字含有中文时乱码的问题
			String downloadName = "勤务考核个人发布.xls";
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
			String[] headers = { "考核人", "考核指标 ", "综合指标", "是否合格 ", "指标日期", "指标年份", "管理单位" };
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
