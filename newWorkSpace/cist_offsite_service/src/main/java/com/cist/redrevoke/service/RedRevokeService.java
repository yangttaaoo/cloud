package com.cist.redrevoke.service;

import java.util.HashMap;

import com.cist.frame.page.PageInfo;
import com.cist.redlist.model.RedListInfo;

public interface RedRevokeService {
	
	Object redRevokepageList(HashMap<String,Object> map,PageInfo pinfo); 
	RedListInfo OneRedInfo(HashMap<String,Object> map);
	int revokeRedInfo(HashMap<String,Object> map);
}
