package com.cist.log.logService;

import java.util.Map;

public interface LogService {

	public void insertLoginLog(Map<String,Object> map);
	public void insertOperLog(Map<String,Object> map);
}
