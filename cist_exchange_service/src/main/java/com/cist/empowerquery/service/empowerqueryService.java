package com.cist.empowerquery.service;

import java.util.HashMap;

import com.cist.frame.page.PageInfo;

public interface empowerqueryService {

	//条件分页查询
	Object listpageList(HashMap<String,Object> map,PageInfo pinfo); 
}
