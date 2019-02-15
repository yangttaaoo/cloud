package com.cist.visitinterface.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.visitinterface.model.DeptInfo;
import com.cist.visitinterface.model.SJGX_INTERFACE_TYPE;
import com.cist.visitinterface.model.SYS_depart_info;
import com.cist.visitinterface.model.SjgxDevCompany;
import com.cist.visitinterface.model.SjgxInterface;


public interface VisitInterfaceMapper {
	public List<SjgxInterface> queryinterface(HashMap<String,Object> map);
	public List<SJGX_INTERFACE_TYPE> queryinterfacetype(HashMap<String,Object> map);
	public List<SjgxDevCompany> querydev(HashMap<String,Object> map);
	public List<SYS_depart_info> querydept(SYS_depart_info dept);
	public Integer addsjgx(HashMap<String,Object> map);
	List<DeptInfo> depart_infolist(Integer dept_superior);
	public Integer queryid();
	public Integer delinterface(HashMap<String,Object> map);
	public Integer updateinterface(HashMap<String,Object> map);
}
