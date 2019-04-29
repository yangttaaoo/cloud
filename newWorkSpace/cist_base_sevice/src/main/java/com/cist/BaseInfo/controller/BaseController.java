package com.cist.BaseInfo.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.service.BaseService;
import com.cist.frame.utils.SysTempStoreUtils;

@RestController
@RequestMapping("updateBaseInfo")
public class BaseController {

	@Autowired
	private BaseService service;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("ObjectredisTemplate")
	private RedisTemplate redisTemplate;

	@RequestMapping("updatePassWord")
	public Map<String, Object> updatePassword(@RequestBody Map<String, Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		String msg = "2";
		try{
			service.updatePassword(param);
			msg = "1";
		}catch(Exception e){
			e.printStackTrace();
			msg = "2";
		}
		map.put("msg", msg);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("refreshCache")
	public Map<String,Object> refreshCache(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<BaseDataInfo> list = this.service.queryBaseList();
			for(BaseDataInfo info : list){
				String fct_code = info.getFct_code().trim();
				String fc_code = info.getFc_code().trim();
				ValueOperations<Serializable, Object> operations1 = this.redisTemplate.opsForValue();
				operations1.set("key_"+fct_code+"_"+fc_code, info);
			}
			map.put("syscfg",SysTempStoreUtils.getSysConfig("SCFG"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
