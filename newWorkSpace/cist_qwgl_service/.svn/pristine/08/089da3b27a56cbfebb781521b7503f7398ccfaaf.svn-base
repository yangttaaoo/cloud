package com.cist.pdgrzb.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.pdgrzb.model.Depart_info;
import com.cist.pdgrzb.model.DeptInfo;
import com.cist.pdgrzb.model.NumIndex;
import com.cist.pdgrzb.model.Syspoliceinfo;

@Service(value="PersonServiceImpl")
public interface PersonService {

	Object selectAllpageList(Map<String,Object> map,PageInfo p);
	
	Integer insertPerson(Map<String, Object> map);
	
	Integer deletePerson(Map<String, Object> map);
	Integer deletePersons(Map<String, Object> map);
	
	Integer updatePerson(Map<String, Object> map);
	Integer updateZb(Map<String, Object> map);
	Integer deletePersonAll(String[] pk);
	Integer deletePersonAlls(String[] pk);
	/**
	 * 指标分值
	 * @param pk_id
	 * @return
	 */
	List<NumIndex> queryNum(Integer pk_id);
	
	Integer insertZb(Map<String, Object> map);
	
	//上级下级部门s
    List<Depart_info> depart_infolist(Integer dept_superior);
    List<DeptInfo> depart_infolists(Integer dept_superior);
    List<Depart_info> selectPerson(Integer pk_id);
}
