package com.cist.softexploitdev.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.softexploitdev.service.SoftExploitDevService;
import com.cist.visitinterface.model.SjgxDevCompany;

@RestController
@RequestMapping("softexploitdev")
@SuppressWarnings("unchecked")
public class SoftExploitDevController {
	@Autowired
	private SoftExploitDevService service;
	/**
	 * 根据条件查询接口开发单位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("list")
	public PageInfo<SjgxDevCompany> querylist(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		if(map.get("currentPage")!=null){
			info.setPageNum( Integer.parseInt(map.get("currentPage").toString()) );
		}else{
			info.setPageNum(1);
		}
		if(map.get("pageSize")!=null){
			info.setPageSize(Integer.parseInt(map.get("pageSize").toString()) );
		}else{
			info.setPageSize(9);
		}
		Object obj = service.querylistpageList(map,info);
		PageInfo<SjgxDevCompany> list =(PageInfo<SjgxDevCompany>) obj;
		return list;
	}
	/**
	 * 添加接口开发单位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer add(@RequestBody HashMap<String,Object> map) {
		if(service.queryid()==null) {
			map.put("pk_id", 1);
		}else {
			int pk_id = service.queryid();
			map.put("pk_id", pk_id+1);
		}
		Integer count = service.add(map);
		return count;
	}
	/**
	 * 更新接口开发单位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer update(@RequestBody HashMap<String,Object> map) {
		return service.update(map);
	}
	/**
	 * 删除接口开发单位信息
	 * @param map
	 * @return
	 */
	@RequestMapping("del")
	public Integer del(@RequestBody HashMap<String, Object> map) {
		// 判断是否为空或者空字符串及删除类型（单条删除或者批量删除）
		String pk_id = map.get("pk_id").toString();
		if (null != pk_id && pk_id != "" && pk_id.indexOf(",") != -1) {
			pk_id = pk_id.substring(0, pk_id.length() - 1);
			String sbb[] = pk_id.split(",");
			map.put("pk_id", sbb);
		} else {
			String[] sbb = new String[1];
			sbb[0] = pk_id;
			map.put("pk_id", sbb);
		}
		Integer count = service.del(map);
		return count;
	}
}
