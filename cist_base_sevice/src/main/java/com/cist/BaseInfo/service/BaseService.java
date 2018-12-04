package com.cist.BaseInfo.service;

import java.util.List;
import java.util.Map;

import com.cist.BaseInfo.model.BaseDataInfo;

public interface BaseService {
	public List<BaseDataInfo> queryBaseList(); 
	public void updatePassword(Map<String,Object> map);
}
