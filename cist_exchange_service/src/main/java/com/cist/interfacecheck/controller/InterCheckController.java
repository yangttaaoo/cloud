package com.cist.interfacecheck.controller;

import java.util.HashMap;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.interfaceapply.model.SjgxInterfaceUseApply;
import com.cist.interfacecheck.service.InterCheckService;

/***
 * 
 * @Title:  InterCheckController.java   
 * @Package com.cist.interfacecheck.controller
 * @Description:    接口审核
 * @author: yt
 * @date:   2018年7月11日 下午9:10:25
 * @version V1.0
 */

@RestController
@RequestMapping("interfacecheck")
public class InterCheckController {
	
	@Autowired
	private InterCheckService service;
	
	//审核通过
	@RequestMapping("pass")
	public String pass(@RequestBody HashMap<String, Object> map) {
		String license_code = UUID.randomUUID().toString().replace("-","").toLowerCase();//uuid生成的授权码并去掉-
		map.put("license_code", license_code);
		Integer pass = service.pass(map);
		if(pass>0)
		{
			return  "{\"result\":\"操作成功\"}";
		}
		return "{\"result\":\"操作失败\"}";
	}

	//审核不通过
	@RequestMapping("notPass")
	public String notPass(@RequestBody HashMap<String, Object> map) {
		Integer notPass = service.notPass(map);
		if(notPass>0)
		{
			return  "{\"result\":\"操作成功\"}";
		}
		return "{\"result\":\"操作失败\"}";
	}
	
	/**
	 * 首页分页条件查询接口使用审核审核中数据列表
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

	
}
