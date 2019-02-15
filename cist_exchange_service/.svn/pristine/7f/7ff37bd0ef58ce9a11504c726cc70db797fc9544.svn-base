package com.cist.visitinterface.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.visitinterface.mapper.VisitInterfaceMapper;
import com.cist.visitinterface.model.DeptInfo;
import com.cist.visitinterface.model.SJGX_INTERFACE_TYPE;
import com.cist.visitinterface.model.SYS_depart_info;
import com.cist.visitinterface.model.SjgxDevCompany;
import com.cist.visitinterface.service.VisitInterfaceService;
@Service
public class VisitInterfaceServiceImpl implements VisitInterfaceService {
	@Autowired
	private VisitInterfaceMapper mapper;
	@Override
	public Object queryinterfacepageList(HashMap<String, Object> map,PageInfo info) {
		return mapper.queryinterface(map);
	}
	@Override
	public List<SJGX_INTERFACE_TYPE> queryinterfacetype(HashMap<String, Object> map) {
		return mapper.queryinterfacetype(map);
	}
	@Override
	public List<SjgxDevCompany> querydev(HashMap<String, Object> map) {
		return mapper.querydev(map);
	}
	@Override
	public List<SYS_depart_info> querydept(SYS_depart_info dept) {
		return mapper.querydept(dept);
	}
	@Override
	public Integer addsjgx(HashMap<String, Object> map) {
		return mapper.addsjgx(map);
	}
	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public Integer queryid() {
		return mapper.queryid();
	}
	@Override
	public Integer delinterface(HashMap<String, Object> map) {
		return mapper.delinterface(map);
	}
	@Override
	public Integer updateinterface(HashMap<String, Object> map) {
		return mapper.updateinterface(map);
	}

}
