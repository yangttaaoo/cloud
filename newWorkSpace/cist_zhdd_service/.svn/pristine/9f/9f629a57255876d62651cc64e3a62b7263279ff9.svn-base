package com.cist.specialTask.service;

import java.util.HashMap;
import java.util.List;
import com.cist.frame.page.PageInfo;
import com.cist.specialTask.model.CRoadItemInfo;
import com.cist.specialTask.model.JcsjDeviceInfo;
import com.cist.specialTask.model.JcsjPoliceResPerson;
import com.cist.specialTask.model.JcsjPoliceResources;
import com.cist.specialTask.model.ZhddMissionGrade;
import com.cist.specialTask.model.ZhddMissionParticipant;
import com.cist.specialTask.model.ZhddMissionRoute;

public interface SpecialTaskService {

	// 重点区域首页信息查询
	Object listpageList(HashMap<String, Object> map, PageInfo p);

	// 删除重点区域
	Integer delete(HashMap<String, Object> map);

	// 保存重点区域
	Integer save(HashMap<String, Object> map);

	// 保存重点区域
	Integer update(HashMap<String, Object> map);

	/**
	 * 特勤等级列表
	 * 
	 * @param map
	 * @return
	 */
	List<ZhddMissionGrade> selectGrade(HashMap<String, Object> map);
	
	/**
	 * 警务资源警车查询
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjPoliceResources> selectPoliceCar(HashMap<String, Object> map);
	
	/**
	 * 警员信息查询
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjPoliceResPerson> selectPolice(HashMap<String, Object> map);
	
	/**
	 * 删除特勤任务路线
	 * 
	 * @param map
	 * @return
	 */
	Integer deleteRoute(HashMap<String, Object> map);
	
	/**
	 * 删除特勤任务参与者
	 * 
	 * @param map
	 * @return
	 */
	Integer deleteParticipant(HashMap<String, Object> map);
	
	/**
	 * 查询任务参与者
	 * 
	 * @param map
	 * @return
	 */
	List<ZhddMissionParticipant> selectParticipant(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务路线
	 * 
	 * @param map
	 * @return
	 */
	List<ZhddMissionRoute> selectRoute(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务路线道路
	 * 
	 * @param map
	 * @return
	 */
	List<CRoadItemInfo> selectRoad(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务路线道路关联设备
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjDeviceInfo> selectDevice(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务相关人员信息
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjPoliceResPerson> selecteParPolice(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务相关车信息
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjPoliceResources> selecteParCar(HashMap<String, Object> map);
	
	/**
	 * 查询特勤任务相关设备信息
	 * 
	 * @param map
	 * @return
	 */
	List<JcsjDeviceInfo> selecteParDevice(HashMap<String, Object> map);
	
	

}
