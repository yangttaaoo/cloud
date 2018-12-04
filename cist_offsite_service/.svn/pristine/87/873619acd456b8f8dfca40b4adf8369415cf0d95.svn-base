package com.cist.speedillegal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.speedillegal.model.Speed_Illegal_Code;
import com.cist.speedillegal.model.TBL_OFFE_SPEED_INFO;
import com.cist.speedillegal.service.SpeedIllegalService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/speedillegal")
public class SpeedIllegalController {
	@Autowired
	private SpeedIllegalService service;
	/**
	 * 更新超速违法代码
	 * @param map
	 * @return
	 */
	@RequestMapping("/updatespeedillegal")
	public Integer updatespeedillegal(@RequestBody HashMap<String, Object> map){
		List<TBL_OFFE_SPEED_INFO> list=new ArrayList<TBL_OFFE_SPEED_INFO>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {  
			   String key = entry.getKey().toString();  
			   String value = entry.getValue().toString();  
			   TBL_OFFE_SPEED_INFO sp=new TBL_OFFE_SPEED_INFO();
			   sp.setPk(Integer.parseInt(key));
			   if(value==null){
				   sp.setTbsi_wfdm(null);
			   }else{
				   sp.setTbsi_wfdm(value);
			   }
			   list.add(sp);
			  }  
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		modelMap.put("speedillegal", list);
		Integer count = service.updatespeed(modelMap);
		return count;
	}
	
	/**
	 * 查询超速违法代码
	 * @return
	 */
	@RequestMapping("queryspeed")
	public List<Object> queryspeed(){
		List<TBL_OFFE_SPEED_INFO> list = service.queryspeed();
		List<Object> list1=new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTbsi_wfdm()!=null) {
				list1.add(list.get(i).getTbsi_wfdm());
			}else {
				list1.add("");
			}			
		}
		return list1;
	}
}
