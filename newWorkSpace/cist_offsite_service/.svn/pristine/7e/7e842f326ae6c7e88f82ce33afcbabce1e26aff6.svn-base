package com.cist.redillegal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.cist.picture.service.PictureService;
import com.cist.redillegal.service.RedIllegalService;
import com.cist.redlist.model.RedListInfo;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/redillegal")
public class RedIllegalController {
	
	@Autowired
	private RedIllegalService service;
	@Autowired
	InvalidTrialService iService;
	@Autowired
	PictureService pService;
	
	/**
	 * 红名单违法的多条件查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="redIllegalList")
	public PageInfo<TblOffeEvdiInfo> redIllegalpageList(@RequestBody HashMap<String,Object> map) {
		try{
			ArrayList sbbh=(ArrayList)map.get("sbbh");
			//设备编号多选编号分隔数组用作查询
			if(sbbh.size()>0)
			{
					map.put("list", sbbh);
			}
		    PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<TblOffeEvdiInfo> pageinfo = (PageInfo<TblOffeEvdiInfo>)service.redIllegalpageList(map,pinfo);
			return pageinfo;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 红名单违法数据单条数据查看
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectOne")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		PageInfo<TblOffeEvdiInfo> selectByCondition = redIllegalpageList(map);
		   modelMap.put("tboc_name",selectByCondition.getList().get(0).getWfxwname());//根据违法行为违法记分等信息
		  modelMap.put("tblOffeCate", iService.selectByWfxw(modelMap));//违法记分信息
		  modelMap.put("list",selectByCondition);
		return modelMap;
	}
}
