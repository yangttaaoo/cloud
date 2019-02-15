package com.cist.systemparam.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.systemparam.model.SYS_param_conf;
import com.cist.systemparam.model.Sys_cfg_info;
import com.cist.systemparam.model.Sys_config;
import com.cist.systemparam.service.StmParamService;

@RestController
@RequestMapping("stmparam")
public class StmParamController {
	
	@Autowired
	private StmParamService service;
	
	
	
	/**
	 * 系统参数详情
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public List<SYS_param_conf> seleteCfg(@RequestBody Map<String, Object> map){
		List<SYS_param_conf> conf=new ArrayList<SYS_param_conf>();
		SYS_param_conf co = null;
		List<Sys_config> list =service.queryCfg(map);
		int num=0;
		TreeSet<String> hs = new TreeSet<String>();
		for (Sys_config  sys_config: list) {
			hs.add(sys_config.getSyci_type());
		}
		List<Sys_config> list1 = null;
			Iterator<String> it = hs.iterator();
			while(it.hasNext()){
				co = new SYS_param_conf();
				int count =0;
				list1 = new ArrayList<Sys_config>();
				String t = it.next();
				co.setSyci_type(t);
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getSyci_type().equals(t)){
						list1.add(list.get(i));
						num+=num;
						count++;
					}
				}
				co.setList(list1);
				co.setNum(count);
				num=0;
				conf.add(co);
			}
		
		
		return conf;
		
	}
	/**
	 * 系统参数详情
	 * @param map
	 * @return
	 */
	/*@RequestMapping("index")
	public List<Sys_config> seleteCfg(@RequestBody Map<String, Object> map){
		List<Sys_config> list = new ArrayList<>();
		int num=0;
		for (Sys_config  : list) {
			if (sys_config.getSyci_type().equals(sys_config.getSyci_type())){
				num++;
			}
			
		}
		
		Sys_config config = new Sys_config();
		List<Sys_config> list =service.queryCfg(map);
		int num=0;
		TreeSet<String> hs = new TreeSet<String>();
		for (Sys_config  sys_config: list) {
//			if (sys_config.getSyci_type().equals(sys_config.getSyci_type())){
//				num++;
//			}
			hs.add(sys_config.getSyci_type());
		}
		
			Iterator<String> it = hs.iterator();
			while(it.hasNext()){
				String t = it.next();
				for (Sys_config  sc: list) {
					if (sc.getSyci_type().equals(t)){
						num++;
					}
				}
				
				System.out.println("t:"+t+",num:"+num);
				num=0;
			}
		
		return list;
		
	}
	*/
	/**
	 * 修改参数详情
	 * @param map
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateCfg(@RequestBody Map<String, Object> map){
		return service.updateCfg(map);
	}
	
}
