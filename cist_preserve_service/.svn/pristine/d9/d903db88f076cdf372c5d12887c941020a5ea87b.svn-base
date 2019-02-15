package com.cist.wobacklog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.wobacklog.model.JtywJobProcess;
import com.cist.wobacklog.model.VwJtywDbgd;
import com.cist.wobacklog.model.VwJtywLog;
import com.cist.wobacklog.service.WoBacklogService;
import com.cist.workorderstats.model.JtywJobOrderInfo;
import com.cist.workorderstats.model.Series;
import com.cist.workorderstats.service.WorkOrderStatsService;


/***
 * 
 * @Title:  WorkOrderStatsController.java   
 * @Package com.cist.workorderstats.controller   
 * @Description:    待办工单
 * @author: yt
 * @date:   2018年7月25日 上午10:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("wobacklog")
public class WoBacklogController{
    
	@Autowired
	private WoBacklogService service;
	
	
	//查询工单操作日志
	@RequestMapping("selectInfo")
	public Map<String,Object> selectLog(@RequestBody HashMap<String,Object> map) {
		Map<String,Object> modelMap=new HashMap<String,Object>();
			List<VwJtywLog> selectLog = service.selectLog(map);
			modelMap.put("selectDev", service.selectDev(map));//查询工单对应的故障设备
			modelMap.put("selectLog", selectLog);//查询工单对应的操作日志
			return modelMap;
		}
	// 工单统计首页信息查询
		@RequestMapping("list")
		public Map<String,Object> list(@RequestBody HashMap<String,Object> map) {
			Map<String,Object> modelMap=new HashMap<String,Object>();
			//首页列表查询
				PageInfo pinfo = new PageInfo();
			    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
				pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
				PageInfo<VwJtywDbgd> pageinfo=(PageInfo<VwJtywDbgd>)service.listpageList(map, pinfo);
				modelMap.put("pageInfo", pageinfo);
				modelMap.put("count", service.selectCount(map));
				VwJtywDbgd selectAvg = service.selectAvg(map);
				modelMap.put("avg", selectAvg);
				return modelMap;
				
			}
		// 工单统计首页信息查询
				@RequestMapping("condtionList")
				public Map<String,Object> condtionList(@RequestBody HashMap<String,Object> map) {
					Map<String,Object> modelMap=new HashMap<String,Object>();
					//首页列表查询
						PageInfo pinfo = new PageInfo();
					    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
						pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
						PageInfo<VwJtywDbgd> pageinfo=(PageInfo<VwJtywDbgd>)service.listpageList(map, pinfo);
						modelMap.put("pageInfo", pageinfo);
						return modelMap;
						
					}
				
	// 更新工单任务百分比
	@RequestMapping("updatepercent")
	public String updatesave(@RequestBody HashMap<String, Object> map) {
		Integer update = service.updatePercent(map);
//		if(map.get("complete_percentage").equals("100"))
//		{
//			
//		}
		if (update > 0) {
			return "{\"result\":\"更新成功\"}";
		} else {
			return "{\"result\":\"更新失败\"}";
		}

	}

	// 更新工单状态为接收状态
	@RequestMapping("updatereceive")
	public String updateReceive(@RequestBody HashMap<String, Object> map) {
		Integer update = service.update(map);
		if (update > 0) {
			
			return "{\"result\":\"接收成功\"}";
		} else {
			return "{\"result\":\"接收失败\"}";
		}

	}
	
}
