package com.cist.codemaintain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.codemaintain.model.Sys_frm_code;
import com.cist.codemaintain.model.Sys_frm_code_type;
import com.cist.codemaintain.service.CodeMaintainService;
import com.cist.frame.page.PageInfo;



/***
 * 
 * @Title:  CodeMaintainController.java   
 * @Package com.cist.codemaintain.controller 
 * @Description:    系统代码维护
 * @author: yt
 * @date:   2018年7月14日 下午14:27:02 
 * @version V1.0
 */

@RestController
@RequestMapping("codemaintain")
public class CodeMaintainController{

	@Autowired
	private CodeMaintainService service;

	/**
	 * 数据详情
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public PageInfo<Sys_frm_code> selectAll(@RequestBody HashMap<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Sys_frm_code> pageInfo = (PageInfo<Sys_frm_code>)service.queryAllpageList(map, info);
		return pageInfo;
	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("tolist")
	public List<Sys_frm_code_type> seletelist( Map<String, Object> map){
		List<Sys_frm_code_type> list = service.queryFrmType(map);
		return list;
	}

	/**
	 * 修改代码详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateCode(@RequestBody Map<String, Object> map){
		return service.update(map);
	}

	/**
	 * 添加代码详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer insertCode(@RequestBody Map<String, Object> map){
		return service.insert(map);
	}

	/**
	 * 删除代码详情
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteCode(@RequestBody Map<String, Object> map){
		return service.delete(map);
	}

}
