package com.cist.dept.service;
import java.util.HashMap;
import java.util.List;

import com.cist.dept.model.Depart_info;
import com.cist.dept.model.Sysdataauthoritytemp;
import com.cist.dept.model.Sysdepttype;
import com.cist.dept.model.Sysmoduleinfo;
public interface DeptService {
	public List<Sysmoduleinfo> querylistpageList(HashMap<String,Object> map); 
	public List<Sysdepttype> sysdepttype();
	public Integer delSysmoduleinfo(HashMap<String,Object> map); 
	public List<Depart_info> depart_infolist(Integer dept_superior);
	public Integer addDepart_info(HashMap<String,Object> map); 
	public Integer selectdept_code(HashMap<String,Object> map); 
	public Integer updateDepart_info(HashMap<String,Object> map); 
	//已选中的部门
	public List<Depart_info> departcho(HashMap<String,Object> map); 
	//添加部门数据权限
	public Integer addbumenquanx(List<HashMap<String,Object>> list); 
	//用户数据权限已选用户部门树
	public List<Depart_info> sDepartinfo(HashMap<String,Object> map); 
	//部门用户
	public List<Depart_info> selectdepuser(HashMap<String,Object> map); 
	//临时部门删除
	public Integer delSysdataauthoritytemp(); 
	//临时部门添加
	public Integer addSysdataauthoritytemp(List<HashMap<String,Object>> list); 
	//获取顶级目录
	public List<Sysdataauthoritytemp> selectleve(); 
	//顶级菜单
	public List<Depart_info> departinfolist(List<String> dept_superior);
	//顶级菜单 pk
	public List<Depart_info> departinfolistpk(List<String> pk);
	//查看上级
	public String shangji(String pk);
	//删除当前用户部门授权信息
	public Integer deldeptauthority(HashMap<String,Object> map); 
}
