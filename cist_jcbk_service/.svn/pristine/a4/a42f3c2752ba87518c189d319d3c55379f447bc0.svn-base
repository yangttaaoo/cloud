package com.cist.messagetemplateconfig.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.messagetemplateconfig.model.Jcbk_sms_template;
import com.cist.messagetemplateconfig.model.Sys_frm_code;
import com.cist.messagetemplateconfig.service.MessageConfigService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/messageconfig")
public class MessageConfigCtroller {
	@Autowired
	private MessageConfigService service;
	
	/**
	 * 查询所有短信模板信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Jcbk_sms_template> selectData(@RequestBody HashMap<String, Object> map) {
		PageInfo page = new PageInfo();
		page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcbk_sms_template> info = (PageInfo<Jcbk_sms_template>) service.selectDatapageList(map, page);
		return info;
	}
	
	/**
	 * 查询可选项
	 * @param map
	 * @return
	 */
	@RequestMapping("selectKxx")
	public List<HashMap<String, Object>> selectKxz(@RequestBody HashMap<String,Object> map) {
		List<Sys_frm_code> selectKxx = service.selectKxx(map);
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Sys_frm_code sys_frm_code : selectKxx) {
			HashMap<String, Object> modelMap=new HashMap();
			modelMap.put("key", sys_frm_code.getFc_code());
			modelMap.put("exm", "{"+sys_frm_code.getFc_code().toLowerCase()+"}");
			modelMap.put("title", sys_frm_code.getFc_name());
			listmap.add(modelMap);
		}
		return listmap;
	}
	
	/**
	 * 增加数据
	 */
	@RequestMapping("/add")
	public Integer addMessage(@RequestBody HashMap<String, Object> map) {
		try {
			service.addData(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	
	

	/**
	 * 修改数据
	 */
	@RequestMapping("/update")
	public Integer updateCall(@RequestBody HashMap<String, Object> map) {
		try {
			service.updateData(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	public Integer deleteData(@RequestBody HashMap<String, Object> map) {
		try {
			service.deleteData(map);
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 2;
		}
	}
}
