package com.cist.configManage.areaPlan.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.configManage.areaPlan.mapper.AreaPlanMapper;
import com.cist.configManage.areaPlan.model.PatrolArea;
import com.cist.configManage.areaPlan.model.TempModel;
import com.cist.configManage.areaPlan.service.AreaPlanService;

@Service
public class AreaPlanServiceImpl implements AreaPlanService {
	@Autowired
	private AreaPlanMapper mapper;

	@Override
	public List<PatrolArea> initDeptAreaTree() {
		List<PatrolArea> topDept = mapper.queryTopLevelDept();

		this.getChildrenTreeNode(topDept);
		return topDept;
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
}
