package com.cist.deptpublish.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.qwkhgrfb.model.Publish;

public interface DeptPulishService {
	
	Object selectDeptPubpageList(HashMap<String, Object> map,PageInfo pInfo);
	
	List<Publish> downloadList(HashMap<String, Object> map);
}
