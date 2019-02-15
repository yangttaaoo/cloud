package com.cist.xjzx.gzcx.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.xjzx.gzcx.model.JTYW_JOB_ORDER;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_COMPANY;
import com.cist.xjzx.gzcx.model.JTYW_MAINTENANCE_GROUP;
import com.cist.xjzx.gzcx.model.VW_SBGZ_INFO;

public interface GzcxMapper {
	public List<VW_SBGZ_INFO> querygz(HashMap<String,Object> map);
	public Integer addgd(HashMap<String,Object> map);
	public Integer addgdgl(HashMap<String,Object> map);
	public Integer del(HashMap<String,Object> map);
	public Integer addgdlc(HashMap<String,Object> map);
	public List<JTYW_JOB_ORDER> querygd(HashMap<String,Object> map);
	public Integer updategd(HashMap<String,Object> map);
//	public Integer updategdlc(HashMap<String,Object> map);
	public List<JTYW_MAINTENANCE_COMPANY> querycompany(HashMap<String,Object> map);
	public List<JTYW_MAINTENANCE_GROUP> querygroup(HashMap<String,Object> map);
}
