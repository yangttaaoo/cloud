package com.cist.police.service;
import java.util.HashMap;
import java.util.List;
import com.cist.police.model.Syspoliceinfo;
import com.cist.police.model.Syspolicestatus;
import com.cist.police.model.Syspolicetype;
import com.cist.police.model.Syspost;
import com.cist.police.model.Sysuserauthority;
import com.cist.police.model.Sysuserdataqx;
import com.cist.role.model.RoleInfo;


public interface PoliceService {

	public List<Syspoliceinfo> selectSyspoliceinfo(HashMap<String,Object> map); 
	public List<Syspolicetype> selectSyspolicetype(); 
	public List<Syspost> selectSyspost(); 
	public List<Syspolicestatus> selectSyspolicestatus(); 
	//添加用户
	public Integer addSyspoliceinfo(HashMap<String,Object> map); 
	//更新用户
	public Integer updateSyspoliceinfo(HashMap<String,Object> map); 
	public Integer addsysuserauthority(List<HashMap<String,Object>> list); 
	public List<Syspoliceinfo> sSyspoliceinfo(HashMap<String,Object> map); 
	public Integer addbumenquanx(List<HashMap<String,Object>> list); 
	//查询用户授权 选中的权限
	public List<Sysuserauthority> selectSysuserauthority(HashMap<String,Object> map); 
	//查询用户授权  选中的上级菜单
	public List<Sysuserauthority> selectSysuserauthorityleve(HashMap<String,Object> map); 
	//部门数据权限
	public List<Sysuserauthority> deptdataauthority(HashMap<String,Object> map); 
	//查询是否有子节点
	public Integer zijiedian(HashMap<String,Object> map); 
	//用户数据权限
	public List<Sysuserdataqx> sysuserdataqx(HashMap<String,Object> map);
	//删除当前用户授权信息
	public Integer delusersq(HashMap<String,Object> map);
	//删除当前用户数据权限
	public Integer deluserdataqx(HashMap<String,Object> map);
	//修改用户密码
	public Integer updatwpwd(HashMap<String,Object> map);
	//删除用户
	public Integer deluserpolise(HashMap<String,Object> map);
	//查询角色信息
	public List<RoleInfo> selectRole();
}
