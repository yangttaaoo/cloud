package com.cist.qwgl.bcgl.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.qwgl.bcgl.model.DeptInfo;
import com.cist.qwgl.bcgl.model.Qw_type;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;

public interface BcglMapper {
	public List<Qwgl_bc_info> querybc(HashMap<String,Object> map);
	public List<Qw_type> queryqwlx(HashMap<String,Object> map);
	public List<DeptInfo> depart_infolist(Map<String,Object> map);
	public Integer querymaxpk();
	public Integer addbcinfo(HashMap<String,Object> map);
	public Integer updatebcinfo(HashMap<String,Object> map);
	public Integer deletebcinfo(HashMap<String,Object> map);
	public String querydept(String dept_pk);
}
