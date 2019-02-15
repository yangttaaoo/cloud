package com.cist.deptpublish.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.qwkhgrfb.model.Publish;
import com.cist.qwkhgrfb.model.Qw_Check_Pub;

public interface DeptPulishMapper {
	List<Qw_Check_Pub> selectDeptPub(HashMap<String, Object> map);
	
	List<Publish> downloadList(HashMap<String, Object> map);
}
