package com.cist.interceptRegion.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.interceptRegion.mapper.InterceptRegionMapper;
import com.cist.interceptRegion.model.FenceArea;
import com.cist.interceptRegion.model.TempModel;
import com.cist.interceptRegion.service.InterceptRegionService;

@Service
public class InterceptRegionServiceImpl implements InterceptRegionService {
	@Autowired
	private InterceptRegionMapper mapper;

	@Override
	public List<FenceArea> initDeptAreaTree() {
		List<FenceArea> topDept = mapper.queryTopLevelDept();
		List<FenceArea> currentAreas = new ArrayList<FenceArea>();
		this.getDeptAreaChildrenTreeNode(topDept, currentAreas, null, 0, new HashMap<String, Object>());
		for (FenceArea patrolArea : topDept) {
			patrolArea.setExpanded(true);
		}
		return topDept;
	}
	@Override
	public HashMap<String, Object> initDeptInterceptRegionTree() {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<FenceArea> topDept = mapper.queryTopLevelDept();
		List<FenceArea> currentAreas = new ArrayList<FenceArea>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("interceptRegion", "interceptRegion");
		this.getDeptAreaChildrenTreeNode(topDept, currentAreas, null, 0, hashMap);
		for (FenceArea patrolArea : topDept) {
			patrolArea.setExpanded(true);
		}
		resultMap.put("deptInterceptRegionTree", topDept);
		resultMap.put("interceptRegionList", currentAreas);
		return resultMap;
	}
	@Override
	public List<FenceArea> initDeptAreaTreeAll() {
		List<FenceArea> topDept = mapper.queryTopLevelDept();
		this.getChildrenTreeNode(topDept);
		for (FenceArea patrolArea : topDept) {
			patrolArea.setExpanded(true);
		}
		return topDept;
	}

	@Override
	public List<FenceArea> deptAreaCount(List<FenceArea> deptAreaTree) {
		Iterator<FenceArea> iterator = deptAreaTree.iterator();
		while (iterator.hasNext()) {
			FenceArea next = iterator.next();
			if (next.getIsDept()) {
				List<FenceArea> children = next.getChildren();
				if (null != children)
					this.deptAreaCount(children);

			} else {
				iterator.remove();
			}
		}
		return deptAreaTree;

	}

	@Override
	public void getChildrenTreeNode(List<FenceArea> areaList) {
		for (FenceArea parentDept : areaList) {
			if (null != parentDept.getPk()) {
				parentDept.setIsDept(true);
				List<FenceArea> childrenDept = mapper.querySubLevelDept(parentDept.getPk());
				parentDept.setChildren(childrenDept);

				this.initAreaTree(parentDept);

				if (childrenDept.size() != 0) {
					this.getChildrenTreeNode(childrenDept);
				}
			}
			// if(initAreaTree.size() !=0) {
			// parentDept.getChildren().addAll(initAreaTree);
			// }
			//

		}

	}

	@Override
	public int getChildrenArea(List<FenceArea> currentNodeChildrens, int currentNodeAreaNum) {
		for (FenceArea currentNodeChildrenNode : currentNodeChildrens) {
			HashMap<String, Object> childrenMap = new HashMap<String, Object>();
			childrenMap.put("deptId", currentNodeChildrenNode.getFk_dept_id());
			childrenMap.put("areaId", currentNodeChildrenNode.getPk_id());
			List<FenceArea> currentNodeChildrenNodeChildrens = mapper.querySubLevelArea(childrenMap);
			int childrenSize = currentNodeChildrenNodeChildrens.size();
			currentNodeAreaNum += childrenSize;
			currentNodeChildrenNode.setChildren(currentNodeChildrenNodeChildrens);
			if (childrenSize != 0) {
				int childrenArea = this.getChildrenArea(currentNodeChildrenNodeChildrens, 0);
				currentNodeAreaNum += childrenArea;
			}

		}
		return currentNodeAreaNum;

	}

	@Override
	public void getChildrenArea(List<FenceArea> areaList) {
		for (FenceArea area : areaList) {
			HashMap<String, Object> childrenMap = new HashMap<String, Object>();
			childrenMap.put("deptId", area.getFk_dept_id());
			childrenMap.put("areaId", area.getPk_id());
			List<FenceArea> childrenArea = mapper.querySubLevelArea(childrenMap);
			area.setChildren(childrenArea);
			if (childrenArea.size() != 0) {
				this.getChildrenArea(childrenArea);
			}

		}

	}

	@Override
	public List<FenceArea> initAreaTree(FenceArea parentDept) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptId", parentDept.getKey());
		List<FenceArea> areas = mapper.queryInterceptRegionByDept(paramMap);
		parentDept.getChildren().addAll(areas);
		return areas;
	}

	@Override
	public int initAreaTree(FenceArea currentNode, int currentNodeAreaNum) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptId", currentNode.getKey());
		List<FenceArea> currentNodeChildrens = mapper.queryTopLevelArea(paramMap);
		int childrenSize = currentNodeChildrens.size();
		currentNodeAreaNum += childrenSize;
		if (childrenSize != 0) {
			if (currentNode.getChildren() == null) {
				currentNode.setChildren(currentNodeChildrens);
			} else {
				currentNode.getChildren().addAll(currentNodeChildrens);
			}

		}
		int currentNodeAreaNums = this.getChildrenArea(currentNodeChildrens, currentNodeAreaNum);
		return currentNodeAreaNums;
	}

	@Override
	public List<FenceArea> initDeptTree() {
		List<FenceArea> topDept = mapper.queryTopLevelDept();
		this.getChildrenDept(topDept);
		return topDept;
	}

	@Override
	public void getChildrenDept(List<FenceArea> deptList) {
		for (FenceArea parentDept : deptList) {
			List<FenceArea> childrenDept = mapper.querySubLevelDept(parentDept.getPk());
			parentDept.setChildren(childrenDept);
			if (childrenDept.size() != 0) {
				this.getChildrenDept(childrenDept);
			}
		}
	}

	@Override
	public int getDeptAreaChildrenTreeNode(List<FenceArea> currentNodeChildrens, List<FenceArea> currentAreas,
			FenceArea currentNode, int currentNodeAreaNum, HashMap<String, Object> paramMap) {
		for (FenceArea currentNodeChildrenNode : currentNodeChildrens) {
			if (null != currentNodeChildrenNode.getPk()) {// true 表示部门节点
				currentNodeChildrenNode.setIsDept(true);
				int currentNodeAreaNums = 0;
				if ("interceptRegion".equals(paramMap.get("interceptRegion"))) {//拦截区域
					paramMap.put("deptId", currentNodeChildrenNode.getKey());
					List<FenceArea> list = mapper.queryInterceptRegionByDept(paramMap);
					int childrenSize = list.size();
					if (childrenSize != 0) {
						if (currentNodeChildrenNode.getChildren() == null) {
							currentNodeChildrenNode.setChildren(list);
						} else {
							currentNodeChildrenNode.getChildren().addAll(list);
						}

					}
					currentNodeAreaNums=childrenSize;
					currentAreas.addAll(list);
				} else {//勤务区域巡区

					currentNodeAreaNums = this.initAreaTree(currentNodeChildrenNode, 0);
				}

				List<FenceArea> currentNodeChildrenNodeChildrens = mapper
						.querySubLevelDept(currentNodeChildrenNode.getPk());
				if (currentNodeChildrenNodeChildrens.size() != 0) {
					// 返回部门dept所有子部门具有设备数
					int childrenDeviceNum = this.getDeptAreaChildrenTreeNode(currentNodeChildrenNodeChildrens,
							currentAreas, currentNodeChildrenNode, currentNodeAreaNums, paramMap);
					if (childrenDeviceNum > 0) {
						if (currentNode != null) {
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<FenceArea>());
							}
							currentNode.getChildren().add(currentNodeChildrenNode);
						}
					}
				} else {
					// 该部门没有子部门时 sizeNum用于统计父部门下所有子部门设备总数
					currentNodeAreaNum += currentNodeAreaNums;
					if (currentNodeAreaNums > 0) {
						if (currentNode.getChildren() == null) {
							currentNode.setChildren(new ArrayList<FenceArea>());
						}
						currentNode.getChildren().add(currentNodeChildrenNode);
					}

				}
			}
		}
		return currentNodeAreaNum;

	}

	@Override
	public List<TempModel> queryBaseDateByFct_Code(String FCT_CODE) {
		// TODO Auto-generated method stub
		return mapper.queryBaseDateByFct_Code(FCT_CODE);
	}

	@Override
	public int insertArea(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.insertArea(paramMap);
	}

	@Override
	public int updateArea(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.updateArea(paramMap);
	}

	@Override
	public int deleteArea(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mapper.deleteArea(paramMap);
	}

	@Override
	public Object queryAreapageList(HashMap<String, Object> paramMap, PageInfo pageInfo) {
		// TODO Auto-generated method stubsss
		return mapper.queryAreaList(paramMap);
	}

	@Override
	public List<FenceArea> initInterceptRegionOfSpace(HashMap<String, Object> paramMap) {
		List<FenceArea> topDeptList = mapper.queryTopLevelDept();
		this.getChildrenDept(topDeptList, true);
		return topDeptList;
	}

	@Override
	public void getChildrenDept(List<FenceArea> deptList, boolean verifySpatialInfo) {
		for (FenceArea parentDept : deptList) {
			if (verifySpatialInfo) {
				String geo_spatial = parentDept.getGeo_spatial();
				if (null == geo_spatial || "".equals(geo_spatial))
					parentDept.setDisabled(true);
			}
			List<FenceArea> childrenDeptList = mapper.querySubLevelDept(parentDept.getPk());
			parentDept.setChildren(childrenDeptList);
			if (childrenDeptList.size() != 0) {
				this.getChildrenDept(childrenDeptList, true);
			}

		}

	}

	@Override
	public int importInterceptRegion(HashMap<String, Object> paramMap) {

		return mapper.importInterceptRegion(paramMap);
	}

}
