package com.cist.redrevoke.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.redlist.model.RedListInfo;

public interface RedRevokeMapper {
	List<RedListInfo> redRevokepageList(HashMap<String,Object> map); 
	RedListInfo OneRedInfo(HashMap<String,Object> map);
	int revokeRedInfo(HashMap<String,Object> map);
}
