package com.cist.khpd.target.controller;

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
import com.cist.khpd.target.model.Depart_info;
import com.cist.khpd.target.model.Police;
import com.cist.khpd.target.model.Target;
import com.cist.khpd.target.model.TargetMannage;
import com.cist.khpd.target.service.TargetService;
@RestController
@RequestMapping("target")
public class TargetController {
	@Autowired
	private TargetService service;
	/**
	 * 查询数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/all")
	public PageInfo<Target> selectData(@RequestBody HashMap<String, Object> map) {
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Target> info = (PageInfo<Target>) service.selectAllpageList(map, page);
			for(int i=0;i<info.getList().size();i++){
				if(info.getList().get(i).getEva_type().equals("1")){
					Target c= service.getDeptCodeNameHead(info.getList().get(i).getSypi_pk());
					info.getList().get(i).setSypi_code(c.getDept_code());
					info.getList().get(i).setSypi_name(c.getDept_head());
					info.getList().get(i).setDept_name(c.getDept_name());
				}else{
					Target a= service.getSypiCodeName(info.getList().get(i).getSypi_pk());
					Target b= service.getDeptName(info.getList().get(i).getSypi_pk());
					info.getList().get(i).setSypi_code(a.getSypi_code());
					info.getList().get(i).setSypi_name(a.getSypi_name());
					info.getList().get(i).setDept_name(b.getDept_name());
				}
			}
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 增加部门数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/addpart")
	public Integer add(@RequestBody HashMap<String, Object> map) {
		Integer info=service.deletePolice(map);
		List<Rule>  list=service.selectDepat();
		int a = 0;
		map.put("col_pk", 0);
		map.put("eva_num", map.get("ones"));
		int c = service.addData(map);
		for(int i=0;i<list.size();i++){
			map.put("eva_num", map.get(list.get(i).getLmmc()));
			map.put("col_pk", list.get(i).getPk());
			 a =  service.addData(map);
		}
		return a;
	}
	/**
	 * 增加个人数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/addperson")
	public Integer addperson(@RequestBody HashMap<String, Object> map) {
//		Integer info=service.deletePolice(map);
		List<Rule>  list=service.selectPorson();
		int a = 0;
		map.put("col_pk", 0);
		map.put("eva_num", map.get("ones"));
		int c = service.addPerson(map);
		for(int i=0;i<list.size();i++){
			map.put("eva_num", map.get(list.get(i).getLmmc()));
			map.put("col_pk", list.get(i).getPk());
			 a =  service.addPerson(map);
		}
		return a;
	}
	/**
	 * 删除数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/delete")
	public Integer delete(@RequestParam HashMap<String, Object> pk){
		  Integer in=service.deleteData(pk);
		return in;
	}
	/**
	 * 修改个人数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateperson")
	public Integer update(@RequestBody HashMap<String, Object> map){
		List<Rule>  list=service.selectPorson();
		int a = 0;
		map.put("col_pk", 0);
		map.put("eva_num", map.get("ones"));
		int c = service.updateData(map);
		for(int i=0;i<list.size();i++){
			map.put("eva_num", map.get(list.get(i).getLmmc()));
			map.put("col_pk", list.get(i).getPk());
			 a =  service.updateData(map);
		}
		return a;
	}
	/**
	 * 修改部门数据
	 * @param map
	 * @return
	 */
	@RequestMapping("/updatedepart")
	public Integer updateDepart(@RequestBody HashMap<String, Object> map){
		List<Rule>  list=service.selectDepat();
		int a = 0;
		map.put("col_pk", 0);
		map.put("eva_num", map.get("ones"));
		int c = service.updateData(map);
		for(int i=0;i<list.size();i++){
			map.put("eva_num", map.get(list.get(i).getLmmc()));
			map.put("col_pk", list.get(i).getPk());
			 a =  service.updateData(map);
		}
		return a;
	}
	/**
	 * 查询部门名称
	 */
	@RequestMapping("/depart")
	public List<Depart_info> selectDepart(){
		List<Depart_info>   info=service.selectDepart();
		return info;	
	}
	/**
	 * 查詢負責人
	 */
	@RequestMapping("/leader")
	public Depart_info selectLeader(@RequestBody String code){
		Integer pk=Integer.parseInt(code);
		Depart_info po=service.selectInfo(pk);
		return po;	
	}
	/**
	 * 查询警员信息
	 */
	@RequestMapping("/police")
	public List<Police> selectPolice(@RequestBody String code){
		Integer pk=Integer.parseInt(code);
		List<Police> po=service.selectPolice(pk);
		return po;	
	}
	/**
	 * 查询部门栏目名称
	 */
	@RequestMapping("/depatlmmc")
	public List<Rule> select(){
		List<Rule>  list=service.selectDepat();
		return list;		
	}
	/**
	 * 查询个人栏目名称
	 */
	@RequestMapping("/porsonlmmc")
	public List<Rule> selectPerson(){
		List<Rule>  list=service.selectPorson();
		return list;		
	}
	/**
	 * 查询个人考核指标
	 */
	@RequestMapping("/selectperson")
	public List<Target> selectPerson(@RequestBody HashMap<String, Object> map){
		List<Target> tar=service.selectTestInfo(map);
		return tar;
	}
	/**
	 * 根据sypi_pk警员的部门名称
	 */
	@RequestMapping("/selectDepatInfo")
	public Integer selectDepatInfo(@RequestBody HashMap<String, Object> map){
		Integer depat=service.selectDepatInfo(map);
		return depat;
	}
	/**
	 * 根据sypi_pk部门名称
	 */
	@RequestMapping("/selectDepat")
	public Integer selectDepat(@RequestBody HashMap<String, Object> map){
		Integer depat=service.selectDepatInfos(map);
		return depat;
	} 
	 /**
	    * 导出
	    */
	 @RequestMapping(value = "/downloadExcle")
		public String downloadExcle(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
				HttpServletRequest request) {
			   List<TargetMannage> list = service.selectExcel(map);
				response.reset();
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");
				// 解决不同浏览器excle包名字含有中文时乱码的问题
				String downloadName = "考核评定规则管理.xls";
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
				ExportExcel<TargetMannage> ex = new ExportExcel<TargetMannage>();
				String[] headers = { "编号","姓名" ,"指标类型 ", "所属部门", "综合指标", "指标年份" 
						,"指标日期","备注说明"};
				OutputStream out;
				try {
					out = response.getOutputStream();
					ex.exportExcel(headers, list, out,"yyyy-MM-dd");
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;	
	   }
}