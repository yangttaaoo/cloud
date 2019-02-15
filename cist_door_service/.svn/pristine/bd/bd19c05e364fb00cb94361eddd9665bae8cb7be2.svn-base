package com.cist.role.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.police.model.Sysuserauthority;
import com.cist.police.model.Sysuserdataqx;
import com.cist.role.mapper.RoleMapper;
import com.cist.role.model.Sysroleauthority;
import com.cist.role.model.Sysroledataqx;
import com.cist.role.service.RoleService;
@Service("RoleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper mapper;
	
	@Override
	public Object roleInfopageList(HashMap<String, Object> map, PageInfo pinfo) {
		return mapper.roleInfopageList(map);
	}
	public Integer addSyspoliceinfo(HashMap<String, Object> map) {
		return mapper.addSyspoliceinfo(map);
	}
	public Integer addsysuserauthority(List<HashMap<String,Object>> list) {
		return mapper.addsysuserauthority(list);
	}
	public Integer addbumenquanx(List<HashMap<String, Object>> list) {
		return mapper.addbumenquanx(list);
	}
	public Integer addDept(List<HashMap<String, Object>> list) {
		return mapper.addDept(list);
	}
	public Integer deluserpolise(HashMap<String, Object> map) {
		return mapper.deluserpolise(map);
	}	
	public Integer delusersq(HashMap<String, Object> map) {
		return mapper.delusersq(map);
	}
	public Integer deluserdataqx(HashMap<String, Object> map) {
		return mapper.deluserdataqx(map);
	}
	public Integer deldeptauthority(HashMap<String, Object> map) {
		return mapper.deldeptauthority(map);
	}
	public List<Sysroleauthority> selectSysuserauthority(HashMap<String, Object> map) {
		return mapper.selectSysuserauthority(map);
	}
	public List<Sysroleauthority> selectSysuserauthorityleve(HashMap<String, Object> map) {
		return mapper.selectSysuserauthorityleve(map);
	}
	public List<Sysroleauthority> deptdataauthority(HashMap<String, Object> map) {
		return mapper.deptdataauthority(map);
	}
	public List<Sysroledataqx> sysuserdataqx(HashMap<String, Object> map) {
		return mapper.sysuserdataqx(map);
	}
	public Integer updateSysroleinfo(HashMap<String, Object> map) {
		return mapper.updateSysroleinfo(map);
	}
}
