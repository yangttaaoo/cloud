package com.cist.devmanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cist.devmanagement.mapper.DevManagementMapper;
import com.cist.devmanagement.model.CKreisCode;
import com.cist.devmanagement.model.DeptInfo;
import com.cist.devmanagement.model.RoadTree;
import com.cist.devmanagement.model.SssbEquipmentRegister;
import com.cist.devmanagement.model.Sys_frm_code;
import com.cist.devmanagement.service.DevManagementService;
import com.cist.frame.page.PageInfo;

@Service(value = "DevManagementService")
public class DevManagementServiceImpl implements DevManagementService {

	@Autowired
	private DevManagementMapper mapper;

	@Override
	public List<DeptInfo> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer addRegister(HashMap<String, Object> map) {
		Integer addRegister = mapper.addRegister(map);
		mapper.addGather(map);
		return addRegister;
	}

	@Override
	public Integer addGather(HashMap<String, Object> map) {
		return mapper.addGather(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer deleteRegister(HashMap<String, Object> map) {
		Integer deleteRegister = mapper.deleteRegister(map);
		mapper.deleteGather(map);
		return deleteRegister;
	}

	@Override
	public Integer deleteGather(HashMap<String, Object> map) {
		return mapper.deleteGather(map);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateRegister(HashMap<String, Object> map) {
		Integer updateRegister = mapper.updateRegister(map);
		return updateRegister;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer updateGather(HashMap<String, Object> map) {
		Integer updateRegister = mapper.updateRegister(map);
		mapper.updateGather(map);
		return updateRegister;
	}

	@Override
	public Object selectDevpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.selectDev(map);
	}

	@Override
	public Integer examineRegister(HashMap<String, Object> map) {
		return mapper.examineRegister(map);
	}

	@Override
	public Integer batchAdd(List<SssbEquipmentRegister> list) {
		return mapper.batchAdd(list);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public Integer batchAddRegister(HashMap<String, Object> map) {
		Integer batchAddRegister = 0;
		if(map!=null&& null !=map.get("list")) {
			List<HashMap<String,Object>> list=(List<HashMap<String,Object>>)map.get("list");
			for (HashMap<String, Object> map2 : list) {
				batchAddRegister = mapper.batchAddRegister(map2);
				mapper.batchAddGather(map2);
			}
		}
		return batchAddRegister;
	}

	@Override
	public Integer batchAddGather(HashMap<String, Object> map) {
		return mapper.batchAddGather(map);
	}

	@Override
	public List<DeptInfo> selectDeptId(HashMap<String, Object> map) {
		return mapper.selectDeptId(map);
	}
	
	@Override
	public List<RoadTree> initAreaRoadTree(HashMap<String, Object> paramMap) {
		List<RoadTree> areas = mapper.queryAdministrativeAreas1(paramMap);
		this.gettAreaRoadChildren(null, areas, paramMap, 0);
		return areas;
	}
	
	@Override
	public int gettAreaRoadChildren(RoadTree currentNode, List<RoadTree> childrenList, HashMap<String, Object> paramMap,
			int currentNodeChildNums) {
		for (RoadTree area : childrenList) {
			if (null != area.getPk()) {
				if (currentNode == null)
					area.setExpanded(true);
				area.setIsArea(true);
				area.setIsLeaf(false);
				paramMap.put("tbek_code", null);
				paramMap.put("parent_pk", area.getPk());
				List<RoadTree> childrenNodes = mapper.queryAdministrativeAreas1(paramMap);
				if (null == area.getChildren())
					area.setChildren(new ArrayList<RoadTree>());
				int currentNodeLoukouSize = this.initRoadSegiteTree(paramMap, area);
				if (childrenNodes.size() != 0) {
					int childrenDeviceNum = this.gettAreaRoadChildren(area, childrenNodes, paramMap, 0);
					if (childrenDeviceNum > 0) {
						if (currentNode != null) {
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<RoadTree>());
							}
							currentNode.getChildren().add(area);
						}
					}
				} else {
					area.setIsLeaf(false);
					currentNodeChildNums += currentNodeLoukouSize;
					if (currentNodeLoukouSize > 0) {
						if (currentNode != null) {
							if (currentNode != null && currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<RoadTree>());
							}
							currentNode.getChildren().add(area);
						}
					}
				}
			}
		}
		return 0;
	}
	
	@Override
	public int initRoadSegiteTree(HashMap<String, Object> paramMap, RoadTree currentArea) {
		int roadSegiteSize = 0;
		paramMap.put("tbek_code", currentArea.getKey());
		List<RoadTree> allRoad = mapper.queryAllRoad(paramMap);
		// currentArea.getChildren().addAll(allRoad);
		for (RoadTree road : allRoad) {
			road.setIsLeaf(false);
			road.setIsRoad(true);
			paramMap.put("code", road.getKey());
			road.setChildren(mapper.queryRoadSegiteByRoadCode(paramMap));
			int tempSize = road.getChildren().size();
			roadSegiteSize += tempSize;
			if (tempSize > 0) {

				currentArea.getChildren().add(road);
			}

		}

		return roadSegiteSize;
	}

	@Override
	public List<CKreisCode> kreis(Map<String, Object> map) {
		return mapper.kreis(map);
	}

	@Override
	public List<CKreisCode> kreisList(Integer bigDecimal) {
		return mapper.kreisList(bigDecimal);
	}
}
