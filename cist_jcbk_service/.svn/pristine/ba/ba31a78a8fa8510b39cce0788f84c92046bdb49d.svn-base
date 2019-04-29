package com.cist.warnCountAnalyze.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cist.frame.page.PageInfo;
import com.cist.warnCountAnalyze.model.BaseData;
import com.cist.warnCountAnalyze.model.CarAlarmStat;
import com.cist.warnCountAnalyze.service.WarnCountAnalyzeService;



/**
 * 预警分析统计
 * 
 * @author 57150
 *
 */
@RequestMapping("warnCountAnalyze")
@RestController
public class WarnCountAnalyzeController {
	@Autowired
	private WarnCountAnalyzeService service;
/**
 * 根据条件groupBy之后根据得到的部门codeList再次查询
 * @param paramMap
 * @return
 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryList")
	public HashMap<String, Object>  queryList(@RequestBody HashMap<String, Object> paramMap) {
		List<BaseData> baseDataList = service.queryBaseDataByFct_Code("JC01");
		paramMap.put("JC01", service.queryBaseDataByFct_Code("JC01"));
		List<CarAlarmStat> list = service.queryCarAlarmStatList(paramMap);
		HashMap<String, CarAlarmStat> dataMap = new HashMap<String, CarAlarmStat>();
		for (CarAlarmStat car : list) {
			if (dataMap.containsKey(car.getGlbm())) {
				CarAlarmStat old = dataMap.get(car.getGlbm());
				HashMap<String, String> old_bxds = JSON.parseObject(old.getBxds(),HashMap.class);
				HashMap<String, String> old_dks = JSON.parseObject(old.getDks(),HashMap.class);
				HashMap<String, String> car_bxds = JSON.parseObject(car.getBxds(),HashMap.class);
				HashMap<String, String> car_dks = JSON.parseObject(car.getDks(),HashMap.class);
				//{"suspected":"10","noSuspected":"12"} 
				long old_xy = Long.valueOf(old_dks.get("suspected"));
				long old_fxy = Long.valueOf(old_dks.get("noSuspected"));
				long car_xy = Long.valueOf(car_dks.get("suspected"));
				long car_fxy = Long.valueOf(car_dks.get("noSuspected"));
				
				old_dks.put("suspected", Long.toString((old_xy + car_xy)));
				old_dks.put("noSuspected", Long.toString((old_fxy + car_fxy)));
				
				String new_dks = JSON.toJSONString(old_dks);
				
				car.setDks(new_dks);
				
				for (BaseData data : baseDataList) {
				
					long old_num = Long.valueOf(old_bxds.get(data.getCode()));
					long car_num = Long.valueOf(car_bxds.get(data.getCode()));
						old_bxds.put(data.getCode(), Long.toString((old_num + car_num)));
					
				}
				String newStr = JSON.toJSONString(old_bxds);
				car.setBxds(newStr);
				
				
				car.setYjsl(car.getYjsl()+old.getYjsl());
				car.setXds(car.getXds()+old.getXds());
				car.setQss(car.getQss()+old.getQss());
				car.setAsxds(car.getAsxds()+old.getAsxds());
				car.setAsqss(car.getYjsl()+old.getAsqss());
				
				dataMap.put(car.getGlbm(), car);
			} else {
				dataMap.put(car.getGlbm(), car);

			}
		}
		Set<String> keySet = dataMap.keySet();
		List<CarAlarmStat> carAlarmStatList = new ArrayList<CarAlarmStat>();
		for (String key : keySet) {
			carAlarmStatList.add(dataMap.get(key));
		}
		paramMap.put("data", dataMap);
		paramMap.put("list", carAlarmStatList);
		return paramMap;
	}
	/**
	 * 分页查询预警统计分析记录
	 * 
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public HashMap<String, Object> index(@RequestBody HashMap<String, Object> paramMap) {
		 HashMap<String, Object> resultMap = new HashMap<String,Object>();
		@SuppressWarnings("rawtypes")
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<CarAlarmStat> pageinfo = (PageInfo<CarAlarmStat>) service.querypageList(paramMap,
				info);
		List<CarAlarmStat> list = pageinfo.getList();
		paramMap.put("glbmList", list);
		HashMap<String, Object> test = this.queryList(paramMap);
		 @SuppressWarnings("unchecked")
		List<CarAlarmStat>  object = (List<CarAlarmStat>) test.get("list");
		pageinfo.setList(object);
		resultMap.put("data", pageinfo);
		resultMap.put("JC01", test.get("JC01"));
		return resultMap;
	}
}
