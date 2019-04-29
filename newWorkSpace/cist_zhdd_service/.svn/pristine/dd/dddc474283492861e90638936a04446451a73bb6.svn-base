package com.cist.traffic.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.traffic.model.Data;
import com.cist.traffic.model.Event;
import com.cist.traffic.model.Series;
import com.cist.traffic.model.Traffic;
import com.cist.traffic.service.TrafficService;
import com.cist.utils.DateUtils;

@RestController
@RequestMapping("traffic")
public class TrafficController {
	@Autowired
	private TrafficService service;
    
	@RequestMapping("index")
	public HashMap<String, Object> index(@RequestBody HashMap<String,Object> maps ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		Date kssj=DateUtils.getBeginDayOfYesterday();
		Date jssj=DateUtils.getEndDayOfYesterDay();
		map1.put("zrsj", format.format(kssj));
		map1.put("zrsj1", format.format(jssj));
		Traffic jyzxn=service.selectOnpolice();//警员在线率
		Traffic jrjtzs=service.selectTodayTrafficNumber(maps);//今日交通总数 
		Traffic jtsjzs=service.selectNowTrafficNumber();//交通事件总数
		Traffic sgzd=service.selectSgzdToal(map);//施工占道总数
		Traffic jrsgzd=service.selectSgzdToal(map1);
		map.put("jyzxn", jyzxn.getJyzxn());//警员在线率
		map.put("jrjtzs", jrjtzs==null?0:jrjtzs.getSjzs());	
		map.put("jtsjzs", jtsjzs.getSjzss());
		map.put("sgzd", sgzd.getSfzd());
		if(service.selectSgzdToal(map1)!=null){			
		map.put("jrsgzd", jrsgzd.getSfzd());
		}
		return map;
	}
	/**
	 * 拥堵路段Top10
	 * @param maps
	 * @return
	 */
	@RequestMapping("road")
	public HashMap<String, Object> selectRoad(HashMap<String,Object> maps ) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		//分类赋值（横坐标）
		List<Event> list=service.selectOneNumber();
//		    for(int i=0;i<list.size();i++){
//		    	category.add(list.get(i).getSssj());
//		    }
//		    map.put("category", category);
		    String[] legend=new String[3];
		    legend[0]="审核总数";
		    legend[1]="通过数量";
		    legend[2]="作废数量";
		    map.put("legend", legend);
		    //3.主要数据获取
		    List<Series> series=new ArrayList<Series>();
		    List<Long> serisData1=new ArrayList<Long>(); 
		    for(Event ps:list){
	        	serisData1.add((long)ps.getNumbers());
	        }
			//分类赋值（横坐标）
			List<String> x=new ArrayList<String>();
			    for(int i=0;i<list.size();i++){
			    	x.add(list.get(i).getEvent_address());
			        series.add(new Series(list.get(i).getEvent_address(), "bar", serisData1));
			    }
	        map.put("series", series);
			return map;
	   
	}
	/**
	 * 道路事件
	 * @param maps
	 * @return
	 */
	@RequestMapping("evevts")
	public HashMap<String, Object> selectEvevts() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		//分类赋值（横坐标）
		List<Event> list=service.selectOneNumber();
		List<String> x=new ArrayList<String>();
		    for(int i=0;i<list.size();i++){
		    	x.add(list.get(i).getEvent_address());
		    }
		    map.put("x", x);
		//分类赋值（纵坐标）
			List<Integer> y=new ArrayList<Integer>();
		    for(int i=0;i<list.size();i++){
		    	y.add(list.get(i).getNumbers());
		    }
		    map.put("y", y);
		    //3.主要数据获取
		List<Series> series=new ArrayList<Series>();
		List<Long> serisData1=new ArrayList<Long>(); 
	    for(Event ps:list){
	      serisData1.add((long)ps.getNumbers());
	        }
			//分类赋值（横坐标）
		for(int i=0;i<list.size();i++){
		x.add(list.get(i).getEvent_address());
		series.add(new Series(list.get(i).getEvent_address(), "bar", serisData1));
			    }
	        map.put("series", series);
		return map; 
	}
	/**
	 * 警车动态百分率
	 * @param maps
	 * @return
	 */
	@RequestMapping("dynamic")
	public HashMap<String, Object> selectDynamic() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		List<Data> data=new ArrayList<Data>();
		data.add(new Data(70,"警车"));
		data.add(new Data(30,""));	    
	    map.put("data", data);
	    map.put("text","警车\n70%");
		return map; 
	}
	/**
	 * 警员动态百分率
	 * @param maps
	 * @return
	 */
	@RequestMapping("police")
	public HashMap<String, Object> selectPolice() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		List<Data> data=new ArrayList<Data>();
		data.add(new Data(30,"警员"));
		data.add(new Data(70,""));	    
	    map.put("data", data);
	    map.put("text","警员\n30%");
		return map; 
	}
	/**
	 * 电井动态百分率
	 * @param maps
	 * @return
	 */
	@RequestMapping("dianjin")
	public HashMap<String, Object> selectDianjin() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		List<Data> data=new ArrayList<Data>();
		data.add(new Data(60,"电井"));
		data.add(new Data(40,""));	    
	    map.put("data", data);
	    map.put("text","电井\n60%");
		return map; 
	}
	/**
	 * 卡口动态百分率
	 * @param maps
	 * @return
	 */
	@RequestMapping("kakou")
	public HashMap<String, Object> selectKakou() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		List<Data> data=new ArrayList<Data>();
		data.add(new Data(10,"卡口"));
		data.add(new Data(90,""));	    
	    map.put("data", data);
	    map.put("text","卡口\n10%");
		return map; 
	}
	/**
	 * 诱导动态百分率
	 * @param maps
	 * @return
	 */
	@RequestMapping("youdao")
	public HashMap<String, Object> selectYoudao() {
		HashMap<String,Object> map=new HashMap<String,Object>();
		List<Data> data=new ArrayList<Data>();
		data.add(new Data(20,"诱导"));
		data.add(new Data(80,""));	    
	    map.put("data", data);
	    map.put("text","诱导\n20%");
		return map; 
	}
	
}
