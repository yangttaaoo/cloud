package com.cist.redexamine.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.redexamine.service.RedExamineService;


@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/redexamine")
public class RedExamineController {
	@Autowired
	private RedExamineService service;
	
	/**
	 * 红名单审核
	 * @param map
	 */
	@RequestMapping("examineRedInfo")
	public int  editRedInfo(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request){
		Date day=new Date();
		if(modelMap.get("csys").toString().length()!= 1){
		ArrayList<String> wfxw = (ArrayList<String>) modelMap.get("csys_code");
		String csys = "1";
		for(int y=0;y<wfxw.size();y++){
			 csys = csys+","+wfxw.get(y);
		}
		csys = csys.substring(2, csys.length());
		modelMap.put("csys", csys);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		modelMap.put("hphm",modelMap.get("hpqy").toString()+modelMap.get("hphm").toString());
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		Object name = userMap.get("sypi_name");
		String name1 = null==name?"":name.toString();
		Object code = userMap.get("sypi_code");
		String code1 = code!=null?code.toString():"";
		modelMap.put("shry", name1+"("+code1+")");
		modelMap.put("shsj", df.format(day));
		if(modelMap.get("clzt").toString().equals("2")){
			modelMap.put("cxyy", "");
		}
		int status = service.examineRedInfo(modelMap);
		return status;
	}
}
