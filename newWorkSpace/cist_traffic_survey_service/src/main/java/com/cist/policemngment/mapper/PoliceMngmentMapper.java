package com.cist.policemngment.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.frame.page.PageInfo;
import com.cist.policemngment.model.Depart_info;
import com.cist.policemngment.model.DeptDeviceTree;
import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.Jcsj_P_R_Relation;
import com.cist.policemngment.model.Jcsj_Police_Res_Person;
import com.cist.policemngment.model.Jcsj_police_resourc;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.model.Sys_frm_code;

public interface PoliceMngmentMapper {

	/**
	 * 分页及条件查询
	 * @param map
	 * @return
	 */
	List<Jcsj_police_resourc> SecurityByfk_dept_idTopk(Map<String, Object> map);
	
	List<Jcsj_police_resourc> selectByResourcs(Map<String, Object> map);
	List<Jcsj_Police_Res_Person> SecurityByglbmTocode(Map<String, Object> map);
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	/**
	 * 删除警务
	 * @param map
	 * @return
	 */
	Integer deletePolice(Map<String, Object> map);
	
	/**
	 * 删除具备功能
	 * @param map
	 * @return
	 */
	Integer deleteHave(Map<String, Object> map);
	
	/**
	 * 新增警务资源管理 
	 * @param map
	 * @return
	 */
	Integer insetResourc(Map<String, Object> map);
	
	/**
	 * 新增警务资源管理 人员
	 * @param map
	 * @return
	 */
	Integer insertPolicePerson(Map<String, Object> map);
	
	Integer updatePolicePerson(Map<String, Object> map);
	
	/**
	 * 分配设备到警员
	 * @param map
	 * @return
	 */
	Integer allotPolice(Map<String, Object> map);
	
	/**
	 * 修改警务资源管理 
	 * @param map
	 * @return
	 */
	Integer updateResourc(Map<String, Object> map);
	/**
	 * 修改警务
	 * @param map
	 * @return
	 */
	Integer updatePolicce(Map<String, Object> map);
	/**
	 * 删除警务资源管理 
	 * @param map
	 * @return
	 */
	Integer deleteResourc(Map<String, Object> map);
	
	/**
	 * 修改警务资源设备具备功能
	 * @param map
	 * @return
	 */
	Integer updateHave(Map<String, Object> map);
	
	/**
	 * 警员查询
	 * @return
	 */
	List<Jcsj_Police_Res_Person> selectPolice(Map<String,Object> map);
	
	/**
	 * 
	 * @return
	 */
	List<Jcsj_P_R_Have> selectHave(Map<String, Object> map);
	/**
	 * 警员默认选中
	 * @param map
	 * @return
	 */
	List<Jcsj_Police_Res_Person> selectPoliceCheck(Map<String, Object> map);
	
	/**
	 * 添加警务资源设备
	 * @param map
	 * @return
	 */
	Integer insertHave(Map<String, Object> map);
	
	
	/**
	 * 车辆类型
	 * @param fct_code
	 * @return
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	/**
	 * 警车、GPS关联信息
	 * @return
	 */
	List<SysPoliceInfo> selectCarGPS();
	
	Integer allotPolicesss(Map<String, Object> map);
	
	List<Depart_info> selectPersons(Integer pk_id);
	
	List<Depart_info> depart_infolists();
	List<Depart_info> depart_infolistss();
	
	Integer deletePersonAll(Map<String,Object> map);
	
	//上级下级部门
	List<Depart_info> deptTree(Integer dept_superior);
	
	//上级下级部门
	List<Depart_info> selectGps(Integer dept_superior);
	
	//gps关联警车
	Integer insertCarToGps(Map<String, Object> map);
	
	//上级下级部门
	List<Depart_info> selectPoliceCar(Integer dept_superior);
	
	//查询当前记录关联警车或者gps
	List<Jcsj_P_R_Relation> selectCheck(HashMap<String, Object> map);
	
	/**
	 * 删除警务
	 * @param map
	 * @return
	 */
	Integer deletePoliceList(Map<String,Object> map);
	
	/**
	 * 删除具备功能
	 * @param map
	 * @return
	 */
	Integer deleteHaveList(Map<String,Object> map);
	
	/**
	 * 删除警车关联的GPS
	 * @param map
	 * @return
	 */
	Integer deleteGps(Map<String, Object> map);
	
	/**
	 * 删除警车关联的GPS
	 * @param map
	 * @return
	 */
	Integer deleteGpsList(Map<String, Object> map);
	
	/**
	 * 删除GPS关联警车信息
	 * @param map
	 * @return
	 */
	Integer deleteCarList(Map<String, Object> map);
	
	/**
	 * 删除民警辅警
	 * @param map
	 * @return
	 */
	Integer deleteMJ(Map<String, Object> map);
	
	//上级下级部门
	List<Depart_info> selectPoliceCarAll(Integer dept_superior);
	
	//上级下级部门
	List<Depart_info> selectGpsAll(Integer dept_superior);
	
	//查询当前记录关联警车或者gps
	List<Jcsj_P_R_Relation> selectDataCheck(HashMap<String, Object> map);
	
	//删除民警和辅警
	Integer deletePerson(Map<String,Object> map);
	
	//查询新增的警员编号是否存在
	List<Jcsj_Police_Res_Person> selectPoliceCode(Map<String,Object> map);
	
	//查询新增的身份证号码是否存在
	List<Jcsj_Police_Res_Person> selectSfzhm(Map<String,Object> map);
	
	//查询新增的设备编号是否唯一
	List<Jcsj_police_resourc> selectDeviceCode(Map<String,Object> map);
	
	//查询分配信息的人员是否唯一
	List<Jcsj_P_R_Allot> selectPoliceByCheck(Map<String,Object> map);
	
	//查询警务通和350M
	List<Jcsj_police_resourc> selectByJWSecurityByfk_dept_idTopk(Map<String, Object> map);
	
	
	//查询GPS关联相关车辆信息
	List<Jcsj_police_resourc> selectByGpsCarSecurityByfk_dept_idTopk(Map<String, Object> map);
	
	//删除GPS下对应的车辆
	Integer deleteCarByGps(Map<String,Object> map);
	
	/**
	 * 根据查询顶级部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public DeptDeviceTree queryTopLevelDept();
	/**
	 * 根据部门Id查询子部门
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> querySubLevelDept(Long deptId);
	
	/**
	 * 根据部门Id查询管理的设备中具有视频功能的设备类型List
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryDeviceType(String deptId);
	
	/**
	 * 根据部门ID、设备类型code查询设备信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<DeptDeviceTree> queryVideoDevice(HashMap<String,Object> paramMap);
	
	//上级下级部门
	List<DeptDeviceTree> selectGps(Long dept_superior);
	
	
	//上级下级部门
	List<DeptDeviceTree> selectPoliceCar(Long dept_superior);
	
	//上级下级部门
	List<DeptDeviceTree> selectPoliceCarNum(Long dept_superior);
	
	//查询基础数据
	List<Sys_frm_code> selectBaseDate(HashMap<String,Object> map);
	
	public List<DeptInfo> querydeptByCode(String dept_code);
	
}