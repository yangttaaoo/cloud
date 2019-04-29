package com.cist.orbit.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cist.frame.page.PageInfo;
import com.cist.orbit.mapper.OrbitMapper;
import com.cist.orbit.model.CRoadSegitemInfo;
import com.cist.orbit.model.C_road_item;
import com.cist.orbit.model.Depart_info;
import com.cist.orbit.model.RoadTree;
import com.cist.orbit.model.Sys_frm_code;
import com.cist.orbit.service.OrbitService;

@Service("OrbitService")
public class OrbitServiceImpl implements OrbitService{


	@Autowired
	private OrbitMapper mapper;
	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}
	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}
	@Override
	public List<C_road_item> selectRoadList(HashMap<String, Object> map) {
		return mapper.selectRoadList(map);
	}
	@Override
	public List<Depart_info> yijicdepartinfo(HashMap<String, Object> map) {
		return mapper.yijicdepartinfo(map);
	}
	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<Depart_info> clickdepartinfo(String dept_superior) {
		return mapper.clickdepartinfo(dept_superior);
	}
	@Override
	public List<Depart_info> kakou(String tbec_kkbh) {
		return mapper.kakou(tbec_kkbh);
	}
	@Override
	public List<Depart_info> kakouxiabu(HashMap<String, Object> map) {
		return mapper.kakouxiabu(map);
	}
	@Override
	public CRoadSegitemInfo selectLukou(HashMap<String, Object> map) {
		return mapper.selectLukou(map);
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
	public List<RoadTree> initAreaRoadTree(HashMap<String, Object> paramMap) {
		List<RoadTree> areas = mapper.queryAdministrativeAreas1(paramMap);
		this.gettAreaRoadChildren(null, areas, paramMap, 0);
		return areas;
	}

}
