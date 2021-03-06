package com.cist.videopatrol.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.patrolplan.model.Tbl_Dev_Info;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CASE;
import com.cist.videopatrol.model.TBL_VIO_CRUISE_CONFIG;

public interface VideoPatrolMapper {
	public List<TBL_VIO_CRUISE_CASE> querycruise(HashMap<String,Object> map);
	public List<TBL_VIO_CRUISE_CONFIG> querycruiseconf(HashMap<String,Object> map);
	public List<Tbl_Dev_Info> querydev(HashMap<String,Object> map);
	public List<TBL_VIO_CRUISE_CONFIG> queryinfo(HashMap<String,Object> map);
}
