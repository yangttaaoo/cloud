package com.cist.alarm.config.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.alarm.config.model.AlarmConfig;
import com.cist.alarm.config.service.ConfigService;

@RestController
@RequestMapping("configs")
public class ConfigCotroller {
@Autowired
private ConfigService service;
    /**
     * 查询数据
     * @return
     */
    @RequestMapping("/all")
    public List<AlarmConfig> selectData(){
		return service.selectData();    	
    }
    /**
     *添加数据
     */
    @RequestMapping("/add")
    public Integer  add(@RequestBody HashMap<String,Object> map){
    	 map.put("temper",map.get("cmin").toString()+','+map.get("cmax").toString());
    	 map.put("voltage",map.get("vmin").toString()+','+map.get("vmax").toString());
    	Integer  cof=service.addData(map);
    	return cof;
    }
}
