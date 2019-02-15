package com.cist.devasset.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.devasset.model.Jtyw_sbzc_cs;
import com.cist.devasset.model.Jtyw_sbzc_sbtype;
import com.cist.devasset.model.Vw_jtyw_sbzc_info;
import com.cist.devasset.service.AssetService;
import com.cist.frame.page.PageInfo;

@RestController
@RequestMapping("asset")
public class AssetController {

	@Autowired
	private AssetService aService;
	
	/**
	 * 监控设备资产详情
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public PageInfo<Vw_jtyw_sbzc_info> selectAsset(@RequestBody Map<String, Object> map){
		PageInfo info = new PageInfo<>();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Vw_jtyw_sbzc_info> pageInfo = (PageInfo<Vw_jtyw_sbzc_info>)aService.queryAssetpageList(map, info);
		return pageInfo;
	}
	/**
	 * 设备类型名称
	 * @param map
	 * @return
	 */
	@RequestMapping("list")
	public List<Jtyw_sbzc_sbtype> selectType(Map<String, Object> map){
		return aService.queryType(map);
	}
	
	/**
	 * 厂商名称
	 * @param map
	 * @return
	 */
	@RequestMapping("cslist")
	public List<Jtyw_sbzc_cs> selectCsname(Map<String, Object> map){
		return aService.queryCsname(map);
	}
	
	/**
	 * 添加监控设备资产详情
	 * @param map
	 * @return
	 */
	@RequestMapping("insert")
	public Integer addAsset(@RequestBody Map<String, Object> map){
		String modelMap= map.get("device_type").toString();
		map.put("modelMap",aService.queryList(map));
		return aService.insertAsset(map);
	}
	
	/**
	 * 修改监控设备资产详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateAsset(@RequestBody Map<String, Object> map){
		return aService.updateAsset(map);
	}
	
	/**
	 * 删除监控设备资产详情
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteAsset(@RequestBody Map<String, Object> map){
		return aService.deleteAsset(map);
	}
	
	/**
	 * 批量删除
	 * @return
	 */
	@RequestMapping("deletes")
	public Integer deleteAll(@RequestParam("pk")  String[] pk){
		return aService.deleteAll(pk);
	}
}
