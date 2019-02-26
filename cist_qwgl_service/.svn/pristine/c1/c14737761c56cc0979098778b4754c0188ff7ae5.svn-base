package com.cist.configManage.areaPlan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.configManage.areaPlan.mapper.AreaPlanMapper;
import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.configManage.areaPlan.service.AreaPlanService;
import com.cist.frame.page.PageInfo;

@Service
public class AreaPlanServiceImpl implements AreaPlanService {
	@Autowired
	private AreaPlanMapper mapper;

	@Override
	public List<PatrolArea> initDeptAreaTree() {
		List<PatrolArea> topDept = mapper.queryTopLevelDept();
		List<PatrolArea> currentAreas = new ArrayList<PatrolArea>();
		this.getDeptAreaChildrenTreeNode(topDept, currentAreas, null, 0, new HashMap<String, Object>());
		for (PatrolArea patrolArea : topDept) {
			patrolArea.setExpanded(true);
		}
		return topDept;
	}
	@Override
	public List<PatrolArea> initDeptAreaTreeAll() {
		List<PatrolArea> topDept = mapper.queryTopLevelDept();
		this.getChildrenTreeNode(topDept);
		for (PatrolArea patrolArea : topDept) {
			patrolArea.setExpanded(true);
		}
		return topDept;
	}

	@Override
	public List<PatrolArea> deptAreaCount(List<PatrolArea> deptAreaTree) {
		Iterator<PatrolArea> iterator = deptAreaTree.iterator();
		while (iterator.hasNext()) {
			PatrolArea next = iterator.next();
			if (next.getIsDept()) {
				List<PatrolArea> children = next.getChildren();
				if (null != children)
					this.deptAreaCount(children);

			} else {
				iterator.remove();
			}
		}
		return deptAreaTree;

	}

	@Override
	public void getChildrenTreeNode(List<PatrolArea> areaList) {
		for (PatrolArea parentDept : areaList) {
			if (null != parentDept.getPk()) {
				parentDept.setIsDept(true);
				List<PatrolArea> childrenDept = mapper.querySubLevelDept(parentDept.getPk());
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
	public int getChildrenArea(List<PatrolArea> currentNodeChildrens, int currentNodeAreaNum) {
		for (PatrolArea currentNodeChildrenNode : currentNodeChildrens) {
			HashMap<String, Object> childrenMap = new HashMap<String, Object>();
			childrenMap.put("deptId", currentNodeChildrenNode.getFk_dept_id());
			childrenMap.put("areaId", currentNodeChildrenNode.getPk_id());
			List<PatrolArea> currentNodeChildrenNodeChildrens = mapper.querySubLevelArea(childrenMap);
			int childrenSize = currentNodeChildrenNodeChildrens.size();
			currentNodeAreaNum+=childrenSize;
			currentNodeChildrenNode.setChildren(currentNodeChildrenNodeChildrens);
			if (childrenSize != 0) {
				int childrenArea = this.getChildrenArea(currentNodeChildrenNodeChildrens, 0);
				currentNodeAreaNum+=childrenArea;
			}

		}
		return currentNodeAreaNum;

	}

	@Override
	public void getChildrenArea(List<PatrolArea> areaList) {
		for (PatrolArea area : areaList) {
			HashMap<String, Object> childrenMap = new HashMap<String, Object>();
			childrenMap.put("deptId", area.getFk_dept_id());
			childrenMap.put("areaId", area.getPk_id());
			List<PatrolArea> childrenArea = mapper.querySubLevelArea(childrenMap);
			area.setChildren(childrenArea);
			if (childrenArea.size() != 0) {
				this.getChildrenArea(childrenArea);
			}

		}

	}

	@Override
	public List<PatrolArea> initAreaTree(PatrolArea parentDept) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptId", parentDept.getKey());
		List<PatrolArea> parentArea = mapper.queryTopLevelArea(paramMap);
		parentDept.getChildren().addAll(parentArea);
		this.getChildrenArea(parentArea);
		return parentArea;
	}

	@Override
	public int initAreaTree(PatrolArea currentNode, int currentNodeAreaNum) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptId", currentNode.getKey());
		List<PatrolArea> currentNodeChildrens = mapper.queryTopLevelArea(paramMap);
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
	public List<PatrolArea> initDeptTree() {
		List<PatrolArea> topDept = mapper.queryTopLevelDept();
		this.getChildrenDept(topDept);
		return topDept;
	}

	@Override
	public void getChildrenDept(List<PatrolArea> deptList) {
		for (PatrolArea parentDept : deptList) {
			List<PatrolArea> childrenDept = mapper.querySubLevelDept(parentDept.getPk());
			parentDept.setChildren(childrenDept);
			if (childrenDept.size() != 0) {
				this.getChildrenDept(childrenDept);
			}
		}
	}

	@Override
	public int getDeptAreaChildrenTreeNode(List<PatrolArea> currentNodeChildrens, List<PatrolArea> currentAreas,
			PatrolArea currentNode, int currentNodeAreaNum, HashMap<String, Object> paramMap) {
		for (PatrolArea currentNodeChildrenNode : currentNodeChildrens) {
			if (null != currentNodeChildrenNode.getPk()) {// true 表示部门节点
				currentNodeChildrenNode.setIsDept(true);
				int currentNodeAreaNums = this.initAreaTree(currentNodeChildrenNode, 0);
				currentNodeChildrenNode.setArea_nums(currentNodeAreaNums);
				List<PatrolArea> currentNodeChildrenNodeChildrens = mapper
						.querySubLevelDept(currentNodeChildrenNode.getPk());
				if (currentNodeChildrenNodeChildrens.size() != 0) {
					// 返回部门dept所有子部门具有设备数
					int childrenDeviceNum = this.getDeptAreaChildrenTreeNode(currentNodeChildrenNodeChildrens,
							currentAreas, currentNodeChildrenNode, currentNodeAreaNums, paramMap);
					if (childrenDeviceNum > 0) {
						if (currentNode != null) {
							if (currentNode.getChildren() == null) {
								currentNode.setChildren(new ArrayList<PatrolArea>());
							}
							currentNode.getChildren().add(currentNodeChildrenNode);
						}
					}
				} else {
					// 该部门没有子部门时 sizeNum用于统计父部门下所有子部门设备总数
					currentNodeAreaNum += currentNodeAreaNums;
					if (currentNodeAreaNums > 0) {
						if (currentNode.getChildren() == null) {
							currentNode.setChildren(new ArrayList<PatrolArea>());
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

}
