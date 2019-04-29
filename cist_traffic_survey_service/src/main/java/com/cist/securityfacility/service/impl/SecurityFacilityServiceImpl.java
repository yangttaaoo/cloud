package com.cist.securityfacility.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.securityfacility.mapper.SecurityFacilityMapper;
import com.cist.securityfacility.model.Jcsj_sps_facilities;
import com.cist.securityfacility.model.Sys_frm_code;
import com.cist.securityfacility.service.SecurityFacilityService;
@Service
public class SecurityFacilityServiceImpl implements SecurityFacilityService{
	@Autowired
	private SecurityFacilityMapper mapper;

	@Override
	public List<Jcsj_sps_facilities> querySecurityFacility(HashMap<String, Object> map) {
		return mapper.SecurityByglbmTocode(map);
	}
	
	@Override
	public Object querySecurityFacilitypageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.SecurityByglbmTocode(map);
	}
	
	@Override
	public Integer insertSecurityFacility(Map<String, Object> map) {
		return mapper.insertSecurityFacility(map);
	}

	@Override
	public Integer updateSecurityFacility(Map<String, Object> map) {
		return mapper.updateSecurityFacility(map);
	}

	@Override
	public Integer delSecurityFacility(HashMap<String, Object> map) {
		return mapper.delSecurityFacility(map);
	}

	@Override
	public List<Sys_frm_code> querySys_frm_code(HashMap<String, Object> map) {
		return mapper.querySys_frm_code(map);
	}


	
}
