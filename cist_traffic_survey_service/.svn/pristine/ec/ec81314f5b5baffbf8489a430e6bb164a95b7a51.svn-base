package com.cist.policemngment.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.policemngment.mapper.PoliceMngmentMapper;
import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.model.Sys_frm_code;
import com.cist.policemngment.service.PoliceMngmentService;

@Service
public class PoliceMngmentServiceImpl implements PoliceMngmentService{

	@Autowired
	private PoliceMngmentMapper mapper;

	@Override
	public Object selectByRespageList(Map<String, Object> map, PageInfo info) {
		return mapper.selectByResourc(map);
	}


	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}


	@Override
	public Integer insetResourc(Map<String, Object> map) {
		return mapper.insetResourc(map);
	}


	@Override
	public Integer updateResourc(Map<String, Object> map) {
		return mapper.updateResourc(map);
	}


	@Override
	public Integer deleteResourc(Map<String, Object> map) {
		return mapper.deleteResourc(map);
	}


	@Override
	public List<SysPoliceInfo> selectPolice() {
		return mapper.selectPolice();
	}


	@Override
	public Integer allotPolice(Map<String, Object> map) {
		return mapper.allotPolice(map);
	}


	@Override
	public Integer insertHave(Map<String, Object> map) {
		return mapper.insertHave(map);
	}


	@Override
	public Integer updatePolicce(Map<String, Object> map) {
		return mapper.updatePolicce(map);
	}


	@Override
	public Integer updateHave(Map<String, Object> map) {
		return mapper.updateHave(map);
	}


	@Override
	public Integer deletePolice(Map<String, Object> map) {
		return mapper.deletePolice(map);
	}


	@Override
	public Integer deleteHave(Map<String, Object> map) {
		return mapper.deleteHave(map);
	}


	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}


	@Override
	public List<SysPoliceInfo> selectCarGPS() {
		return mapper.selectCarGPS();
	}


	@Override
	public List<Jcsj_P_R_Have> selectHave(Map<String, Object> map) {
		return mapper.selectHave(map);
	}


	@Override
	public List<Jcsj_P_R_Allot> selectPoliceCheck(Map<String, Object> map) {
		return mapper.selectPoliceCheck(map);
	}



	
}
