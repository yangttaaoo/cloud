package com.cist.carParkPath.service;

import java.util.HashMap;
import java.util.List;

import com.cist.carParkPath.model.TreeModel;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CarParkPathService {

	/**
	 * 分页查询车辆停车轨迹记录
	 * 
	 * @param paramMap
	 * @param info
	 * @return
	 */
	public Object queryCarParkPathpageList(HashMap<String, Object> paramMap, PageInfo info);

	/**
	 * 查询行政区域停车场Tree
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public HashMap<String, Object> initAdministrativeAreasTree() throws JsonProcessingException;

	/**
	 * 初始化行政区划停车场Tree子节点
	 * 
	 * @return
	 */
	public int getAdministrativeAreasParkchildrenNode(List<TreeModel> areaList, List<TreeModel> parkList,
			TreeModel parentArea, int sizeNum);
}
