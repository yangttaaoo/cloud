package com.cist.intersection.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cist.intersection.model.CRoadSegitemInfo;
import com.cist.intersection.model.C_road_item;
import com.cist.intersection.model.Depart_info;
import com.cist.intersection.model.TblSegitemSignal;
import com.cist.intersection.model.TblSigcaseSegitem;
import com.cist.intersection.model.TblTimplanPhase;
import com.cist.intersection.model.TblTimplanSegitem;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.CRoadItemInfo;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.model.SysDepartInfo;
import com.cist.roadsection.model.Sys_frm_code;

public interface IntersectionMapper {
	
	//路口基本信息查询
	List<CRoadSegitemInfo> list(HashMap<String,Object> map);
	
	//信控方案查询
	List<TblSegitemSignal> selectSignal(HashMap<String,Object> map);
	
	/**
	 * 道路树
	 * @return
	 */
	List<C_road_item> roadList(HashMap<String,Object> map);
	
	/**
	 * 行政区划树
	 * @return
	 */
	List<CKreisCode> kreis(Map<String, Object> map);
	
	//根据pk删除路段基本信息
	Integer delete(HashMap<String,Object> map);
	
	//根据pk删除信控方案
	Integer deleteXkfa(HashMap<String,Object> map);
	
	//根据pk删除信控方案下的配时信息
	Integer deletePsxx(HashMap<String,Object> map);
	
	//信控方案配时信息查询
	List<TblTimplanSegitem> selectPsxx(HashMap<String,Object> map);
	
	//配时信息更新
	Integer insertPsxx(HashMap<String,Object> map);
	
	//部门对应的道路树
	List<C_road_item> road_infolist(HashMap<String,Object> map);
	
	//保存路口下的信控方案
	Integer insertSignal(Map<String, Object> map);
	
	//更新相位关系信息
	Integer updateXwxx(HashMap<String,Object> map);
	
	//保存路口下的信控方案下对应的配时信息
	Integer insertSegitem(Map<String, Object> map);
	
	//配时信息下的相位关系信息批量新增
	Integer insertXwxx(HashMap<String,Object> map);
	
	//更新协调路口关系信息
	Integer updateXtlk(Map<String,Object> map);
	
	
	//查询相位关系信息
	List<TblTimplanPhase> selectXwxx(Long psfa);
	
	//所属道路名称
	 C_road_item selectRoadName(HashMap<String,Object> map);
	
	//道路下的点位及名称
	List<C_road_item> road_point(String m_road_code);
	/**
	 * 行政区划树
	 * @return
	 */
	List<CKreisCode> kreisList(Integer bigDecimal);
	
	//上级下级部门
    List<Depart_info> depart_infolist(Integer dept_superior);
    
	//部门下的设备
    List<Depart_info> clickdepartinfo(String dept_superior);
    
	//卡口下的设备
	public List<Depart_info> kakou(String tbec_kkbh);
	
	//设备的路段
	public List<Depart_info> yijicdepartinfo(HashMap<String,Object> map);
	
	//设备的路段下的设备
	public List<Depart_info> kakouxiabu(HashMap<String,Object> map);
	
	//部门下道路
    List<C_road_item> selectRoadTree(String dept_superior);
    
	//道路下的路口
	public List<C_road_item> lukou(String roim_code);
	
	//选中的路口
	public List<C_road_item> checkLukou(HashMap<String,Object> map);
	
	//道路下选中的路口
	public List<C_road_item> lukoudm(HashMap<String,Object> map);
	
	//配时信息更新
	Integer insertPsxx(Map<String,Object> map);
    
	//根据部门获取设备信息树
	List<Depart_info> selectRoad(String dept_code);
	
	//根据部门道路获取安装地点
	List<Depart_info> Monitorpoint(String dept_code);
	  /**
	 	 * 基础代码表中的下拉列表
	 	 * @return  List<Sys_frm_code>
	 	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	//保存路口基本信息
	Integer save(Map<String, Object> map);
	
	//保存路口下的信控方案
	Integer saveSignal(Map<String, Object> map);
	
	//保存路口下的信控方案下对应的配时信息TBL_TIMPLAN_SEGITEM
	Integer saveSegitem(HashMap<String,Object> map);
	
	//信控方案下协调路口查询
	List<TblSigcaseSegitem> selectXtlk(HashMap<String,Object> map);

	//更新道路基本信息
	Integer update(Map<String, Object> map);
	
	
	//更新信控方案
	Integer updateSignal(Map<String, Object> map);
	
	//更新信控方案和协调路口关系
	Integer saveXtlk(Map<String, Object> map);
	
	
	//行政区划名称查询
	CKreisCode selectKreis(HashMap<String, Object> map);
	
	//行政区划名称查询
	SysDepartInfo selectDept(HashMap<String, Object> map);
	
	//路肩类型名称
	Sys_frm_code selectLjlx(HashMap<String, Object> map);
	
	//信控设备名称
	TblSegitemSignal selectXksbName(HashMap<String, Object> map);
	
	//协调路口名称查询
	CRoadSegitemInfo selectXtlkName(HashMap<String, Object> map);
	
	//协调路口编辑部门查询
	List<C_road_item> selectXtlkDept(HashMap<String, Object> map);
	
	//删除信控方案下协调路口
	Integer deleteXtlk(Map<String, Object> map);
	
	
	//信控设备编辑部门查询
	C_road_item selectXksbDept(HashMap<String, Object> map);
	//路口代码是否唯一
		Integer getroimcode(HashMap<String, Object> map);
}
