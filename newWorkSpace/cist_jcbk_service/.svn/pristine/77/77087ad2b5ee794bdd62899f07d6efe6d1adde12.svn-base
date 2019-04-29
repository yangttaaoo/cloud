package com.cist.yjgl.ljqygl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.yjgl.ljqygl.model.Jcbk_Ljqy;
import com.cist.yjgl.ljqygl.service.LjqyglService;
@RestController
@RequestMapping("ljqygl")
@SuppressWarnings("unchecked")
public class LjqyglController {
	@Autowired
	private LjqyglService service;
	@RequestMapping("queryljqygl")
	public PageInfo<Jcbk_Ljqy> queryljqygl(@RequestBody HashMap<String, Object> map) {
		PageInfo info = new PageInfo();
	    info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Jcbk_Ljqy> pagelist = (PageInfo<Jcbk_Ljqy>)service.queryljqyglpageList(map, info);
		for (int i = 0; i < pagelist.getList().size(); i++) {
			pagelist.getList().get(i).setDept_name(service.querydept_name(pagelist.getList().get(i).getDept_id().toString()));
			pagelist.getList().get(i).setPolice_name(service.querypolicename(pagelist.getList().get(i).getCreate_user().toString()));
		}
		return pagelist;
		
	}
	/**
	 * 添加拦截区域管理
	 * @param map
	 * @return
	 */
	@RequestMapping("addljqygl")
	public Integer addljqygl(@RequestBody HashMap<String, Object> map) {
		return service.addljqygl(map);
	}
	/**
	 * 删除（单条、批量）拦截区域管理
	 * @param map
	 * @return
	 */
	@RequestMapping("delljqygl")
	public Integer delljqygl(@RequestBody HashMap<String, Object> map) {
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
		return service.delljqygl(map);
	}
	/**
	 * 更新拦截区域管理
	 * @param map
	 * @return
	 */
	@RequestMapping("updateljqygl")
	public Integer updateljqygl(@RequestBody HashMap<String, Object> map) {
		return service.updateljqygl(map);
	}
	
}
