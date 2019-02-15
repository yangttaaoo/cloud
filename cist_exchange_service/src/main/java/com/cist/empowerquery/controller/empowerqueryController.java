package com.cist.empowerquery.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.empowerquery.service.empowerqueryService;
import com.cist.frame.page.PageInfo;
import com.cist.interfaceapply.model.SjgxInterfaceUseApply;
import com.cist.interfaceapply.model.VwDeptList;
import com.cist.interfaceapply.service.InterApplyService;

/***
 * 
 * @Title:  empowerqueryController.java   
 * @Package com.cist.empowerquery.controller
 * @Description:   使用接口授权查询
 * @author: yt
 * @date:   2018年7月11日 下午14:10:25
 * @version V1.0
 */

@RestController
@RequestMapping("empowerquery")
public class empowerqueryController {
	
	@Autowired
	private empowerqueryService service;

	@Autowired
	private InterApplyService applyservice;

	
	/**
	 * 首页分页条件查询接口使用申请列表
	 * 
	 * @return PageInfo<SjgxInterfaceUseApply>
	 */
	@RequestMapping("list")
	public PageInfo<SjgxInterfaceUseApply> select(@RequestBody HashMap<String,Object> map){
		try{	
		PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<SjgxInterfaceUseApply> pageinfo=(PageInfo<SjgxInterfaceUseApply>)service.listpageList(map, pinfo);
		 return pageinfo;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 授权首页查询条件下拉列表查询
	 * 
	 * @return HashMap<String,Object>
	 */
	@RequestMapping(value ="index")
	public HashMap<String,Object> selectDept(@RequestParam  HashMap<String,Object> map){
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
	     List<VwDeptList> selectDept = applyservice.selectDept(map);
	     modelMap.put("deptList", selectDept);
	     return modelMap;
	}
	
}
