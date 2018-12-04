package com.cist.serviceconfig.illegalconfig.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.serviceconfig.illegalconfig.service.IllegalConfigService;

@RestController
@RequestMapping("config")
public class IllegalConfigController {

	@Autowired
	private IllegalConfigService iConfigService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("toindex")
	public List<TblOffeCateInfo> selectAll(){
		return iConfigService.selectAll();
	}
	
	/**
	 * 违法行为代码详情
	 * @return
	 */
	@RequestMapping("querywname")
	public PageInfo<TblOffeCateInfo> queryNameCode(@RequestBody Map<String, Object> map){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));

		PageInfo<TblOffeCateInfo> pageInfo =(PageInfo<TblOffeCateInfo>)iConfigService.selectNameCodepageList(map, info);
				return pageInfo;
	}
	
	
	
	/**
	 * 修改违法行为详情
	 * @param map
	 * @return
	 */
	@RequestMapping("updatewfxw")
	public Integer updateWfxw(@RequestBody HashMap<String,Object> map){
		try {
			Integer uInteger = iConfigService.updateWfxw(map);
			return uInteger;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("queryform")
	public List<TblOffeCateInfo> queryForm(@RequestBody HashMap<String, Object> map){
		return iConfigService.queryForm(map);
	}
	
	/**
	 * 添加违法数据
	 * @return
	 */
	@RequestMapping("addwfxw")
	public Integer addWfxw(@RequestBody HashMap<String,Object> map){
		return iConfigService.insertWfxw(map);
	}
	/**
	 * 删除违法行为数据
	 * @param map
	 * @return
	 */
	@RequestMapping("deletewfxw")
	public Integer deleteWfxw(@RequestBody HashMap<String,Object> map){
		return iConfigService.deleteWfxw(map);
	}
	
	/**
	 * 验证code
	 * @param map
	 * @return
	 */
	@RequestMapping("verifycode")
	public TblOffeCateInfo verifyCode(@RequestBody HashMap<String,Object> map){
	
		TblOffeCateInfo code = iConfigService.verifyCode(map);
		return code;
	}
	
	/**
	 * 批量删除违法行为数据
	 * @param map
	 * @return
	 */
	@RequestMapping("deletewfxws")
	   public Integer deleteAll(@RequestParam("pk")  String[] pk){
		  Integer in=iConfigService.deleteAll(pk);
		return in;
	   }
}
