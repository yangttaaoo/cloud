package com.cist.carParkPath.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cist.carParkPath.model.TreeModel;
import com.cist.carParkPath.model.JCBK_CAR_STOP_RECO;

public interface CarParkPathMapper {
	/**
	 * 查询车辆停车轨迹记录
	 * @param paramMap
	 * @return
	 */
	public List<JCBK_CAR_STOP_RECO> queryCarParkPathList(HashMap<String, Object> paramMap);
	/**
	 * 根据查询顶级行政区划
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TreeModel> queryTopLevelAdministrativeAreas();
	/**
	 * 根据行政区划Id查询子行政区划
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<TreeModel> querySubLevelAdministrativeAreas(Long AdministrativeAreasId);
	/**
	 * 根据部门code或者区划code查询隶属于该部门或者该行政区划的(非自身属性的 ,意指业务逻辑中需要嵌套的)子节点
	 * @param deptId  管理部门Code
	 * @param areaId  行政区划Code
	 * @return
	 */
	public List<TreeModel> queryNodeByDeptOrArea(@Param("deptId")String deptId,@Param("areaId")String areaId);
}
