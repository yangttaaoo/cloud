package com.cist.dept.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.dept.mapper.DeptMapper;
import com.cist.dept.model.Depart_info;
import com.cist.dept.model.Sysdataauthoritytemp;
import com.cist.dept.model.Sysdepttype;
import com.cist.dept.model.Sysmoduleinfo;
import com.cist.dept.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService  {
	@Autowired
	private DeptMapper mapper;
	public List<Sysmoduleinfo> querylistpageList(HashMap<String, Object> map) {
		return mapper.querylistpageList(map);
	}
	public List<Sysdepttype> sysdepttype() {
		return mapper.sysdepttype();
	}
	public Integer delSysmoduleinfo(HashMap<String, Object> map) {
		return mapper.delSysmoduleinfo(map);
	}
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	public Integer addDepart_info(HashMap<String, Object> map) {
		return mapper.addDepart_info(map);
	}
	public Integer selectdept_code(HashMap<String, Object> map) {
		return mapper.selectdept_code(map);
	}
	public Integer updateDepart_info(HashMap<String, Object> map) {
		return mapper.updateDepart_info(map);
	}
	public List<Depart_info> departcho(HashMap<String, Object> map) {
		return mapper.departcho(map);
	}
	public Integer addbumenquanx(List<HashMap<String,Object>> list) {
		return mapper.addbumenquanx(list);
	}
	public List<Depart_info> sDepartinfo(HashMap<String,Object> map) {
		return mapper.sDepartinfo(map);
	}
	public List<Depart_info> selectdepuser(HashMap<String, Object> map) {
		return mapper.selectdepuser(map);
	}
	public Integer delSysdataauthoritytemp() {
		return mapper.delSysdataauthoritytemp();
	}
	public Integer addSysdataauthoritytemp(List<HashMap<String, Object>> list) {
		return mapper.addSysdataauthoritytemp(list);
	}
	public List<Sysdataauthoritytemp> selectleve() {
		return mapper.selectleve();
	}
	public List<Depart_info> departinfolist(List<String> dept_superior) {
		return mapper.departinfolist(dept_superior);
	}
	public String shangji(String pk) {
		return mapper.shangji(pk);
	}
	public List<Depart_info> departinfolistpk(List<String> pk) {
		return mapper.departinfolistpk(pk);
	}
	public Integer deldeptauthority(HashMap<String, Object> map) {
		return mapper.deldeptauthority(map);
	}
	
}
