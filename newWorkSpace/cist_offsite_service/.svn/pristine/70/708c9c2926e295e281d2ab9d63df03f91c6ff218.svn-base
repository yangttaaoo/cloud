package com.cist.filing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.filing.model.Monitor;
import com.cist.filing.model.Sys_frm_code;
import com.cist.filing.model.Sys_frm_code_type;
import com.cist.filing.model.Tbl_dev_vio_config;
import com.cist.filing.model.Vw_dev_info;
import com.cist.filing.service.FilingService;
import com.cist.frame.page.PageInfo;


@RestController
@RequestMapping("filing")
public class FilingController {

	@Autowired
	private FilingService filingService;
	
	/**
	 * 数据详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public PageInfo<Vw_dev_info> selectAll(@RequestBody Map<String, Object> map){
		PageInfo<Vw_dev_info> info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Vw_dev_info> pageInfo = (PageInfo<Vw_dev_info>)filingService.queryAllpageList(map, info);
		/*for (int i = 0; i < pageInfo.getList().size(); i++) {
			pageInfo.getList().get(i).getTbec_kkbh();
		}*/
		return pageInfo;
	}
	
	@RequestMapping("twolist")
	public List<Vw_dev_info> selectTwoList(@RequestBody Map<String, Object> map){
		List<Vw_dev_info> list = filingService.queryTwoList(map);
		
		
		for (int i = 0; i  < list.size();i++){
			list.get(i).getTbec_kkbh();
			System.out.println(list.get(i).getTbec_kkbh());
		}
		
		return list;
	}
	
	@RequestMapping("selectdetails")
	public List<Tbl_dev_vio_config> selectDetails(@RequestBody Map<String, Object> map){
		List<Tbl_dev_vio_config> list = filingService.queryDetails(map);
		
		
		return list;
	}
	@RequestMapping("seletelist")
	public List<Monitor> selectToMonitor(@RequestBody Map<String, Object> map){
		List<Monitor> list = filingService.queryToMonitor(map);
		return list;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("tolist")
	public Map<String, Object> seletelist( Map<String, Object> map){
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("toxzqhlist", filingService.queryXzgh());
		modelMap.put("tolist", filingService.queryMonitor());
		modelMap.put("tomv", filingService.queryMv());
		modelMap.put("tofrmtype", filingService.queryFrmType());
		return modelMap;
	}
	
	@RequestMapping("querylist")
	public Map<String, Object> selectMonitor(  Map<String, Object> map){
		/*HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		modelMap.put("listall", filingService.queryListAll());
		modelMap.put("frmcode", );*/
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<Sys_frm_code>list = filingService.queryListAll();
		for (int i = 0; i < list.size(); i++) {
			String fc_name = list.get(i).getFc_name();
			String fct_code = list.get(i).getFct_code();
			modelMap.put(fct_code, filingService.queryFrmCode(fc_name));
		}
		return modelMap;
	}
	

	/**
	 * 添加点位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer insertMonitor(@RequestBody Map<String, Object> map){
		return filingService.addMonitor(map);
	}
	
	/**
	 * 添加摄像机备案
	 * @param map
	 * @return
	 */
	@RequestMapping("insertdv")
	public Integer insertDV(@RequestBody Map<String, Object> map){
		
		return filingService.addVideo(map);
	}
	
	/*@RequestMapping("deletemanage")
	public Integer deleteManage(@RequestBody Map<String, Object> map){
		return filingService.deleteManage(map);
	}*/
	@RequestMapping("deletelist")
	public Integer deleteList(@RequestBody Map<String, Object> map){
		Integer isDelete;
		isDelete = filingService. deleteList(map);
		if (isDelete!=0) {
			isDelete = filingService.deleteManage(map);
			if (isDelete!=0) {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * 单个删除摄像机备案
	 * @param map
	 * @return
	 */
	@RequestMapping("deletedv")
	public Integer deleteDV(@RequestBody Map<String, Object> map){
		
		return filingService.deleteVideo(map);
	}
	
	
	/**
	 * 删除预置点位
	 * @param map
	 * @return
	 */
	@RequestMapping("deletegssp")
	public Integer deleteGssp(@RequestBody Map<String, Object> map){
		return filingService.deleteGssp(map);
	}
	/**
	 * 修改摄像机详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateDV(@RequestBody Map<String, Object> map){
		return filingService.update(map);
	}
}
