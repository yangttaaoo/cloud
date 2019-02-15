package com.cist.interfacecheck.service;

import java.util.HashMap;

import com.cist.frame.page.PageInfo;

public interface InterCheckService {

	// 审核通过
	Integer pass(HashMap<String, Object> map);

	// 审核不通过
	Integer notPass(HashMap<String, Object> map);
	
	//条件分页查询
	Object listpageList(HashMap<String,Object> map,PageInfo pinfo); 
}
