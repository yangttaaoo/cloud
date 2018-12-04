package com.cist.khpd.rules.controller;
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
import com.cist.khpd.rules.model.ExportExcel;
import com.cist.khpd.rules.model.Rule;
import com.cist.khpd.rules.model.RuleMannage;
import com.cist.khpd.rules.service.RuleService;
@RestController
@RequestMapping("rule")
public class RuleController {
	@Autowired
	private RuleService service;
    /**
     * 查询数据
     * @param map
     * @return
     */
	@RequestMapping("/all")
	public PageInfo<Rule> selectData(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Rule> info = (PageInfo<Rule>) service.seleteDatapageList(map, page);
			return info;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	/**
	 * 增加条例数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/add")
	public Integer addData(@RequestBody HashMap<String, Object>  map){
		Integer data=service.addData(map);
		return data;		
	}
	/**
	 * 增加栏目数据
	 */
	@RequestMapping("/addBanner")
	public Integer addBanner(@RequestBody HashMap<String, Object>  map){
		Integer data=service.addBanner(map);
		return data;		
	}
	/**
	 * 删除数据
	 * @param pk
	 * @return
	 */
	@RequestMapping("/delete")
	public Integer deleteData(@RequestParam HashMap<String,Object> pk){
		Integer  data=service.deleteData(pk);
		return data;
	}
	/**
	 * 更新数据
	 */
	@RequestMapping("/update")
	public Integer updateData(@RequestBody HashMap<String,Object> map){
		Integer  da=service.updateData(map);
		return da;
	}
	/**
	 * 查询栏目名称
	 */
	@RequestMapping("/lmmc")
	public List<Rule> select(){
		List<Rule>  list=service.selecteLmmc();
		return list;		
	}
	  /**
	    * 导出
	    */
	   @RequestMapping(value = "/downloadExcle")
		public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
				HttpServletRequest request) {
			   List<RuleMannage> list = service.selecteDatas(map);
				response.reset();
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				// 解决不同浏览器excle包名字含有中文时乱码的问题
				String downloadName = "数据有效率统计.xls";
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
				ExportExcel<RuleMannage> ex = new ExportExcel<RuleMannage>();
				String[] headers = { "编号", "栏目名称 ", "条例名称", "栏目分值 ", "栏目/条例说明" 
						,"评定规则","条例分值","创建时间","是否启用"};
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