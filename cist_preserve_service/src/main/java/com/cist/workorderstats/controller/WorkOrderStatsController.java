package com.cist.workorderstats.controller;

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
import com.cist.workorderstats.model.JtywJobOrderInfo;
import com.cist.workorderstats.model.Series;
import com.cist.workorderstats.service.WorkOrderStatsService;


/***
 * 
 * @Title:  WorkOrderStatsController.java   
 * @Package com.cist.workorderstats.controller   
 * @Description:    工单统计
 * @author: yt
 * @date:   2018年7月25日 上午10:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("workorderstats")
public class WorkOrderStatsController{
    
	@Autowired
	private WorkOrderStatsService service;
	
	// 工单统计首页信息查询
	@RequestMapping("index")
	public Map<String, Object> index(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		//进入首页默认查询去年同比增长
		if(map.get("year")!=null&&map.get("year")!="null")
		{
			modelMap.put("lastInfo", service.selectAvgMonth(map));
		}
		JtywJobOrderInfo selectCount = service.selectCount(map);//统计工单总数、完成数量、未完成数量 
		//各维护公司工单占比
		List<JtywJobOrderInfo> listp = service.selectPercent(map);
		modelMap.put("count", selectCount);
		//工单数量对比
		List<JtywJobOrderInfo> list = service.selectCompany(map);
		//1.分类赋值(横坐标)  
        List<String> category=new ArrayList<String>();  
            for(int i=0;i<list.size();i++){  
                category.add(list.get(i).getComp_name());  
            }  
            modelMap.put("category", category); 
        String[]  legend =new String[3];
        legend[0]="完成";
        legend[1]="未完成";
        modelMap.put("legend", legend);  
        //3.主要数据获取  
        List<Series> series = new ArrayList<Series>(); 
        List<Long> serisData1=new ArrayList<Long>();  
        List<Long> serisData2=new ArrayList<Long>();  
        for (JtywJobOrderInfo ps : list) {
        	serisData1.add((long)ps.getWccount());
        	serisData2.add((long)ps.getWwccount());
		}
        series.add(new Series("完成", "bar", serisData1));
        series.add(new Series("未完成", "bar", serisData2));
        modelMap.put("series", series);
        
		
		//1.分类赋值(横坐标)  
        List<String> categoryp=new ArrayList<String>();  
            for(int i=0;i<listp.size();i++){  
                categoryp.add(listp.get(i).getComp_name());  
            }  
            modelMap.put("categoryp", categoryp); 
        String[]  legendp =new String[listp.size()];
        List<Series> serisData3=new ArrayList<Series>(); 
        for(int i=0;i<listp.size();i++)
        {
        	legendp[i]=listp.get(i).getComp_name();//获取工作名称
        	serisData3.add(new Series(listp.get(i).getoCount(),listp.get(i).getComp_name()));//饼图圆环data
        }
        modelMap.put("legendp", legendp);  
        modelMap.put("seriesp", new Series("工单占比", "pie", serisData3));
		
		return modelMap;
	}
	// 工单数量对比统计查询
	@RequestMapping("count")
	public Map<String, Object> count(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("lastInfo", service.selectAvgMonth(map));
		JtywJobOrderInfo selectCount = service.selectCount(map);//统计工单总数、完成数量、未完成数量 
		modelMap.put("count", selectCount);
		List<JtywJobOrderInfo> list = service.selectCompany(map);
		//1.分类赋值(横坐标)  
        List<String> category=new ArrayList<String>();  
            for(int i=0;i<list.size();i++){  
                category.add(list.get(i).getComp_name());  
            }  
            modelMap.put("category", category); 
        String[]  legend =new String[3];
        legend[0]="完成";
        legend[1]="未完成";
        modelMap.put("legend", legend);  
        //3.主要数据获取  
        List<Series> series = new ArrayList<Series>(); 
        List<Long> serisData1=new ArrayList<Long>();  
        List<Long> serisData2=new ArrayList<Long>();  
        for (JtywJobOrderInfo ps : list) {
        	serisData1.add((long)ps.getWccount());
        	serisData2.add((long)ps.getWwccount());
		}
        series.add(new Series("完成", "bar", serisData1));
        series.add(new Series("未完成", "bar", serisData2));
        modelMap.put("series", series);
		return modelMap;
	}
	
  
}
