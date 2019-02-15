package com.cist.role.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.police.model.Sysuserdataqx;
import com.cist.role.model.Sysroleauthority;
import com.cist.role.model.Sysroledataqx;

public interface RoleService {
	Object roleInfopageList(HashMap<String,Object> map,PageInfo pinfo); 
	//添加角色
	public Integer addSyspoliceinfo(HashMap<String,Object> map); 
	public Integer addsysuserauthority(List<HashMap<String,Object>> list); 
	public Integer addbumenquanx(List<HashMap<String,Object>> list); 
	public Integer addDept(List<HashMap<String,Object>> list); 
	//删除角色
	public Integer deluserpolise(HashMap<String,Object> map);
	public Integer delusersq(HashMap<String,Object> map);
	public Integer deluserdataqx(HashMap<String,Object> map);
	public Integer deldeptauthority(HashMap<String,Object> map);
	//查询角色授权 选中的权限
	public List<Sysroleauthority> selectSysuserauthority(HashMap<String,Object> map);
	//查询角色授权  选中的上级菜单
	public List<Sysroleauthority> selectSysuserauthorityleve(HashMap<String,Object> map);
	//部门数据权限
	public List<Sysroleauthority> deptdataauthority(HashMap<String,Object> map); 
	//用户数据权限
	public List<Sysroledataqx> sysuserdataqx(HashMap<String,Object> map);
	//更新用户
	public Integer updateSysroleinfo(HashMap<String,Object> map);
}
