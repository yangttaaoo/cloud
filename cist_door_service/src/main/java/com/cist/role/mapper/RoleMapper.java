package com.cist.role.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.police.model.Sysuserdataqx;
import com.cist.role.model.RoleInfo;
import com.cist.role.model.Sysroleauthority;
import com.cist.role.model.Sysroledataqx;


public interface RoleMapper {
	List<RoleInfo> roleInfopageList(HashMap<String,Object> map);
	public Integer addSyspoliceinfo(HashMap<String,Object> map); 
	public Integer addsysuserauthority(List<HashMap<String,Object>> list); 
	public Integer addbumenquanx(List<HashMap<String,Object>> list); 
	public Integer addDept(List<HashMap<String,Object>> list); 
	public Integer deluserpolise(HashMap<String,Object> map);
	public Integer delusersq(HashMap<String,Object> map);
	public Integer deluserdataqx(HashMap<String,Object> map);
	public Integer deldeptauthority(HashMap<String,Object> map); 
	public List<Sysroleauthority> selectSysuserauthority(HashMap<String,Object> map);
	public List<Sysroleauthority> selectSysuserauthorityleve(HashMap<String,Object> map); 
	public List<Sysroleauthority> deptdataauthority(HashMap<String,Object> map); 
	public List<Sysroledataqx> sysuserdataqx(HashMap<String,Object> map);
	public Integer updateSysroleinfo(HashMap<String,Object> map);
}
