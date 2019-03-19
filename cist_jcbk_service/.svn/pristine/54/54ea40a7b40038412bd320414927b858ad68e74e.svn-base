package com.cist.carParkPath.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.carParkPath.mapper.CarParkPathMapper;
import com.cist.carParkPath.model.TreeModel;
import com.cist.carParkPath.service.CarParkPathService;
import com.cist.frame.page.PageInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class CarParkPathServiceImpl implements CarParkPathService {
	@Autowired
	private CarParkPathMapper mapper;

	@Override
	public Object queryCarParkPathpageList(HashMap<String, Object> paramMap, PageInfo info) {
		// TODO Auto-generated method stub
		return mapper.queryCarParkPathList(paramMap);
	}

	@Override
	public HashMap<String, Object> initAdministrativeAreasTree() throws JsonProcessingException {
		List<TreeModel> areaList = mapper.queryTopLevelAdministrativeAreas();
		List<TreeModel> parkList = new ArrayList<TreeModel>();
		this.getAdministrativeAreasParkchildrenNode(areaList, parkList, null, 0);
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("areaSignalDevice", areaList);
		return resultMap;
	}

	@Override
	public int getAdministrativeAreasParkchildrenNode(List<TreeModel> areaList, List<TreeModel> parkList,
			TreeModel currentNode, int sizeNum) {
		for (TreeModel area : areaList) {
			// 只有行政区划节点才会有pk
			if (null != area.getPk()) {
				area.setIsArea(true);
				area.setIsPark(false);
				List<TreeModel> parkNodes = mapper.queryNodeByDeptOrArea(null,area.getKey());
				int currentNodeParkNums = parkNodes.size();
				parkList.addAll(parkNodes);
				area.setChildren(parkNodes);
				List<TreeModel> childrenDeptList = mapper.querySubLevelAdministrativeAreas(area.getPk());
				if (childrenDeptList.size() != 0) {
					int childrenDeviceNum = this.getAdministrativeAreasParkchildrenNode(childrenDeptList, parkList, area, currentNodeParkNums);
					if (childrenDeviceNum > 0) {
						if (currentNode != null) {
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<TreeModel>());
							}
							currentNode.getChildren().add(area);
						}
					}
				}else {
					// 该行政区划没有子区划时 sizeNum用于统计父区划下所有子区划停车场总数
					sizeNum += currentNodeParkNums;
					if (currentNodeParkNums > 0) {
						if (currentNode.getChildren() == null) {
							currentNode.setChildren(new ArrayList<TreeModel>());
						}
						currentNode.getChildren().add(area);
					}
				}
			}
		}
		return sizeNum;
	}


}
