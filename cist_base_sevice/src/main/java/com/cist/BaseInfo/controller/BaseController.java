package com.cist.BaseInfo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.BaseInfo.service.BaseService;

@RestController
@RequestMapping("updateBaseInfo")
public class BaseController {

	@Autowired
	private BaseService service;

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
}
