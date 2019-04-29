package com.cist.keyarea.service;

import java.util.HashMap;
import com.cist.frame.page.PageInfo;

public interface KeyAreaService {

	//重点区域首页信息查询
	Object listpageList(HashMap<String,Object> map,PageInfo p);
	
	//删除重点区域
	Integer delete(HashMap<String,Object> map);
	
	//保存重点区域
	Integer save(HashMap<String,Object> map);
	
	//保存重点区域
	Integer update(HashMap<String,Object> map);
}
