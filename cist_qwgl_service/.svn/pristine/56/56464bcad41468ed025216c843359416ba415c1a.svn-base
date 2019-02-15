package com.cist.pdgrzb.mapper;

import java.util.List;
import java.util.Map;

import com.cist.pdgrzb.model.Depart_info;
import com.cist.pdgrzb.model.DeptInfo;
import com.cist.pdgrzb.model.NumIndex;
import com.cist.pdgrzb.model.Qw_I_C_Metricr;
import com.cist.pdgrzb.model.Syspoliceinfo;

public interface PersonMapper {

	List<Qw_I_C_Metricr> selectPersonAll(Map<String, Object> map);
	
	Integer insertPerson(Map<String, Object> map);
	Integer updateZb(Map<String, Object> map);
	Integer deletePerson(Map<String, Object> map);
	Integer deletePersons(Map<String, Object> map);
	Integer updatePerson(Map<String, Object> map);
	Integer deletePersonAll(String[] pk);
	Integer deletePersonAlls(String[] pk);
	Integer insertZb(Map<String, Object> map);
	
	/**
	 * 指标分值
	 * @param pk_id
	 * @return
	 */
	List<NumIndex> queryNum(Integer pk_id);
	
	//上级下级部门
    List<Depart_info> depart_infolist(Integer dept_superior);
    List<DeptInfo> depart_infolists(Integer dept_superior);
    List<Depart_info> selectPerson(Integer pk_id);
}
