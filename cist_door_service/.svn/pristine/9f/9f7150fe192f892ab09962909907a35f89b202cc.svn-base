package com.cist.police.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.police.mapper.PoliceMapper;
import com.cist.police.model.Syspoliceinfo;
import com.cist.police.model.Syspolicestatus;
import com.cist.police.model.Syspolicetype;
import com.cist.police.model.Syspost;
import com.cist.police.model.Sysuserauthority;
import com.cist.police.model.Sysuserdataqx;
import com.cist.police.service.PoliceService;
import com.cist.role.model.RoleInfo;
@Service
public class PoliceServiceImpl implements PoliceService  {
	@Autowired
	private PoliceMapper mapper;
	public List<Syspoliceinfo> selectSyspoliceinfo(HashMap<String,Object> map) {
		return mapper.selectSyspoliceinfo(map);
	}
	public List<Syspolicetype> selectSyspolicetype() {
		return mapper.selectSyspolicetype();
	}
	public List<Syspost> selectSyspost() {
		return mapper.selectSyspost();
	}
	public List<Syspolicestatus> selectSyspolicestatus() {
		return mapper.selectSyspolicestatus();
	}
	public Integer addSyspoliceinfo(HashMap<String, Object> map) {
		return mapper.addSyspoliceinfo(map);
	}
	public Integer addsysuserauthority(List<HashMap<String,Object>> list) {
		return mapper.addsysuserauthority(list);
	}
	public List<Syspoliceinfo> sSyspoliceinfo(HashMap<String, Object> map) {
		return mapper.sSyspoliceinfo(map);
	}
	public Integer addbumenquanx(List<HashMap<String, Object>> list) {
		return mapper.addbumenquanx(list);
	}
	public List<Sysuserauthority> selectSysuserauthority(HashMap<String, Object> map) {
		return mapper.selectSysuserauthority(map);
	}
	public List<Sysuserauthority> selectSysuserauthorityleve(HashMap<String, Object> map) {
		return mapper.selectSysuserauthorityleve(map);
	}
	public List<Sysuserauthority> deptdataauthority(HashMap<String, Object> map) {
		return mapper.deptdataauthority(map);
	}
	public Integer zijiedian(HashMap<String, Object> map) {
		return mapper.zijiedian(map);
	}
	public List<Sysuserdataqx> sysuserdataqx(HashMap<String, Object> map) {
		return mapper.sysuserdataqx(map);
	}
	public Integer updateSyspoliceinfo(HashMap<String, Object> map) {
		return mapper.updateSyspoliceinfo(map);
	}
	public Integer delusersq(HashMap<String, Object> map) {
		return mapper.delusersq(map);
	}
	public Integer deluserdataqx(HashMap<String, Object> map) {
		return mapper.deluserdataqx(map);
	}
	public Integer updatwpwd(HashMap<String, Object> map) {
		return mapper.updatwpwd(map);
	}
	public Integer deluserpolise(HashMap<String, Object> map) {
		return mapper.deluserpolise(map);
	}
	public List<RoleInfo> selectRole() {
		return mapper.selectRole();
	}	
}
